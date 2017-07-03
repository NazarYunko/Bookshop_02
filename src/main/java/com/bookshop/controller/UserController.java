package com.bookshop.controller;

import com.bookshop.dto.DtoUtilMapper;
import com.bookshop.dto.UserDto;
import com.bookshop.entity.User;
import com.bookshop.service.CityService;
import com.bookshop.service.MailSenderService;
import com.bookshop.service.OrdersService;
import com.bookshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * Created by Nazar on 05.06.2017.
 */

// реєстрацію доробити
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MailSenderService mailSenderService;

    @Autowired
    private OrdersService ordersService;

    @GetMapping("/findUsers")
    public @ResponseBody List<UserDto> findAllUsers() {
        return DtoUtilMapper.getUsersDto(userService.findAll());
    }

    @GetMapping("/signup")
    public String signUp() {
        return "views-user-signUp";
    }

    @PostMapping("/save")
    public @ResponseBody String signUp(@RequestBody User user) {
        userService.save(user);
        String theme = "Thank's for registration!";
        String mailBody = "Confirm: http://localhost:8080/confirm/" + user.getUuid();
        mailSenderService.sendEmail(theme, mailBody, user.getEmail());
        return "200";
    }

    @GetMapping("/confirm/{uuid}")
    public String confirm(@PathVariable String uuid) {
        User user = userService.findByUuid(uuid);
        user.setEnabled(true);
        userService.update(user);
        return "redirect:/";
    }

    @GetMapping("/signin")
    public String signIn() {
        return "views-user-signIn";
    }

    @PostMapping("/failurelogin")
    public String failureLogin(Model model) {
        model.addAttribute("userException", "Login or password is wrong!");
        return "views-user-signIn";
    }

    @GetMapping("/profile")
    public String profile(Principal principal, Model model) {
        if (principal.getName().equals("admin")) {
            return "views-user-adminProfile";
        } else {
            model.addAttribute("user", userService.findUserWithOrders(Integer.parseInt(principal.getName())));
            model.addAttribute("order", ordersService.findUserOrders(
                    userService.findOne(Integer.parseInt(principal.getName()))));
            return "views-user-profile";
        }
    }

    @PostMapping("/logout")
    public String logout() {
        return "redirect:/";
    }
}