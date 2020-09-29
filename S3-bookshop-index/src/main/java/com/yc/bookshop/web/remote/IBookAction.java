package com.yc.bookshop.web.remote;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PostMapping;
=======
import org.springframework.web.bind.annotation.RequestBody;
>>>>>>> branch 'master' of https://github.com/sanqixiangmul/S3-bookshop.git
import org.springframework.web.bind.annotation.RequestParam;

import com.yc.bookshop.bean.Book;
import com.yc.bookshop.bean.Booktype;

@FeignClient("bsbook")
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
	
	@GetMapping("book/findByBtid2")
	List<Booktype> findByBtid2(@RequestBody Booktype booktype);

	@GetMapping("book/findByBtid1")
	List<Book> findByBtid1(@RequestBody Book Book);

	@GetMapping("book/findByBtid")
	List<Booktype> findByBtid();
	
	@PostMapping("book/findByBname")
	List<Book> findByBname(@RequestParam String b_name);


	
}
