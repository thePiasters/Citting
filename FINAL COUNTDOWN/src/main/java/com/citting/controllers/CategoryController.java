package com.citting.controllers;


import com.citting.dao.CategoryDao;
import com.citting.entity.Category;
import com.citting.repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    CategoryDao categoryDao;

    @Autowired
    PlaceRepository placeRepository;

    @GetMapping(value="/add")
    public String addCategory(Model model)
    {
        model.addAttribute("category", new Category());
        return "category/addCategory";
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public String isAdd(@ModelAttribute Category category)
    {
        categoryDao.addCategory(category);
        return "dodano kategorię ";
    }

    @RequestMapping("/list")
    public String showList(Model model)
    {
        model.addAttribute("categories",categoryDao.getList());
        return "category/categoryList";
    }
    @RequestMapping(value="/remove/{id}", method=RequestMethod.GET)
    public String removeCategory(@PathVariable Long id)
    {
        Category category=categoryDao.findById(id);
        placeRepository.deleteAllByCategory(category);
        categoryDao.remove(category);
        return "redirect: ../list";

    }
    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public String editCategory(@PathVariable Long id,Model model)
    {
        Category category=categoryDao.findById(id);
        //categoryDao.remove(category);

        model.addAttribute("category",category);

        return "category/addCategory";
    }

    @RequestMapping(value = "/edit/{id}",method = RequestMethod.POST)
    public String addEdited(@ModelAttribute Category category)
    {
        categoryDao.update(category);
        return "redirect: ../list";
    }




}
