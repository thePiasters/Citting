package com.citting.controllers;

import com.citting.dao.PlaceDao;
import com.citting.entity.Category;
import com.citting.entity.Place;
import com.citting.dao.CategoryDao;
import com.citting.entity.User;
import com.citting.entity.UserPlace;
import com.citting.repositories.UserPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/place")
public class PlaceController {

    @Autowired
    PlaceDao placeDao;

    @Autowired
    CategoryDao categoryDao;

    @Autowired
    UserPlaceRepository userPlaceRepository;

    @ModelAttribute("categories")
    public Collection<Category> populateGropups() {
        return this.categoryDao.getList();
    }

    @GetMapping("/add")
    public String addPlace(Model model)
    {

        model.addAttribute("place", new Place());
        return "place/addPlace";
    }
    @RequestMapping(value = "/add", method =  RequestMethod.POST)
    @ResponseBody
    public String idAdded(@ModelAttribute Place place)
    {
     placeDao.addPlace(place);
        return "it worked";
    }

    @RequestMapping("/list")
    public String showList(Model model)
    {
        model.addAttribute("places",placeDao.getList());
        return "place/placesList";
    }
    @RequestMapping(value="/remove/{id}", method=RequestMethod.GET)
    public String removePlace(@PathVariable Long id) {
        Place place = placeDao.findById(id);
        placeDao.remove(place);
        return "redirect: ../list";
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public String editPlace(@PathVariable Long id,Model model)
    {
        Place place=placeDao.findById(id);
        model.addAttribute("place",place);

        return "place/addPlace";

    }
    @RequestMapping(value = "/edit/{id}",method = RequestMethod.POST)
    public String addEdited(@ModelAttribute Place place)
    {
        placeDao.update(place);
        return "redirect: ../list";
    }
    public void updateRate(List<UserPlace> list,Place place)
    {
        double sum=0;
        int all=list.size();
        for(UserPlace userPlace:list)
        {
            if(userPlace.getRate()!=0) {
                sum += userPlace.getRate();
            }
            else
            {
                all--;
            }

        }
        if(sum!=0) {
            place.setRate(sum / all);
            placeDao.update(place);
        }
    }
    @RequestMapping(value="/page/{id}")
    public String viewGenerated(  @PathVariable Long id, HttpSession session, HttpServletRequest request, Model model)
    {
        session=request.getSession();
        User user= (User) session.getAttribute("user");


        Place place=placeDao.findById(id);
        List<UserPlace> userPlaceList=userPlaceRepository.findAllByPlace(place);

        UserPlace userPlace=userPlaceRepository.findFirstByUserAndPlace(user,place);



       updateRate(userPlaceList,place);

       model.addAttribute("userPlace",userPlace);
        model.addAttribute("userPlaceList",userPlaceList);
        session.setAttribute("generatedPlace",place);

        return "place/viewGeneratedPlace";
    }

}
