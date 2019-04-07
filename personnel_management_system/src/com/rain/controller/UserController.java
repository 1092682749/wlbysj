package com.rain.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.rain.dao.PersonalInfoMapper;
import com.rain.dao.UserDao;
import com.rain.domain.*;
import com.rain.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.rain.service.RainService;
import com.rain.util.common.Constants;

@Controller
public class UserController {
	@Autowired
	@Qualifier("RainService")
	private RainService rainservice;
	@Autowired
	RoleService roleService;
	@Autowired
	PersonalInfoMapper personalInfoMapper;
	@Autowired
	UserDao userDao;
	// 如果在目录下输入为空，则跳转到指定链接
		@RequestMapping(value="/user/")
		 public ModelAndView index2(ModelAndView mv){
			mv.setViewName("/user/list");
			return mv;
		}
		@RequestMapping(value="/login")
		 public ModelAndView login(@RequestParam("loginname") String loginname,
				 @RequestParam("password") String password,
				 HttpSession session,
				 ModelAndView mv){
			// 调用业务逻辑组件判断用户是否可以登录
			
			
			User user = rainservice.login(loginname, password);
//			System.out.println(user.getLoginname());
			if(user != null){
				// 将用户保存到HttpSession当中
				System.out.println("HttpSession");
				session.setAttribute(Constants.USER_SESSION, user);
				// 客户端跳转到main页面
				mv.setViewName("redirect:/index");
			}else{
				// 设置登录失败提示信息
				System.out.println("设置登录失败提示信息");
				mv.addObject("message", "登录名或密码错误!请重新输入");
				// 服务器内部跳转到登录页面
				mv.setViewName("forward:/loginForm");
			}
			return mv;
		}
		// 如果在目录下输入任何不存在的参数，则跳转到list
		@RequestMapping(value="/user/{formName}")
		 public String index2(@PathVariable String formName){
			String blank = "/user/list";
			return blank;
		}
		@RequestMapping(value="/user/list",method=RequestMethod.GET)
		 public String index(Model model,String content){
			List<User> job_list = rainservice.get_UserList();
			if (content!=null){
				job_list = rainservice.get_UserLikeList(content);
			}
			model.addAttribute("list",job_list);
			return "user/list";
		}
		@RequestMapping(value="/user/add",method=RequestMethod.GET)
		 public String add(Model model,Integer id){
			if(id!=null){
				User job = rainservice.get_UserInfo(id);
				model.addAttribute("job",job);
			}
			return "/user/add";
		}
		@RequestMapping(value="/user/add",method=RequestMethod.POST)
		 public ModelAndView add(ModelAndView mv,@ModelAttribute User notice ,Integer id){
			System.out.println(id);
			if(id!=null){
				rainservice.update_UserInfo(notice);
			}else{
				rainservice.insert_UserInfo(notice);
			}
			mv.setViewName("redirect:/user/list");
			return mv;
		}
		@RequestMapping(value="/user/delete",method=RequestMethod.GET)
		 public void delete(Integer id){
			System.out.println(id);
			if(id!=null){
				rainservice.delete_UserInfo(id);
			}
		}
		@RequestMapping("/personalInfo")
	public ModelAndView personalInfo(HttpSession session) {
			User user = (User) session.getAttribute(Constants.USER_SESSION);

			//User user = userDao.findAllPermissionInfo(1);
			List<Role> roles = roleService.findAll();
			PersonalInfo personalInfo = personalInfoMapper.findById(user.getId());
			ModelAndView mav = new ModelAndView("/user/selfInfo");
			mav.addObject("user", user);
			mav.addObject("personalInfo", personalInfo);
			return mav;
		}
}
