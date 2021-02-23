/*
 * package com.yc.bookshop.web;
 * 
 * import java.util.List;
 * 
 * 
 * 
 * import javax.annotation.Resource; import javax.validation.Valid;
 * 
 * import org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import org.springframework.validation.Errors;
 * import org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.RequestParam;
 * 
 * import com.yc.bookshop.bean.Cart; import
 * com.yc.bookshop.web.remote.IUserAction; import
 * org.springframework.web.bind.annotation.PostMapping;
 * 
 * import org.springframework.web.bind.annotation.SessionAttributes; import
 * org.springframework.web.bind.support.SessionStatus;
 * 
 * import org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.servlet.ModelAndView;
 * 
 * 
 * import com.yc.bookshop.bean.Result; import com.yc.bookshop.bean.User; import
 * com.yc.bookshop.web.remote.IBookAction;
 * 
 * import com.yc.bookshop.web.remote.IUserAction;
 * 
 * 
 * import com.yc.bookshop.web.remote.ICartAction;
 * 
 * 
 * 
 * @Controller
 * 
 * @SessionAttributes ("loginedUser")
 * 
 * public class IndexAction {
 * 
 * @Resource private IUserAction uaction;
 * 
 * @Resource private IBookAction baction;
 * 
 * 
 * 
 * 
 * @Resource private ICartAction caction;
 * 
 * 
 * @GetMapping("/") public String index() { return "index"; }
 * 
 * 
 * @GetMapping(path= {"tologin","login.html"}) public String tologin() { return
 * "login"; }
 * 
 * @GetMapping(path= {"tobook","book.html"}) public String tobook() { return
 * "book"; }
 *//**
	 * @GetMapping(path= {"toshopping","shopping.html"}) public String toshopping()
	 * { return "shopping"; }
	 * 
	 *//*
		 * @GetMapping(path= {"toindex","index.html"}) public String toindex() { return
		 * "index"; }
		 * 
		 * 
		 * 
		 * public String toproduct() { return "product"; }
		 * 
		 * 
		 * 传值到页面
		 * 
		 * @GetMapping(path= {"test1","test1.html"}) public ModelAndView test1() {
		 * ModelAndView mav = new ModelAndView("test1"); mav.addObject("mav", "movie");
		 * return mav; }
		 * 
		 * 
		 * 
		 * @GetMapping(path= {"product","product.html"}) public String product(@Valid
		 * Booktype booktype,Errors errors, Model m) { // 使用 FeIgn 远程调用 book 的服务 // 1
		 * 定义一个接口,用于访问远程服务 // 2 调用远程服务
		 * System.out.println("booktype:"+booktype.getBtId()); if(booktype.getBtId() ==
		 * null ) { errors.rejectValue("btId", "btIdErrors", "未传入id值"); }else {
		 * m.addAttribute("booktype", baction.findByBtid()); List<Booktype> findByBtid2
		 * = baction.findByBtid2(booktype.getBtId());
		 * System.out.println("findByBtid2:"+findByBtid2); m.addAttribute("findByBtid2",
		 * findByBtid2);
		 * 
		 * }
		 * 
		 * return "product"; }
		 * 
		 * 
		 * // js location.href . hash ? htpp://asss?id=1
		 * 
		 * /* List<Book> findByBtid1 ;//= new ArrayList<Book>(); for(Book book :
		 * findByBtid1) { findByBtid1 = baction.findByBtid1(book.getBtId()); }
		 * System.out.println("findByBtid1:" + findByBtid1); // 推送给页面
		 * m.addAttribute("findByBtid1", findByBtid1);
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * @RequestMapping("/product/{btId}") public ModelAndView
		 * code(@PathVariable(value = "btId") String btId) { ModelAndView modelAndView =
		 * new ModelAndView(); modelAndView.setViewName("product");
		 * modelAndView.addObject("key", btId); System.out.println("product"); return
		 * modelAndView; }
		 * 
		 * 
		 * // @GetMapping(path= {"toregister","register.html"}) // public String
		 * toregister() { // return "register"; // } // @GetMapping(path = { "book",
		 * "book.html" }) // public String book(int bt_id, Model m) { //
		 * m.addAttribute("book", baction.findByBtid(bt_id)); // return "book";
		 * 
		 * @GetMapping(path= {"toregister","register.html"}) public String toregister()
		 * { return "register"; }
		 * 
		 * 
		 * @GetMapping(path = { "book", "book.html" }) public String book(int bt_id,
		 * Model m) { m.addAttribute("book", baction.findByBtid(bt_id)); return "book";
		 * }
		 * 
		 * 
		 * @GetMapping(path = { "index", "index.html" }) public String bookType( Model
		 * m) { m.addAttribute("booktype", baction.findByBtid()); return "index"; }
		 * 
		 * @PostMapping(path = { "product.do", "product.html" }) public String
		 * books(String b_name, Model m) { m.addAttribute("book",
		 * baction.findByBname(b_name)); return "product";
		 * 
		 * }
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * @GetMapping(path= {"logout"}) // SessionStatus 用于终止会话 public String
		 * logout(SessionStatus ss) { ss.setComplete(); return "index"; }
		 * 
		 * 
		 * @PostMapping("login") public String login( @Valid User user, Errors errors,
		 * Model m) {
		 * 
		 * 
		 * if(errors.hasErrors()) { m.addAttribute("user", user);
		 * m.addAttribute("errors", errors.getFieldErrors());
		 * System.out.println(errors); return "login"; }
		 * 
		 * // 发起远程服务调用， 传递2个参数（用户名，密码） Result res = uaction.login(user);
		 * 
		 * // 根据返回的结果，如果正确跳转首页 if(res.getCode() == 1) { m.addAttribute("loginedUser",
		 * res.getData()); return "index"; } else { // 自定义一个错误
		 * errors.rejectValue("uName", "UNameOrUPwdError","用户名或密码错误");
		 * m.addAttribute("errors", errors.getFieldErrors()); // 如果错误，跳转回登录页 return
		 * "login"; }
		 * 
		 * }
		 * 
		 * 
		 * @GetMapping(path = { "toreg", "register.html" }) public String toreg() {
		 * return "register"; }
		 * 
		 * @PostMapping("register") public String register(@Valid User user, Errors
		 * errors, String repwd, Model m) {
		 * 
		 * if(repwd == null || repwd.trim().isEmpty()) { errors.rejectValue("upwd",
		 * "repwdError", "请输入确认密码"); } else if(repwd.equals(user.getuPwd()) == false) {
		 * errors.rejectValue("upwd", "repwdError", "两次输入的密码不一致"); } if
		 * (errors.hasErrors()) { // 讲用户填写的数据传回页面 m.addAttribute("user", user);
		 * m.addAttribute("errors", errors.getFieldErrors()); return "register"; }
		 * 
		 * // 发起远程服务调用， 传递2个参数（用户名，密码） Result res = uaction.register(user);
		 * 
		 * // 根据返回的结果，如果正确跳转首页 if (res.getCode() == 1) { return "index"; } else {
		 * m.addAttribute("errors", errors.getFieldErrors()); // 如果错误，跳转回注册页 return
		 * "register"; } }
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * @GetMapping(path= {"toshopping","shopping.html"}) public String
		 * toshopping(@RequestParam int uid,Model m) { List<Cart>
		 * carts=uaction.findByUid(uid); System.out.println("====="+carts);
		 * m.addAttribute("carts", carts); return "shopping"; }
		 * 
		 * 
		 * @GetMapping(path= {"clearCart.do","shopping.html"}) public String
		 * clearCart( @RequestParam int uid,Model m) {
		 * m.addAttribute("cart",caction.clearCart(uid)); return "shopping";
		 * 
		 * } }
		 */