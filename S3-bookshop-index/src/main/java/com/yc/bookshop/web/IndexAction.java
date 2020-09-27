package com.yc.bookshop.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yc.bookshop.web.remote.IBookAction;


@Controller
public class IndexAction {
	@Resource
	private IBookAction baction;
	
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
	@GetMapping(path = { "book", "book.html" })
	public String book(int bt_id, Model m) {
		m.addAttribute("book", baction.findByBtid(bt_id));
		return "book";
	}
	





}


