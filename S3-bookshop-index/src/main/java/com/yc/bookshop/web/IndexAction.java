package com.yc.bookshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexAction {
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping(path= {"tologin","login.html"})
	public String tologin() {
		return "login";
	}
	
	@GetMapping(path= {"toindex","index.html"})
	public String toindex() {
		return "index";
    }
	
	@GetMapping(path= {"toproduct","product.html"})
	public String toproduct() {
		return "product";
	}
	
	@GetMapping(path= {"toshopping","shopping.html"})
	public String toshopping() {
		return "shopping";
	}
	
	@GetMapping(path= {"toregister","register.html"})
	public String toregister() {
		return "register";
	}
	




	
	
	

}
