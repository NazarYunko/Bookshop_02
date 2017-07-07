package com.bookshop.controller;

import com.bookshop.dto.AuthorDto;
import com.bookshop.dto.DtoUtilMapper;
import com.bookshop.entity.Author;
import com.bookshop.service.AuthorService;
import com.bookshop.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Nazar on 09.06.2017.
 */
//make update and design
@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private CityService cityService;

    @GetMapping("/getAuthors")
    @ResponseBody
    public List<AuthorDto> getAllAuthors(){
        return DtoUtilMapper.getNotFullAuthorsDto(authorService.findAll());
    }

    @PostMapping("/updateAuthorValidation")
    @ResponseBody
    public boolean updateAuthorValidation(@RequestBody Author author) {
        return authorService.updateAuthorValidation(author);
    }

    @PostMapping("/getAuthorByNameAndLastName")
    @ResponseBody
    public AuthorDto getAuthorByNameAndLastName(@RequestBody Author author) {
        return DtoUtilMapper.getFullAuthorDto(authorService.findByNameAndLastName(author.getName(), author.getLastName()));
    }

    @GetMapping("/addauthor")
    public String addAuthor() {
        return "views-author-addAuthor";
    }

    @PostMapping("/addauthor")
    public String addAuthor(@RequestParam String name,
                            @RequestParam String lastName,
                            @RequestParam String biography,
                            @RequestParam int cityId,
                            @RequestParam String dateOfBirth,
                            @RequestParam MultipartFile image) {
        authorService.save(new Author(name, lastName, LocalDate.parse(dateOfBirth), biography, cityService.findOne(cityId)), image);
        return "redirect:/authors";
    }

    @GetMapping("/authors")
    public String allAuthors(Model model) {
        model.addAttribute("authors", DtoUtilMapper.getNotFullAuthorsDto(authorService.findAll()));
        return "views-author-allAuthors";
    }

    @GetMapping("/authors/{id}")
    public String authorInfo(@PathVariable int id, Model model) {
        model.addAttribute("author", DtoUtilMapper.getFullAuthorDto(authorService.findOne(id)));
        return "views-author-authorInfo";
    }

    @PostMapping("/deleteauthor/{id}")
    public String deleteAuthor(@PathVariable int id) {
        authorService.delete(id);
        return "redirect:/authors";
    }

    @GetMapping("/updateauthor/{id}")
    public String updateAuthor(@PathVariable int id, Model model) {
        model.addAttribute("currentAuthor", DtoUtilMapper.getFullAuthorDto(authorService.findOne(id)));
        return "views-author-updateAuthor";
    }

    @PostMapping("/updateauthor/{id}")
    public String updateAuthor(@PathVariable int id,
                               @RequestParam String name,
                               @RequestParam String lastName,
                               @RequestParam String biography,
                               @RequestParam String dateOfBirth,
                               @RequestParam int cityId,
                               @RequestParam MultipartFile image) {
        Author author = authorService.findOne(id);
        author.setName(name);
        author.setLastName(lastName);
        author.setBiography(biography);
        author.setDateOfBirth(LocalDate.parse(dateOfBirth));
        author.setCity(cityService.findOne(cityId));
        authorService.update(author, image);
        return "redirect:/authors/{id}";
    }

}
