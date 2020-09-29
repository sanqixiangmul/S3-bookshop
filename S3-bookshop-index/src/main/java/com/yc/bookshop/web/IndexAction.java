package com.yc.bookshop.web;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yc.bookshop.bean.Book;
import com.yc.bookshop.bean.Booktype;
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
	
	@PostMapping("product")
	public String product(@Valid Booktype booktype,Errors errors, Model m) {
		// 使用 FeIgn 远程调用 book 的服务
		// 1 定义一个接口,用于访问远程服务
		// 2 调用远程服务
		List<Book> findByBtid1 = baction.findByBtid1(booktype.getBook());
		List<Booktype> findByBtid = baction.findByBtid(booktype);
		if(booktype.getBtId() == null ) {
			errors.rejectValue("btId", "btIdErrors", "未传入id值");
		}else {
			// 推送给页面
			m.addAttribute("findByBtid", findByBtid);
			m.addAttribute("findByBtid1", findByBtid1);
		}
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
	/*暂时忽略
	 * @GetMapping(path = { "book", "book.html" }) public String book(int bt_id,
	 * Model m) { m.addAttribute("book", baction.findByBtid(bt_id)); return "book";
	 * }
	 */
	





}