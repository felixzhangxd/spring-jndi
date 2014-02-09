package biz.ezcom.spring.jndi.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import biz.ezcom.spring.jndi.dao.api.IUserDao;
import biz.ezcom.spring.jndi.po.User;

@Controller
@RequestMapping(value = { "/user" })
public class UserController {
    @Resource
    private IUserDao userDao;

    @RequestMapping(value = { "/input" })
    public String input() {
        return "/user/input";
    }
    
    @RequestMapping(value = { "/submit" })
    public String submit(User user) {
        userDao.save(user);
        return "/user/submit";
    }
}
