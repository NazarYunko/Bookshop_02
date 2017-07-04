package com.bookshop.controller;

import com.bookshop.dto.DtoUtilMapper;
import com.bookshop.dto.PublisherDto;
import com.bookshop.entity.Publisher;
import com.bookshop.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Nazar on 08.06.2017.
 */
@RestController
@RequestMapping("/publisher")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping
    public List<PublisherDto> findAllPublishers(){
        return DtoUtilMapper.getPublishersDto(publisherService.findAll());
    }

    @PostMapping
    public boolean savePublisher(@RequestBody Publisher publisher) {
        return publisherService.save(publisher);
    }

    @DeleteMapping
    public String deletePublisher(@RequestBody String publisherId) {
        publisherService.delete(Integer.parseInt(publisherId));
        return "200";
    }

    @PutMapping
    public boolean updatePublisher(@RequestBody Publisher publisher) {
        return publisherService.update(publisher);
    }
}
