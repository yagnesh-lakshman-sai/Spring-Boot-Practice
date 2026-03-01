package in.smbs.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.smbs.entity.Book;
import in.smbs.repository.BookRepository;

@Controller
public class BookController {

	@Autowired
	private BookRepository repo;

	@GetMapping("/book")
	public String getBookById(@RequestParam("id") Integer id, Model model) {
		Optional<Book> findById = repo.findById(id);
		if (findById.isPresent()) {
			Book bookObj = findById.get();
			model.addAttribute("book", bookObj);
		}
		return "index";
	}
}








