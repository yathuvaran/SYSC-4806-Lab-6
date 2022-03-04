package addressBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collections;

@Controller
public class AddressBookController {
    @Autowired
    AddressBookRepository addressBookRepository;
    @GetMapping("/addressbooks")
    public String address(Model model) {
        ArrayList<AddressBook> books = (ArrayList<AddressBook>) addressBookRepository.findAll();
        model.addAttribute("books", books);
        return "addressbooks";
    }

    @GetMapping("/addressbookbuddyinfos")
    public String bookbuddies(Model model, @RequestParam(name="bookid", required=true) Long id) {
        ArrayList<AddressBook> books = (ArrayList<AddressBook>) addressBookRepository.findAllById(Collections.singleton(id));

        for(BuddyInfo a : books.get(0).getBuddies()){System.out.println(a);}

        model.addAttribute("buddies", books.get(0).getBuddies());
        return "addressbookbuddyinfos";
    }

    @GetMapping("/result")
    public String greetingSubmit(Model model) {
        return "result";
    }

    @GetMapping("/createaddressbook")
    public String greetingForm(Model model) {
        model.addAttribute("book", new AddressBook());
        return "createaddressbook";
    }

    @PostMapping("/addContact")
    public String addContact(AddressBook book) {
        book.addBuddy(new BuddyInfo());
        return "createaddressbook :: contacts";
    }
}