package com.controller;

import com.bean.Loan;
import com.dao.LoanDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanDao loanDao;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new org.springframework.beans.propertyeditors.CustomDateEditor(dateFormat, false));
    }

    @GetMapping
    public String listLoans(Model model) {
        List<Loan> loans = loanDao.findAll();
        model.addAttribute("loans", loans);
        return "loan/list";
    }

    @GetMapping("/new")
    public String showLoanForm(Model model) {
        model.addAttribute("loan", new Loan());
        return "loan/form";
    }

    @PostMapping("/save")
    public String saveLoan(@ModelAttribute Loan loan) {
        loanDao.save(loan);
        return "redirect:/loans";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Loan loan = loanDao.findById(id);
        model.addAttribute("loan", loan);
        return "loan/form";
    }

    @PostMapping("/update")
    public String updateLoan(@ModelAttribute Loan loan) {
        loanDao.update(loan);
        return "redirect:/loans";
    }

    @GetMapping("/delete/{id}")
    public String deleteLoan(@PathVariable Long id) {
        loanDao.delete(id);
        return "redirect:/loans";
    }
}
