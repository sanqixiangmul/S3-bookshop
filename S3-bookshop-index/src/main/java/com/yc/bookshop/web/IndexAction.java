package com.yc.bookshop.web;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.yc.bookshop.bean.Result;
import com.yc.bookshop.bean.User;
import com.yc.bookshop.web.remote.IBookAction;
import com.yc.bookshop.web.remote.IUserAction;


@Controller
@SessionAttributes ("loginedUser")

public class IndexAction {
	@Resource
	private IBookAction baction;
	

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
	
	@PostMapping("product")
	public String product() {
		return "product";
	}
	
	@GetMapping(path= {"toshopping","shopping.html"})
	public String toshopping() {
		return "shopping";
	}
	
//	@GetMapping(path= {"toregister","register.html"})
//	public String toregister() {
//		return "register";
//	}
	@GetMapping(path = { "book", "book.html" })
	public String book(int bt_id, Model m) {
		m.addAttribute("book", baction.findByBtid(bt_id));
		return "book";
	}
	
	

	
	
	
	
	@GetMapping(path= {"logout"})
	// SessionStatus 用于终止会话
	public String logout(SessionStatus ss) {
		ss.setComplete();
		return "index";
	}

	
	@PostMapping("login")
	public String login( @Valid User user, Errors errors, Model m) {

	
	if(errors.hasErrors()) {
	    m.addAttribute("user", user);
		m.addAttribute("errors", errors.getFieldErrors());
		System.out.println(errors);
		return "login";
		}

		// 发起远程服务调用， 传递2个参数（用户名，密码）
		Result res = uaction.login(user);

		// 根据返回的结果，如果正确跳转首页
		if(res.getCode() == 1) {
			m.addAttribute("loginedUser", res.getData());
			return "index";
		} else {
			// 自定义一个错误
			errors.rejectValue("uName", "UNameOrUPwdError","用户名或密码错误");
			m.addAttribute("errors", errors.getFieldErrors());
			// 如果错误，跳转回登录页
			return "login";
		}

	}
	
	
	@GetMapping(path = { "toreg", "register.html" })
	public String toreg() {
		return "register";
	}

	@PostMapping("register")
	public String register(@Valid User user, Errors errors, String repwd, Model m) {

		if(repwd == null || repwd.trim().isEmpty()) {
			errors.rejectValue("upwd", "repwdError", "请输入确认密码");
		} else if(repwd.equals(user.getuPwd()) == false) {
			errors.rejectValue("upwd", "repwdError", "两次输入的密码不一致");
		}
		if (errors.hasErrors()) {
			// 讲用户填写的数据传回页面
			m.addAttribute("user", user);
			m.addAttribute("errors", errors.getFieldErrors());
			return "register";
		}

		// 发起远程服务调用， 传递2个参数（用户名，密码）
		Result res = uaction.register(user);

		// 根据返回的结果，如果正确跳转首页
		if (res.getCode() == 1) {
			return "index";
		} else {
			m.addAttribute("errors", errors.getFieldErrors());
			// 如果错误，跳转回注册页
			return "register";
		}
	}


	
	





}