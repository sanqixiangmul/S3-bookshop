package com.yc.bookshop.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yc.bookshop.bean.Book;
import com.yc.bookshop.bean.BookExample;
import com.yc.bookshop.bean.Booktype;
import com.yc.bookshop.bean.BooktypeExample;

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
	
	//通过btid的范围查询图书种类的名称bt_name
	@GetMapping("findByBtid")
	List<Booktype> findByBtid() {
		BooktypeExample exa = new BooktypeExample();
		exa.createCriteria().andBtIdBetween(1, 13);
		return btMapper.selectByExample(exa);
	}
	
	//模糊查询
	@PostMapping("findByBname")
	List<Book> findByBname(@RequestParam String b_name) {
		BookExample exa = new BookExample();
		exa.createCriteria().andBNameLike("%"+b_name+"%");
		return bMapper.selectByExample(exa);
	}
	
	//模糊查询
		@GetMapping("findAllBooks")
		List<Book> findAllBooks() {
			BookExample exa = new BookExample();
			exa.createCriteria().andBIdGreaterThanOrEqualTo(100001);
			return bMapper.selectByExample(exa);
		}
		
	@GetMapping("findById")
	List<Show> findByCnt(@RequestParam int b_id) {
		ShowExample exa = new ShowExample();
		exa.createCriteria().andBIdEqualTo(b_id);
		return cMapper.selectByExample(exa);
	}

	
	@GetMapping("findByBtid1")
	public List<Book> findByBtid1(@RequestBody Book book ) {
		BookExample be = new BookExample();
		be.createCriteria().andBtIdEqualTo(book.getBtId());
		return bMapper.selectByExample(be);
	}
	
	@GetMapping(path  = "findByBtid2")
	public List<Booktype> findByBtid2(@RequestParam int btId) {
		BooktypeExample bte = new BooktypeExample();
		//当BtPid不为空时，查询数据
		bte.createCriteria().andBtPidEqualTo(btId);
		//return (List<Booktype>) btMapper.selectByPrimaryKey(btId);
		System.out.println(btMapper.selectByExample(bte));
		return btMapper.selectByExample(bte);
	}
	
	
}
