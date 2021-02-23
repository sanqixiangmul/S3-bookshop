/*
 * package com.yc.bookshop.web;
 * 
 * 
 * import java.util.List;
 * 
 * import javax.annotation.Resource;
 * 
 * import org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.yc.bookshop.bean.Result; import com.yc.bookshop.bean.User; import
 * com.yc.bookshop.bean.UserExample; import com.yc.bookshop.dao.UserMapper;
 * 
 * @RestController
 * 
 * @RequestMapping("user") public class UserAction {
 * 
 * @Resource private UserMapper uMapper;
 * 
 * @PostMapping("login") public Result login(@RequestBody User user) {
 * UserExample cue = new UserExample();
 * cue.createCriteria().andUNameEqualTo(user.getuName()).andUPwdEqualTo(user.
 * getuPwd()); List<User> list = uMapper.selectByExample(cue); if
 * (list.isEmpty()) { return new Result(0, "用户名或密码错误！"); } else { return new
 * Result(1, "登录成功！", list.get(0)); } }
 * 
 * 
 * @PostMapping("register") public Result register(@RequestBody User user) {
 * uMapper.insertSelective(user); return new Result(1, "注册成功!", user); }
 * 
 * }
 */