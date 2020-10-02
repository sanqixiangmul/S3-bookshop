package com.yc.bookshop.web.remote;



import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yc.bookshop.bean.Cart;

@FeignClient("cruser")
public interface IUserAction {
	
	/**
	 * Feigin 要求对象参数标注 @RequestBody 注解 
	 
	@PostMapping("user/login")
	Result<CrUser> login(@RequestBody CrUser user);
	
	@PostMapping("user/register")
	Result register(@RequestBody CrUser user);
	
	@GetMapping("cart/findByUid")
	List<CrCart> findByUid(@RequestParam Integer uid);
*/
	
	@GetMapping("cart/findByUid")
	List<Cart> findByUid(@RequestParam Integer uid);
}
