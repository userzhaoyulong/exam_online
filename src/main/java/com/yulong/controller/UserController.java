package com.yulong.controller;

import com.yulong.commons.Result;
import com.yulong.pojo.Grade;
import com.yulong.pojo.User;
import com.yulong.service.UserService;
import com.yulong.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @program: testSSM
 * @description: 普通用户和管理员用户登录的控制器
 * @author: Dragon
 * @create: 2019-06-27 17:27
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login_u")
    public String login(HttpSession session, @RequestParam String username, @RequestParam String userpwd){
        User user = userService.login(username, userpwd);
        session.setAttribute("user",user);
        return "user/index";
    }

    @RequestMapping("/checkPwd")
    @ResponseBody
    public Result checkPwd(HttpSession session, @RequestParam("userid") String userid, @RequestParam("userpwd") String userpwd){
        Result result = new Result();
        String pwd = MD5Util.getPwdByMD5(userpwd);
        System.out.println("userid=" + userid + " userpwd=" + pwd);
        User user = userService.login(userid, pwd);
        if (user != null && user.getUsertype() == 0){
            if (user.getUserstate() == 0){
                result.setErrorNo("0");
                result.setErrorInfo("该账号审核未通过！");
            }else {
                result.setErrorNo("1");
                result.setErrorInfo("登录成功！");
                session.setAttribute("user",user);
            }
        }else if (user != null && user.getUsertype() == 2){
            if (user.getUserstate() == 0){
                result.setErrorNo("0");
                result.setErrorInfo("该账号审核未通过！");
            }else {
                result.setErrorNo("2");
                result.setErrorInfo("登录成功！");
                session.setAttribute("admin",user);
            }
        }else if (user == null){
            result.setErrorNo("0");
            result.setErrorInfo("账户不存在或用户名密码错误！");
        }
        return result;
    }

    /*AJAX异步验证账户是否已经被注册了*/
    @RequestMapping("/checkUserId")
    @ResponseBody
    public Result checkUserId(String userId, Model model){
        Result result = new Result();
        boolean flag = userService.checkUserId(userId);
        if (flag == true){
            result.setErrorInfo("账户已存在");
        }else {
            result.setErrorInfo("<font color='green'>账户还未注册</font>");
        }
        return result;
    }

    @RequestMapping("/toIndex_u")
    public String toIndex_u(){
        return "user/index";
    }

    @RequestMapping("/toIndex_a")
    public String toIndex_a(){
        return "admin/index";
    }

    /*学生注册*/
    @RequestMapping("/registUser")
    public String regist(User user){
        userService.registUser(user);
        return "user/login";
    }

    @RequestMapping("/getGrade")
    @ResponseBody
    public List<Grade> getGrade(){
        List<Grade> grade = userService.getGrade();
        return grade;
    }

    @RequestMapping("/login")
    public String login(){
        return "user/login";
    }

    @RequestMapping("/toUserInfo")
    public String toUserInfo(){
        return "user/info_qry";
    }

    @RequestMapping("/toRegist")
    public String toRegist(){
        return "user/regist";
    }

    @RequestMapping("/exit")
    public String exitSys(HttpSession session){
        /*User admin = (User) session.getAttribute("admin");
        User user = (User) session.getAttribute("user");
        if (admin != null)
            session.removeAttribute("admin");
        if (user != null)
            session.removeAttribute("user");*/
        session.invalidate();  //使此会话失效，解除其绑定的任何对象
        return "user/login";
    }
}
