package com.yc.bookshop.web.remote;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("crbook")
public interface IBookAction {
	
	/**@GetMapping("book/getNewBooks")
	List<CrBook> getNewBooks();
	
	@GetMapping("book/getRecom1")
	List<CrShow> getRecom1();
	*/
	/**
	 * 根据图书id查询指定的图书
	 * @return
	 
	@GetMapping("book/getById")
	CrBookWithBLOBs getById(@RequestParam int id);*/

}