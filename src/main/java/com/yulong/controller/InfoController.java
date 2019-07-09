package com.yulong.controller;

import com.yulong.pojo.User;
import com.yulong.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @program: exam_online
 * @description: 管理员对用户身份进行审核
 * @author: Dragon
 * @create: 2019-07-08 20:24
 */
@Controller
@RequestMapping("/admin")
public class InfoController {

    @Autowired
    private InfoService infoService;

    @RequestMapping("/toInfoDeal")
    public ModelAndView toInfoDeal(){
        ModelAndView mav = new ModelAndView();
        List<User> users = infoService.getAllNotVerify();
        mav.addObject("users",users);
        mav.setViewName("admin/info-deal");
        return mav;
    }

}
