package com.yc.bookshop.web.remote;





import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.yc.bookshop.bean.Result;
import com.yc.bookshop.bean.User;


@FeignClient("bsuser")
public interface IUserAction {

	
	
	/**
	 * Feigin 要求对象参数标注 @RequestBody 注解 
	 */
	@PostMapping("user/login")
	Result login(@RequestBody User user);

	@PostMapping("user/register")
	Result register(@RequestBody User user);

	/**
	 * Feigin 要求对象参数标注 @RequestBody 注解 
	 
	@PostMapping("user/login")
	Result<CrUser> login(@RequestBody CrUser user);
	
	@PostMapping("user/register")
	Result register(@RequestBody CrUser user);
	
	@GetMapping("cart/findByUid")
	List<CrCart> findByUid(@RequestParam Integer uid);
*/
}
