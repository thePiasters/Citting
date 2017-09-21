package com.citting.controllers;


import com.citting.dao.QuestionDao;
import com.citting.dao.UserDao;
import com.citting.entity.User;
import com.citting.repositories.UserPlaceRepository;
import com.citting.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserDao userDao;
    @Autowired
    UserRepository userRepository;
    @Autowired
    QuestionDao questionDao;
    @Autowired
    UserPlaceRepository userPlaceRepository;




    @GetMapping("/signUp")
    public String signUp(Model model) {

        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("questions", questionDao.getList());


        return "/user/signUp";
    }

    @RequestMapping(value = "/signUp", method =  RequestMethod.POST)
    public String idAdded(@Valid @ModelAttribute User user, BindingResult result)
    {
        if(result.hasErrors())	{
        return	"redirect:signUp";
         }


        userDao.addUser(user);
        return "user/registerSuccess";
    }

    @RequestMapping("/list")
    public String showList(Model model)
    {
        model.addAttribute("users",userDao.getList());
        return "user/usersList";
    }
    @RequestMapping(value="/remove/{id}", method=RequestMethod.GET)
    public String removeUser(@PathVariable Long id) {

        User user = userDao.findById(id);

        userPlaceRepository.deleteAllByUser(user);
        userDao.remove(user);

        return "redirect: ../list";
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public String edit(@PathVariable Long id,Model model)
    {

        User user=userDao.findById(id);
        model.addAttribute("user",user);

        return "user/signUp";

    }
    @RequestMapping(value = "/edit/{id}",method = RequestMethod.POST)
    public String addEdited(@ModelAttribute User user)
    {
        userDao.update(user);
        return "redirect: ../list";
    }

    @GetMapping(value="/signIn")
    public String checkIfUserExist()
    {
        return "user/signIn";
    }


    @RequestMapping(value="/signIn",method = RequestMethod.POST)
    public String signIn(HttpServletRequest request, HttpSession session)
    {
        String login=request.getParameter("login");
        String password=request.getParameter("password");

        if(userDao.checkifExsist(login))
        {
            User user=userRepository.findUserByEmailOrLogin(login,login);
            if(user.getPassword().equals(password))
            {

                session=request.getSession();
                session.setAttribute("user",user);
                session.setAttribute("isLogged",true);
                    if(user.getLogin().equals("admin"))
                    {
                        session.setAttribute("loggedAsAdmin",true);
                        return "redirect: /admin";
                    }
                return "account/showAccount";
            }

        }

        return "user/signIn";
    }
    @GetMapping("/passwordReminder")
    public String remindPassword(HttpServletRequest request, Model model)
    {

        return "user/passwordReminder";
    }
    @RequestMapping(value = "/passwordReminder", method = RequestMethod.POST)
    public String checkParameters(HttpServletRequest request, HttpSession sess) {

        try {
            sess = request.getSession();
            String login = request.getParameter("login");
            String email = request.getParameter("email");
            if (userDao.checkifExsist(login) && userDao.checkifExsist(email)) {
                User user = userRepository.findUserByEmailAndLogin(email, login);
                sess.setAttribute("user", user);
                return "user/retrievePassword";
            }
        } catch (NullPointerException e) {
            return "user/retrievePassword";
        }

        return "/user/passwordReminder";
    }
    @RequestMapping(value = "/logout")
    public String logOut(HttpServletRequest request, HttpSession session)
    {
        session=request.getSession();
        session.setAttribute("isLogged",false);
        session.removeAttribute("user");
        return "start";
    }

}








