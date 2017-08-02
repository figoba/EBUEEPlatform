package com.figo.function;

import com.figo.controller.PCBController;
import com.figo.model.PcbDesignStore;
import com.figo.service.IPcbDesignStoreMapper;
import com.figo.util.PropertyUtil;
import com.figo.util.R;
import com.figo.util.UploadFile;
import org.apache.commons.fileupload.FileItem;
import org.apache.log4j.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.util.Date;
import java.util.Map;

/**
 * Created by FigoBa on 2017/7/26.
 */
public class PCBAdd {

    private static Logger log = Logger.getLogger(PCBAdd.class);
    private static final String startVer="001";
    public static R upload(HttpServletRequest request,IPcbDesignStoreMapper iPcbDesignStoreMapper){

        String strUploadUser="FigoBa";

        String strParentFolder= PropertyUtil.getPropertyValue("upload");
        String strSCHFileName= PropertyUtil.getPropertyValue("sch");
        String strLayoutFileName= PropertyUtil.getPropertyValue("layout");
        String strGerberName= PropertyUtil.getPropertyValue("gerber");
        String strPcbdrawFileName= PropertyUtil.getPropertyValue("pcbdraw");
        String strPcbchecklistFileName= PropertyUtil.getPropertyValue("pcbchecklist");




        Map<String,Object> mapFileList= UploadFile.getFilelisto(request);
        String PN=(String)mapFileList.get("PCB_PN");
        if(iPcbDesignStoreMapper.queryByAnyPN(PN).size()>0){
            log.info(PN+" exists");
        }


        strParentFolder=strParentFolder+"/"+PN;
        FileItem PCB_SCHfile=(FileItem)mapFileList.get("PCB_SCH");
        FileItem PCB_Layout=(FileItem)mapFileList.get("PCB_Layout");
        FileItem PCB_Gerbe=(FileItem)mapFileList.get("PCB_Gerber");
        FileItem PCB_Draw=(FileItem)mapFileList.get("PCB_Draw");
        FileItem PCB_CheckList=(FileItem)mapFileList.get("PCB_CheckList");

        String strPcb_sch=UploadFile.upload(strParentFolder,PCB_SCHfile,strSCHFileName,PN);
        String strPcb_layout=UploadFile.upload(strParentFolder,PCB_Layout,strLayoutFileName,PN);
        String strPcb_gerber=UploadFile.upload(strParentFolder,PCB_Gerbe,strGerberName,PN);
        String strPcb_draw=UploadFile.upload(strParentFolder,PCB_Draw,strPcbdrawFileName,PN);
        String strPcb_check=UploadFile.upload(strParentFolder,PCB_CheckList,strPcbchecklistFileName,PN);

        PcbDesignStore pcbDesignStore=new PcbDesignStore();

        if(PN.substring(0,1).equals("E")){
            pcbDesignStore.setTempPn(PN);
        }else{
            pcbDesignStore.setPn(PN);
        }

        pcbDesignStore.setStatus(1);
        pcbDesignStore.setUserUpload(strUploadUser);
        pcbDesignStore.setDateUpload(new Date());
        pcbDesignStore.setVer(startVer);
        pcbDesignStore.setPathSch(strParentFolder+"/"+strPcb_sch);
        pcbDesignStore.setPathLayout(strParentFolder+"/"+strPcb_layout);
        pcbDesignStore.setPathGerber(strParentFolder+"/"+strPcb_gerber);
        pcbDesignStore.setPathPcbdraw(strParentFolder+"/"+strPcb_draw);
        pcbDesignStore.setPathPcbchecklist(strParentFolder+"/"+strPcb_check);

        if(iPcbDesignStoreMapper.insertNewPcbDesignRecord(pcbDesignStore)==1){
            return R.error("inserted success");
        }else{
            return  R.ok("inserted success");
        }




    }
}
