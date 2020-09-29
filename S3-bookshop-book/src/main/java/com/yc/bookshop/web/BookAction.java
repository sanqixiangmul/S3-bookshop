package com.yc.bookshop.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yc.bookshop.bean.Book;
import com.yc.bookshop.bean.BookExample;
import com.yc.bookshop.bean.Booktype;
import com.yc.bookshop.bean.BooktypeExample;
import com.yc.bookshop.bean.Cart;
import com.yc.bookshop.bean.Show;
import com.yc.bookshop.bean.ShowExample;
import com.yc.bookshop.dao.BookMapper;
import com.yc.bookshop.dao.BooktypeMapper;
import com.yc.bookshop.dao.ShowMapper;

@RestController
@RequestMapping("book")
public class BookAction {
	
	@Resource
	private BooktypeMapper btMapper;
	
	@Resource
	private BookMapper bMapper;
	
	@Resource
	private ShowMapper cMapper;
	
	@GetMapping("findByBtid")
	public List<Booktype> findByBtid(@RequestBody Booktype booktype) {
		BooktypeExample exa = new BooktypeExample();
		exa.createCriteria().andBtIdEqualTo(booktype.getBtId());
		return btMapper.selectByExample(exa);
	}
	
	@GetMapping("findById")
	List<Show> findByCnt(@RequestParam int id) {
		ShowExample exa = new ShowExample();
		exa.createCriteria().andBIdEqualTo(id);
		return cMapper.selectByExample(exa);
	}

	@GetMapping("findByBtid1")
	public List<Book> findByBtid1(@RequestBody Book book ) {
		BookExample ex = new BookExample();
		ex.createCriteria().andBtIdEqualTo(book.getBtId());
		return bMapper.selectByExample(ex);
	}
}
