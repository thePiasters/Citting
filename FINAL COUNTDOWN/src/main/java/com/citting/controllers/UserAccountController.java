package com.citting.controllers;

import com.citting.dao.CategoryDao;
import com.citting.dao.PlaceDao;
import com.citting.dao.UserDao;

import com.citting.entity.Place;
import com.citting.entity.User;
import com.citting.entity.UserPlace;
import com.citting.repositories.PlaceRepository;
import com.citting.repositories.UserPlaceRepository;

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
public class UserAccountController {

    @Autowired
    UserDao userDao;

    @Autowired
    UserPlaceRepository userPlaceRepository;

    @Autowired
    PlaceDao placeDao;

    @Autowired
    CategoryDao categoryDao;

    @Autowired
    PlaceRepository placeRepository;



    @RequestMapping("/profile")
    public String mainPage(HttpServletRequest request, HttpSession session)
    {
        return "account/showAccount";
    }

    @GetMapping("/addedToWishList")
    public String addedToWhishList(HttpServletRequest request, HttpSession session)
    {
        session= request.getSession();

        Place place= (Place) session.getAttribute("generatedPlace");
        User user= (User) session.getAttribute("user");

        List<UserPlace> userPlaces=user.getUserplace();

        try{

            UserPlace userPlace = userPlaceRepository.findFirstByUserAndPlace(user, place);
            userPlace.setWishList(true);
            userPlaceRepository.save(userPlace);
        }
        catch (NullPointerException e)
        {
            UserPlace userPlace= new UserPlace();
            userPlace.setPlace(place);
            userPlace.setUser(user);
            userPlace.setWishList(true);
            userPlaces.add(userPlace);
            userPlaceRepository.save(userPlace);
        }





        return "account/modifiedWishList";
    }
    @GetMapping("/wishlist")
    public String whishlist(HttpSession session, HttpServletRequest request)
    {
       session= request.getSession();

       User user= (User) session.getAttribute("user");

       List<UserPlace> userPlaceList= userPlaceRepository.findAllByUserAndWishListIsTrue(user);

       session.setAttribute("wishList",userPlaceList);


       return  "account/wishlist";
    }

    @GetMapping("/addedToHistory")
    public String addedToHistory(HttpServletRequest request, HttpSession session)
    {

        session= request.getSession();

        Place place= (Place) session.getAttribute("generatedPlace");
        User user= (User) session.getAttribute("user");

        List<UserPlace> userPlaces=user.getUserplace();

        try{

        UserPlace userPlace = userPlaceRepository.findFirstByUserAndPlace(user, place);
        userPlace.setHistory(true);
            userPlaceRepository.save(userPlace);
        }
        catch (NullPointerException e)
        {
           UserPlace userPlace= new UserPlace();
            userPlace.setPlace(place);
            userPlace.setUser(user);
            userPlace.setHistory(true);
            userPlaces.add(userPlace);
            userPlaceRepository.save(userPlace);
        }


        return "account/modifiedHistory";

    }

    @RequestMapping("/history")
    public String history(HttpSession session, HttpServletRequest request)
    {
        session= request.getSession();


        User user= (User) session.getAttribute("user");

        List<UserPlace> userPlaceList= userPlaceRepository.findAllByUserAndHistoryIsTrue(user);

        session.setAttribute("visitedPlaces",userPlaceList);


        return  "account/history";
    }
    @RequestMapping("/deleteFromWishList/{id}")
    public String deleteFromWishList(@PathVariable Long id,HttpSession session, HttpServletRequest request)
    {
        session =request.getSession();
        User user=(User) session.getAttribute("user");
        UserPlace userPlace =userPlaceRepository.findFirstByUserAndPlaceAndAndWishListIsTrue(user,placeDao.findById(id));
         userPlace.setWishList(false);
         userPlaceRepository.save(userPlace);



        return "redirect: /wishlist";
    }
      @RequestMapping("/deleteFromHistory/{id}")
      public String deleteFromHistoryList(@PathVariable Long id,HttpSession session, HttpServletRequest request)
      {
          session = request.getSession();
          User user=(User) session.getAttribute("user");
          UserPlace userPlace =userPlaceRepository.findFirstAllByUserAndPlaceAndHistoryIsTrue(user,placeDao.findById(id));
           userPlace.setHistory(false);
           userPlace.setOpinion("");
           userPlace.setRate(0);
           userPlaceRepository.save(userPlace);

           return  "redirect: /history";
      }

    @ModelAttribute("allPlaces")
    public Collection<Place> showCategories() {
        return this.placeRepository.findAll();
    }

    @RequestMapping("/allPlaces")
    public String allPlaces(Model model)
      {


          return "account/allPlaces";
      }

    @RequestMapping(value = "/allPlaces", method = RequestMethod.POST)
    public String allPlacesPost(Model model, HttpServletRequest request)
    {
        String search= request.getParameter("search");
        List<Place> places=placeDao.getList();

        ArrayList<Place> placesList = new ArrayList<>();

        for(Place place: places)
        {
            if(place.getName().contains(search))
            {
                placesList.add(place);
            }
        }



        model.addAttribute("places",placesList);


        return "account/allPlaces";
    }
    @GetMapping(value="/rate/{id}")
    public String review(@PathVariable Long id, Model model)
    {
            UserPlace userPlace =userPlaceRepository.findById(id);
            model.addAttribute("userPlace",userPlace);
        return "account/rate";
    }
    @RequestMapping(value="/rate/{id}", method=RequestMethod.POST)
    public String rev(@ModelAttribute UserPlace userPlace, @PathVariable Long id)
    {

        userPlace.setUser(userPlaceRepository.findById(id).getUser());
        userPlace.setPlace(userPlaceRepository.findById(id).getPlace());
        userPlace.setHistory(userPlaceRepository.findById(id).isHistory());
        userPlace.setWishList(userPlaceRepository.findById(id).isWishList());
        userPlaceRepository.save(userPlace);

        return "redirect: /place/page/"+userPlaceRepository.findById(id).getPlace().getId();
    }
    @RequestMapping(value="/viewRate")
    public String viewRate(HttpServletRequest request, HttpSession session, Model model)
    {
        session=request.getSession();
        model.addAttribute("userPlace",userPlaceRepository.findAllByUser((User) session.getAttribute("user")));

        return "account/opinionList";
    }
    @RequestMapping(value="/removeOpinion/{id}")
    public String removeOpinion(@PathVariable Long id)
    {
        UserPlace userPlace =userPlaceRepository.findById(id);
        userPlace.setOpinion("");
        userPlace.setRate(0);
        userPlaceRepository.save(userPlace);
        return "redirect: /viewRate";
    }



}
