package com.yc.bookshop.web;

import java.util.List;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yc.bookshop.bean.Cart;
import com.yc.bookshop.bean.User;
import com.yc.bookshop.web.remote.IUserAction;

@Controller
public class IndexAction {
	@Resource
	private IUserAction uaction;
	
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
	
	
	
	@GetMapping(path= {"toregister","register.html"})
	public String toregister() {
		return "register";
	}
	


	@GetMapping(path= {"toshopping","shopping.html"})
	public String toshopping(@RequestParam int uid,Model m) {
		List<Cart> carts=uaction.findByUid(uid);
		System.out.println("====="+carts);
		m.addAttribute("carts", carts);
		return "shopping";
	}


	
}


