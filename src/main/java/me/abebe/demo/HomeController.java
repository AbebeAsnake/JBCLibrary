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
    public String IndexPage(AddBook addBook,Model model){

        model.addAttribute("addBook",addBookRepository.findAll());
        return "index";

    }

    @GetMapping("/add")
    public String addressBookForm(Model model) {
        model.addAttribute("addBook", new AddBook());

        return "addbook";
    }

    @PostMapping("/process")
    public String processForm(@Valid AddBook addBook, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addbook";
        }
        addBookRepository.save(addBook);
        model.addAttribute("saveAction", "book has been inserted/updated successfully");

        return "redirect:/";
    }

    @RequestMapping("/borrow/{id}")
    public String BorrowBook(@PathVariable("id") long id, Model model) {
        model.addAttribute("addBook", addBookRepository.findOne(id));
      AddBook books2 = addBookRepository.findOne(id);
      books2.setState("borrowed");
      model.addAttribute("borrowed",books2);
        return "borrow";
    }
    @RequestMapping("/return/{id}")
    public String ReturnBook(@PathVariable("id") long id, Model model) {
        model.addAttribute("addBook", addBookRepository.findOne(id));
        AddBook books2 = addBookRepository.findOne(id);
        books2.setState("borrowed");
        model.addAttribute("borrowed",books2);
        return "return";
    }
    @RequestMapping("/search/{state}")
    public String searchAddressBookByFirstName(@PathVariable("state") String state, Model model){

        Iterable<AddBook> books= addBookRepository.findAddBookByState(state);
        model.addAttribute("addBook",books);

        return "searchvalue";
    }


}
