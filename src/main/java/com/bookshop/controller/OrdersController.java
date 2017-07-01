package com.bookshop.controller;

import com.bookshop.entity.OrdersBookId;
import com.bookshop.service.BookService;
import com.bookshop.service.OrdersBookService;
import com.bookshop.service.OrdersService;
import com.bookshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

/**
 * Created by Nazar on 14.06.2017.
 */
@Controller
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private OrdersBookService ordersBookService;

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @PostMapping("/books/{id}")
    public String addToOrder(Principal principal,
                              @RequestParam int quantity,
                              @PathVariable int id) {
        ordersService.addToOrder(userService.findUserWithOrders(Integer.parseInt(principal.getName())), bookService.findOne(id), quantity);
        return "redirect:/books/{id}";
    }

    @GetMapping("/profile/removebook/{orderId}/{bookId}")
    public String removeBookFromOrder(@PathVariable int orderId,
                                      @PathVariable int bookId) {
        ordersBookService.delete(new OrdersBookId(ordersService.findOne(orderId), bookService.findOne(bookId)));
        return "redirect:/profile";
    }

    @PostMapping("/profile/buy/{id}")
    public String buy(@PathVariable int id) {
        ordersService.buy(ordersService.findWithOrdersBook(id));
        return "redirect:/profile";
    }
}
