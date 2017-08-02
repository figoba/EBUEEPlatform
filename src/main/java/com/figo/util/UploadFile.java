package com.figo.util;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by FigoBa on 2017/4/28.
 */
public class UploadFile {
    public  static String upload(String FolderPath,FileItem item,String...strSaveName){
        String strfilename_separater= PropertyUtil.getPropertyValue("filename_separater");
        String strUploadPath="";
        File file = new File(FolderPath);
        //判断上传文件的保存目录是否存在
        if (!file.exists() && !file.isDirectory()) {
            System.out.println(FolderPath+"目录不存在，需要创建");
            //创建目录
            file.mkdir();
        }

        try {

            String filename = item.getName();


            if(filename==null || filename.trim().equals("")){

            }else{
                //注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
                //处理获取到的上传文件的文件名的路径部分，只保留文件名部分
                filename = filename.substring(filename.lastIndexOf("\\") + 1);
                if(strSaveName!=null){
                  filename=strSaveName[0]+strfilename_separater+strSaveName[0]+strfilename_separater+get_Random()+
                          "." + FilenameUtils.getExtension(filename);
                }else{
                    filename=get_Random()+"_"+filename;
                }



                //获取item中的上传文件的输入流
                InputStream in = item.getInputStream();
                //创建一个文件输出流
                FileOutputStream out = new FileOutputStream(FolderPath + "\\" + filename);
                //创建一个缓冲区
                byte buffer[] = new byte[1024];
                //判断输入流中的数据是否已经读完的标识
                int len = 0;
                //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
                while((len=in.read(buffer))>0){
                    //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
                    out.write(buffer, 0, len);
                }
                //关闭输入流
                in.close();
                //关闭输出流
                out.close();
                //删除处理文件上传时生成的临时文件
                item.delete();
                // message = "文件上传成功！";
                strUploadPath=FolderPath + "\\" + filename;
                strUploadPath=filename;
            }

        }catch (Exception e){

        }


        return strUploadPath;
    }



    public static Map<String,FileItem> getFilelist(HttpServletRequest request){

        Map<String,FileItem> uploadFileList=new HashMap<String, FileItem>();
        try{
            //使用Apache文件上传组件处理文件上传步骤：
            //1、创建一个DiskFileItemFactory工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //2、创建一个文件上传解析器
            ServletFileUpload upload = new ServletFileUpload(factory);
            //解决上传文件名的中文乱码
            upload.setHeaderEncoding("UTF-8");
            //3、判断提交上来的数据是否是上传表单的数据

            //4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
            List<FileItem> list = upload.parseRequest(request);


            for(FileItem item : list){
                //如果fileitem中封装的是普通输入项的数据
                if(item.isFormField()){

                }else{//如果fileitem中封装的是上传文件
                    //得到上传的文件名称，
                    uploadFileList.put(item.getFieldName(),item);

                }

            }
        }catch (Exception e) {

            e.printStackTrace();

        }
        return uploadFileList;
    }


    public static Map<String,Object> getFilelisto(HttpServletRequest request){

        Map<String,Object> uploadFileList=new HashMap<String, Object>();
        try{
            //使用Apache文件上传组件处理文件上传步骤：
            //1、创建一个DiskFileItemFactory工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //2、创建一个文件上传解析器
            ServletFileUpload upload = new ServletFileUpload(factory);
            //解决上传文件名的中文乱码
            upload.setHeaderEncoding("UTF-8");
            //3、判断提交上来的数据是否是上传表单的数据

            //4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
            List<FileItem> list = upload.parseRequest(request);


            for(FileItem item : list){
                //如果fileitem中封装的是普通输入项的数据
                if(item.isFormField()){
                    String value=item.getString("UTF-8");
                    if(value.length()>0){
                        uploadFileList.put(item.getFieldName(),item.getString("UTF-8"));
                    }


                }else{//如果fileitem中封装的是上传文件
                    //得到上传的文件名称，
                    uploadFileList.put(item.getFieldName(),item);

                }

            }
        }catch (Exception e) {

            e.printStackTrace();

        }
        return uploadFileList;
    }

    public static String get_Random(){
        SimpleDateFormat simpleDateFormat;

        simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmss");

        Date date = new Date();

        String str = simpleDateFormat.format(date);

        Random random = new Random();

        int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数

        return str+rannum ;// 当前时间
    }
}
