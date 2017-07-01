package com.bookshop.controller;

import com.bookshop.entity.Publisher;
import com.bookshop.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Nazar on 08.06.2017.
 */
@Controller
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping("/publishers")
    public String allPublishers(Model model) {
        model.addAttribute("publishers", publisherService.findAll());
        return "views-publisher-allPublishers";
    }

    @GetMapping("/publishers/{id}")
    public String publisherInfo(@PathVariable int id, Model model) {
        model.addAttribute("publisher", publisherService.findOne(id));
        return "views-publisher-publisherInfo";
    }

    @GetMapping("/addpublisher")
    public String addPublisher(Model model) {
        model.addAttribute("publishers", publisherService.findAll());
        return "views-publisher-addPublisher";
    }

    @PostMapping("/addpublisher")
    public String addPublisher(@RequestParam String name, @RequestParam MultipartFile image, Model model) {
        publisherService.save(new Publisher(name), image);
        return "redirect:/addpublisher";
    }

    @GetMapping("/deletepublisher/{id}")
    public String deletePublisher(@PathVariable int id) {
        publisherService.delete(id);
        return "redirect:/addpublisher";
    }

    @GetMapping("/updatepublisher/{id}")
    public String updatePublisher(@PathVariable int id,
                                  Model model) {
        model.addAttribute("currentPublisher", publisherService.findOne(id));
        return "views-publisher-updatePublisher";
    }

    @PostMapping("/updatepublisher/{id}")
    public String updatePublisher(@PathVariable int id,
                                  @RequestParam String name,
                                  @RequestParam MultipartFile image,
                                  Model model) {
        Publisher publisher = publisherService.findOne(id);
        publisher.setName(name);
        publisherService.update(publisher, image);
        return "redirect:/addpublisher";
    }

}
