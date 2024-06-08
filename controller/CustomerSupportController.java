package com.controller;

import com.bean.CustomerSupport;
import com.dao.CustomerSupportDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/supports")
public class CustomerSupportController {

    @Autowired
    private CustomerSupportDao supportDao;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @GetMapping
    public String listSupports(Model model) {
        List<CustomerSupport> supports = supportDao.findAll();
        model.addAttribute("supports", supports);
        return "support/list";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("support", new CustomerSupport());
        return "support/form";
    }

    @PostMapping("/save")
    public String saveSupport(@ModelAttribute("support") CustomerSupport support) {
        supportDao.save(support);
        return "redirect:/supports";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        CustomerSupport support = supportDao.findById(id);
        model.addAttribute("support", support);
        return "support/form";
    }

    @PostMapping("/update")
    public String updateSupport(@ModelAttribute("support") CustomerSupport support) {
        supportDao.update(support);
        return "redirect:/supports";
    }

    @GetMapping("/delete/{id}")
    public String deleteSupport(@PathVariable("id") Long id) {
        supportDao.delete(id);
        return "redirect:/supports";
    }
}
