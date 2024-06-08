package com.controller;

import com.bean.FinancialReport;
import com.dao.FinancialReportDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reports")
public class FinancialReportController {

    @Autowired
    private FinancialReportDao financialReportDao;

    @GetMapping
    public String showReport(Model model) {
        FinancialReport report = financialReportDao.generateReport();
        model.addAttribute("report", report);
        return "report/financialReport";
    }
}
