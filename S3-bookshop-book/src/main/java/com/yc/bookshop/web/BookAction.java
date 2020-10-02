package com.yc.bookshop.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yc.bookshop.bean.Booktype;
import com.yc.bookshop.bean.BooktypeExample;

import com.yc.bookshop.bean.Show;
import com.yc.bookshop.bean.ShowExample;
import com.yc.bookshop.dao.BooktypeMapper;
import com.yc.bookshop.dao.ShowMapper;

@RestController
@RequestMapping("book")
public class BookAction {
	
	@Resource
	private BooktypeMapper btMapper;
	@Resource
	private ShowMapper cMapper;
	
	@GetMapping("findByBtid")
	List<Booktype> findByBtid(@RequestParam int bt_id) {
		BooktypeExample exa = new BooktypeExample();
		exa.createCriteria().andBtIdEqualTo(bt_id);
		return btMapper.selectByExample(exa);
	}
	
	@GetMapping("findById")
	List<Show> findByCnt(@RequestParam int id) {
		ShowExample exa = new ShowExample();
		exa.createCriteria().andBIdEqualTo(id);
		return cMapper.selectByExample(exa);
	}

}
