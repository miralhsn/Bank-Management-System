package com.controller;

import com.bean.Transaction;
import com.dao.TransactionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionDao transactionDao;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new org.springframework.beans.propertyeditors.CustomDateEditor(dateFormat, false));
    }

    @GetMapping
    public String listTransactions(Model model) {
        List<Transaction> transactions = transactionDao.findAll();
        model.addAttribute("transactions", transactions);
        return "transaction/list";
    }

    @GetMapping("/new")
    public String showTransactionForm(Model model) {
        model.addAttribute("transaction", new Transaction());
        return "transaction/form";
    }

    @PostMapping("/save")
    public String saveTransaction(@ModelAttribute Transaction transaction) {
        transactionDao.save(transaction);
        return "redirect:/transactions";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Transaction transaction = transactionDao.findById(id);
        model.addAttribute("transaction", transaction);
        return "transaction/form";
    }

    @PostMapping("/update")
    public String updateTransaction(@ModelAttribute Transaction transaction) {
        transactionDao.update(transaction);
        return "redirect:/transactions";
    }

    @GetMapping("/delete/{id}")
    public String deleteTransaction(@PathVariable Long id) {
        transactionDao.delete(id);
        return "redirect:/transactions";
    }
}
