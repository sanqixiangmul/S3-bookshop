/*
 * package com.yc.bookshop.web;
 * 
 * import java.util.List;
 * 
 * 
 * import javax.annotation.Resource;
 * 
 * import org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.yc.bookshop.bean.Cart; import com.yc.bookshop.bean.CartExample;
 * import com.yc.bookshop.dao.CartMapper;
 * 
 * @RestController
 * 
 * @RequestMapping("cart") public class CartAction {
 * 
 * @Resource private CartMapper cMapper;
 * 
 * @GetMapping("findByUid") List<Cart> findByUid (@RequestParam int uid){
 * CartExample exa=new CartExample(); exa.createCriteria().andUIdEqualTo(uid);
 * List<Cart> c = cMapper.selectByExample(exa); System.out.println("C===="+c);
 * return c;
 * 
 * 
 * }
 * 
 * @GetMapping("clearCart") int clearCart(@RequestParam int uid) { CartExample
 * exa=new CartExample(); int c=cMapper.deleteByPrimaryKey(uid); return c; }
 * 
 * 
 * }
 */