package com.yc.bookshop.web.remote;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.yc.bookshop.bean.Booktype;

public interface IBooktypeAction {

	@GetMapping("product/getBooktypes")
	List<Booktype> getBooktypes();

}
