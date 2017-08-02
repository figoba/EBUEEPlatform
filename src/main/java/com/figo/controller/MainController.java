package com.figo.controller;

import com.figo.service.STuser;

import com.figo.util.PropertyUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by FigoBa on 2017/7/14.
 */
@Controller
public class MainController {
    private Logger log = Logger.getLogger(MainController.class);
    @Resource
    private STuser sTuser;

    @RequestMapping(value ="/",method = RequestMethod.GET)
    public String login(){

    log.info("login Page returned");
        return "views/login.html";
    }

    @RequestMapping("/main")
    public String showMain(HttpServletRequest request, Model model){
       /* System.out.println("main");
        model.addAttribute("Figo","figoba");
        sTuser.selectall();*/
       // System.out.println("main");

        return "views/main.html";
    }

    @RequestMapping("/index")
    public String showIndex(HttpServletRequest request, Model model){

        return "views/index.html";
    }
}
