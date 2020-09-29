package com.yc.bookshop.web.remote;


import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("bsuser")
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
}
