package com.figo.function;

import com.figo.dao.VUserRightMapper;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by FigoBa on 2017/8/2.
 */
public class General {
    public static List<String> getUserRights(VUserRightMapper vUserRightMapper,int role_id,String system){
        return vUserRightMapper.getRightsByID(role_id,system);
    }
    public static boolean hasRights(HttpServletRequest httpServletRequest,String rightName){
        boolean rResult=false;
        List<String> rights=(List<String>) httpServletRequest.getSession().getAttribute("rights");
        if(rights.contains(rightName)){
            rResult=true;
        }
        return  rResult;
    }
}
