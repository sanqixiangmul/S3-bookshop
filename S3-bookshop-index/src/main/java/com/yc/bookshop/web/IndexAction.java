package com.yc.bookshop.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yc.bookshop.bean.Booktype;
import com.yc.bookshop.web.remote.IBooktypeAction;

@Controller
public class IndexAction {
	
	@Resource
	private IBooktypeAction btaction;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping(path= {"/toproduct", "product.html"})
	public String toproduct() {
		return "product";
	}
	
	@PostMapping("product")
	public String product(Model m) {
		List<Booktype> type = btaction.getBooktypes();
		m.addAttribute("type", type);
		return "product";
	}
	
	@GetMapping("/book")
	public String book() {
		return "book";
	}
}


