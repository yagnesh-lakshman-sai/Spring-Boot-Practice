package in.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.com.entity.Product;
import in.com.repo.ProductRepository;

@Controller
public class ProductController {

	@Autowired
	private ProductRepository repo;

	@GetMapping("/products")
	public String loadProducts(Model model) {
		model.addAttribute("products", repo.findAll());
		return "data";
	}

	@GetMapping("/")
	public String loadForm(Model model) {
		model.addAttribute("p", new Product());
		return "index";
	}

	@PostMapping("/product")
	public String handleSave(@ModelAttribute("p") Product p, Model model) {
		p = repo.save(p);
		if (p.getPid() != null) {
			model.addAttribute("msg", "Product Saved");
		}
		return "index";
	}
}
