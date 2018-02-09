package me.abebe.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    AddBookRepository addBookRepository;

    @RequestMapping("/")
    public String IndexPage(Model model){
        model.addAttribute("addBook",addBookRepository.findAll());
        return "index";

    }

    @GetMapping("/add")
    public String addressBookForm(Model model) {
        model.addAttribute("addBook", new AddBook());

        return "addbook";
    }

    @PostMapping("/process")
    public String processForm(@Valid @ModelAttribute AddBook addBook, BindingResult result) {
        if (result.hasErrors()) {
            return "addbook";
        }
        addBookRepository.save(addBook);


        return "redirect:/";
    }

    @RequestMapping("/borrow/{id}")
    public String BorrowBook(@PathVariable("id") long id, Model model) {
        model.addAttribute("addBook", addBookRepository.findOne(id));
        model.addAttribute("saveAction", "book has been borowed/returned successfully");

        return "borrow";
    }
    @RequestMapping("/return/{id}")
    public String ReturnBook(@PathVariable("id") long id, Model model) {
        model.addAttribute("addBook", addBookRepository.findOne(id));
        return "return";
    }
    @RequestMapping("/search/{state}")
    public String searchAddressBookByFirstName(@PathVariable("state") String state, Model model){

        Iterable<AddBook> books= addBookRepository.findAddBookByState(state);
        model.addAttribute("addBook",books);

        return "searchvalue";
    }


}
