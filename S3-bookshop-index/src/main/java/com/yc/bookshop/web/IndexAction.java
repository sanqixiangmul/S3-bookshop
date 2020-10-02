package com.yc.bookshop.web;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	
	
	/*
	 * public String toproduct() { return "product"; }
	 */	
	

	/*传值到页面
	 * @GetMapping(path= {"test1","test1.html"}) public ModelAndView test1() {
	 * ModelAndView mav = new ModelAndView("test1"); mav.addObject("mav", "movie");
	 * return mav; }
	 */
	
	@GetMapping(path= {"product","product.html"}) 
	public String product(@Valid Booktype booktype,Errors errors, Model m) {
		// 使用 FeIgn 远程调用 book 的服务
		// 1 定义一个接口,用于访问远程服务
		// 2 调用远程服务
		System.out.println("booktype:"+booktype.getBtId());
		if(booktype.getBtId() == null ) {
			errors.rejectValue("btId", "btIdErrors", "未传入id值");
		}else {
			m.addAttribute("booktype", baction.findByBtid());
			List<Booktype> findByBtid2 = baction.findByBtid2(booktype.getBtId());
			System.out.println("findByBtid2:"+findByBtid2);
			
	//		js  location.href . hash  ?  htpp://asss?id=1
			
			/*
			 * List<Book> findByBtid1 ;//= new ArrayList<Book>(); for(Book book :
			 * findByBtid1) { findByBtid1 = baction.findByBtid1(book.getBtId()); }
			 * System.out.println("findByBtid1:" + findByBtid1); // 推送给页面
			 * m.addAttribute("findByBtid1", findByBtid1);
			 */
			m.addAttribute("findByBtid2", findByBtid2);
			
		}
		
		return "product";
	}
	
	@RequestMapping("/product/{btId}")
    public ModelAndView code(@PathVariable(value = "btId") String btId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product");
        modelAndView.addObject("key", btId);
        System.out.println("product");
        return modelAndView;
    }
	
	@GetMapping(path= {"toshopping","shopping.html"})
	public String toshopping() {
		return "shopping";
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
	
	@GetMapping(path = { "index", "index.html","/" })
	public String bookType( Model m) {
		m.addAttribute("booktype", baction.findByBtid());
		return "index";
	}
	
	
	@PostMapping(path = { "product.do", "product.html" })
	public String books(String b_name, Model m) {
		m.addAttribute("book", baction.findByBname(b_name));
		return "product";
	}
	


}