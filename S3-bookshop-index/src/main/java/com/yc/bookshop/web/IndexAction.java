package com.yc.bookshop.web;

import java.util.List;



import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yc.bookshop.bean.Cart;
import com.yc.bookshop.web.remote.IUserAction;
import org.springframework.web.bind.annotation.PostMapping;

import com.yc.bookshop.web.remote.IBookAction;


@Controller
public class IndexAction {
	@Resource
	private IUserAction uaction;
	
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
	@GetMapping(path= {"tobook","book.html"})
	public String tobook() {
		return "book";
	}
	/**
	   @GetMapping(path= {"toshopping","shopping.html"})
	public String toshopping() {
		return "shopping";
	}
	 
	 */
	@GetMapping(path= {"toindex","index.html"})
	public String toindex() {
		return "index";
    }
	
	
	
	
	
	@GetMapping(path= {"toregister","register.html"})
	public String toregister() {
		return "register";
	}

	/*
	 * @GetMapping(path = { "book", "book.html" }) public String book(int bt_id,
	 * Model m) { m.addAttribute("book", baction.findByBtid(bt_id)); return "book";
	 * }
	 */
	
	@GetMapping(path = { "index", "index.html" })
	public String bookType( Model m) {
		m.addAttribute("booktype", baction.findByBtid());
		return "index";
	}
	
	@PostMapping(path = { "product.do", "product.html" })
	public String books(String b_name, Model m) {
		m.addAttribute("book", baction.findByBname(b_name));
		return "product";
	}
	


	@GetMapping(path= {"toshopping","shopping.html"})
	public String toshopping(@RequestParam int uid,Model m) {
		List<Cart> carts=uaction.findByUid(uid);
		System.out.println("====="+carts);
		m.addAttribute("carts", carts);
		return "shopping";
	}

}