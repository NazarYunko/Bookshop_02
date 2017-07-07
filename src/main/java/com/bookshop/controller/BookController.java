package com.bookshop.controller;

import com.bookshop.entity.Book;
import com.bookshop.service.AuthorService;
import com.bookshop.service.BookService;
import com.bookshop.service.GenreService;
import com.bookshop.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

/**
 * Created by Study on 10.06.2017.
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private GenreService genreService;

    @Autowired
    private PublisherService publisherService;

    @PostMapping("/findByName")
    @ResponseBody
    public boolean findByName(@RequestBody String bookName) {
        return bookService.findByName(bookName);
    }

    @GetMapping("/addbook")
    public String addBook() {
        return "views-book-addBook";
    }

    @PostMapping("/addbook")
    public String addBook(@RequestParam String name,
                          @RequestParam int genreId,
                          @RequestParam String description,
                          @RequestParam float countOfPages,
                          @RequestParam int authorId,
                          @RequestParam String dateOfPublication,
                          @RequestParam int publisherId,
                          @RequestParam float quantity,
                          @RequestParam float price,
                          @RequestParam MultipartFile image) {

        bookService.save(new Book(name, genreService.findOne(genreId),
                description, ((int) countOfPages), authorService.findOne(authorId), LocalDate.parse(dateOfPublication),
                publisherService.findOne(publisherId), price, ((int) quantity)), image);

        return "redirect:/books";
    }

    @GetMapping("/books")
    public String allBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "views-book-allBooks";
    }

    @GetMapping("/books/{id}")
    public String bookInfo(@PathVariable int id, Model model) {
        model.addAttribute("book", bookService.findOne(id));
        return "views-book-bookInfo";
    }

    @GetMapping("/deletebook/{id}")
    public String deleteBook(@PathVariable int id) {
        bookService.delete(id);
        return "redirect:/books";
    }

    @GetMapping("/updatebook/{id}")
    public String updateBook(@PathVariable int id, Model model) {
        model.addAttribute("currentBook", bookService.findOne(id));
        model.addAttribute("authors", authorService.findAll());
        model.addAttribute("genres", genreService.findAll());
        model.addAttribute("publishers", publisherService.findAll());
        return "views-book-updateBook";
    }

    @PostMapping("/updatebook/{id}")
    public String updateBook(@PathVariable int id,
                             @RequestParam String name,
                             @RequestParam int genreId,
                             @RequestParam String description,
                             @RequestParam float countOfPages,
                             @RequestParam int authorId,
                             @RequestParam String dateOfPublication,
                             @RequestParam int publisherId,
                             @RequestParam float quantity,
                             @RequestParam float price,
                             @RequestParam MultipartFile image) {
        Book book = bookService.findOne(id);
        book.setName(name);
        book.setGenre(genreService.findOne(genreId));
        book.setDescription(description);
        book.setCountOfPages((int) countOfPages);
        book.setAuthor(authorService.findOne(authorId));
        book.setPublisher(publisherService.findOne(publisherId));
        book.setDateOfPublication(LocalDate.parse(dateOfPublication));
        book.setQuantity((int) quantity);
        book.setPrice(price);
        bookService.update(book, image);
        return "redirect:/books";
    }

}
