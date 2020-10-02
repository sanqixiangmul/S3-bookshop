package com.yc.bookshop.web.remote;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("bsuser")
public interface ICartAction {

	@GetMapping("cart/clearCart")
	int clearCart(@RequestParam Integer uid);
}
