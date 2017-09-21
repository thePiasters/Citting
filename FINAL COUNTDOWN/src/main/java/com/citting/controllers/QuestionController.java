package com.citting.controllers;



import com.citting.dao.QuestionDao;
import com.citting.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionDao questionDao;

    @GetMapping(value = "/add")
    public String addQuestion(Model model) {
        model.addAttribute("question", new Question());
        return "question/addQuestion";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String isAdd(@ModelAttribute Question question) {
        questionDao.addQuestion(question);
        return "added question ";
    }

    @RequestMapping("/list")
    public String showList(Model model) {
        model.addAttribute("questions", questionDao.getList());
        return "question/questionsList";
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String removeCategory(@PathVariable Long id) {
        Question question = questionDao.findById(id);
        questionDao.remove(question);
        return "redirect: ../list";

    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editCategory(@PathVariable Long id, Model model) {
        Question question = questionDao.findById(id);

        model.addAttribute("question", question);

        return "question/addQuestion";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String addEdited(@ModelAttribute Question category) {
        questionDao.update(category);
        return "redirect: ../list";
    }
}