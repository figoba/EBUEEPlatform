package com.figo.controller;

import com.figo.dao.VUserRightMapper;
import com.figo.function.General;
import com.figo.function.PCBAdd;
import com.figo.function.PCBCheck;
import com.figo.model.User;
//import com.figo.service.UserService;
import com.figo.service.IPcbDesignStoreMapper;
import com.figo.util.Convert;
import com.figo.util.R;
import com.figo.util.UploadFile;
import com.figo.webtest.MailTest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.fileupload.FileItem;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by FigoBa on 2017/7/17.
 */
@Controller
@RequestMapping("/pcb")
public class PCBController {
    @Resource
    IPcbDesignStoreMapper iPcbDesignStoreMapper;
    @Resource
    VUserRightMapper vUserRightMapper;

    private Logger log = Logger.getLogger(PCBController.class);


    @RequestMapping(value="/p_{url}")
    public String showUser(HttpServletRequest request, Model model, @ModelAttribute("url") String url){
        log.info(url);


        return "views/pcb/"+url+".jsp";
    }

    /**
     * PCB资料录入
     * @param request
     * @param model
     * @param response
     * @throws Exception
     */
    @RequestMapping("/add")
    public void PCBAdd(HttpServletRequest request, Model model, HttpServletResponse response)throws Exception{
            R r=null;
       if(General.hasRights(request,"上传")){
            r= PCBAdd.upload(request,iPcbDesignStoreMapper);
       }else{
            r=R.error("没有上传权限");
       }



        String json = Convert.toJson(r);
       /* log.info("查询Test信息");
        String sMsg="{ \"firstName\":\"Bill\" , \"lastName\":\"Gates\" }";
        response.getWriter().println(sMsg);*/
        response.getWriter().println(json);
    }

    /**
     * 料号重复检测
     * @param request
     * @param model
     * @param response
     * @throws Exception
     */
    @RequestMapping("/check_pn_repeat")
    public void PCB_PNRepeatCheck(HttpServletRequest request, Model model, HttpServletResponse response)throws Exception{
        String pn=request.getParameter("PCB_PN");
        String strCheckResult="";
        log.info("pn is:"+pn);
        if(iPcbDesignStoreMapper.queryByAnyPN(pn).size()>0){
            strCheckResult="false";
        }else{
            strCheckResult="true";
        }

        response.getWriter().println(strCheckResult);

    }

    /**
     * 审核列表加载
     * @param params
     * @param request
     * @param response
     * @throws Exception
     */

    @RequestMapping("/check")
    public void PCB_Check_list(@RequestParam Map<String, Object> params,HttpServletRequest request, HttpServletResponse response) throws Exception{
        R r=PCBCheck.getChecklist(params,iPcbDesignStoreMapper);
        System.out.println(request.getSession().getAttribute("rights"));

        String json = Convert.toJson(r);
        response.getWriter().println(json);
    }
}
