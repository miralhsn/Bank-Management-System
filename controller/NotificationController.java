package com.controller;

import com.bean.Notification;
import com.dao.NotificationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationDao notificationDao;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new org.springframework.beans.propertyeditors.CustomDateEditor(dateFormat, false));
    }

    @GetMapping
    public String listNotifications(Model model) {
        List<Notification> notifications = notificationDao.findAll();
        model.addAttribute("notifications", notifications);
        return "notification/list";
    }

    @GetMapping("/new")
    public String showNotificationForm(Model model) {
        model.addAttribute("notification", new Notification());
        return "notification/form";
    }

    @PostMapping("/save")
    public String saveNotification(@ModelAttribute Notification notification) {
        notificationDao.save(notification);
        return "redirect:/notifications";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Notification notification = notificationDao.findById(id);
        model.addAttribute("notification", notification);
        return "notification/form";
    }

    @PostMapping("/update")
    public String updateNotification(@ModelAttribute Notification notification) {
        notificationDao.update(notification);
        return "redirect:/notifications";
    }

    @GetMapping("/delete/{id}")
    public String deleteNotification(@PathVariable Long id) {
        notificationDao.delete(id);
        return "redirect:/notifications";
    }
}
