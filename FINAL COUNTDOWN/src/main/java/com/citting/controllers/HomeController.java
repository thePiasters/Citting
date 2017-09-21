package com.citting.controllers;

import com.citting.dao.PlaceDao;
import com.citting.entity.Category;
import com.citting.entity.Place;
import com.citting.dao.CategoryDao;
import com.citting.entity.User;
import com.citting.repositories.PlaceRepository;
import com.citting.repositories.UserPlaceRepository;
import com.citting.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CategoryDao categoryDao;

    @Autowired
    PlaceDao placeDao;

    @Autowired
    PlaceRepository placeRepository;
    @Autowired
    UserPlaceRepository userPlaceRepository;
    @Autowired
    UserRepository userRepository;


    @GetMapping("/")
    public String start()
    {
        return "start";
    }

    @GetMapping("/index")
    String home()
    {
        return "index";
    }



    @ModelAttribute("categories")
    public Collection<Category> showCategories() {
        return this.categoryDao.getList();
    }



    @GetMapping("/home")
    public String home2()
    {
        return "home";
    }

    @GetMapping
    public String admin()
    {
        return "account/admin";
    }


    @RequestMapping(value = "/home",method = RequestMethod.POST)
    public String postCategories(HttpServletRequest request, Model model,HttpSession session){
        try{
            List<Category> listCategory = new ArrayList<>();
            List<Place> listPlace = new ArrayList<>();
            session = request.getSession();

            String[] categories = request.getParameterValues("categories");

            //looking for chosen in form Categories
            for (int i = 0; i < categories.length; i++) {
                listCategory.add(categoryDao.findById(Integer.parseInt(categories[i])));
            }


            //looking for places with chosen Categories

            for (Category category : listCategory) {
                listPlace.addAll(placeRepository.findAllByCategory(category));

            }
            model.addAttribute("listPlace", listPlace);
            // session.setAttribute("generatedPlaces",listPlace);
        }catch(NullPointerException e)
        {
            return "home";
        }

        return "generatePlaces";

    }

    @RequestMapping("/test")
    @ResponseBody
    public String test()
    {
        User user= userRepository.findUserByEmailOrLogin("Mordulec4ever","Mordulec4ever");
        userPlaceRepository.deleteAllByUser(user);
        userRepository.delete(user);
        return "działa działa działa";
    }




}
