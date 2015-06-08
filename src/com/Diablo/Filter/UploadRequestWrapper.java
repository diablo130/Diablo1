/*
package com.Diablo.Filter;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.*;

*/
/**
 * Created by 黄粟 on 2015/5/29.
 * function:文件上传类
 *//*

public class UploadRequestWrapper extends HttpServletRequestWrapper{
    //文件类型头
    private static final String MULTIPART_HEADER = "Content-type";
    //上传文件
    private boolean multipart;
    //提交的数据
    private Map<String, Object> params = new HashMap<String,Object>();
    //构造一个上传请求包装类
    public UploadRequestWrapper(HttpServletRequest request) {
        super(request);
        //判断请求头
        multipart=request.getHeader(MULTIPART_HEADER)!=null &&
                request.getHeader(MULTIPART_HEADER).startsWith("multipart/form-data");
        if (multipart) {            //如果是上传的文件
            try {
                */
/*DiskFileUpload upload = new DiskFileUpload();*//*

                //过时的方法，被替换，代替的方法如下
                */
/*1) public static final int DEFAULT_SIZE_THRESHOLD：将文件保存在内存还是磁盘临时文件夹的默认临界值，值为10240，即10kb。

                2) private File repository：用于配置在创建文件项目时，当文件项目大于临界值时使用的临时文件夹，默认采用系统默认的临时文件路径，可以通过系统属性 java.io.tmpdir获取。*//*


                //构造一个上传文件类
                DiskFileItemFactory factory = new DiskFileItemFactory(0,new File("web/File/conf/"));
                */
/*factory.setSizeThreshold(0);
                if(saveDir != null)
                    factory.setRepository(new File(saveDir));*//*

                ServletFileUpload upload = new ServletFileUpload(factory);


                //制定头部编码
                upload.setHeaderEncoding("utf-8");


                //解析数据到一个LIst
                List<FileItem> fileItems=upload.parseRequest(request);
                for (Iterator<FileItem> it = fileItems.iterator(); it.hasNext(); ) {
                    FileItem file = it.next();

                    //如果是文本
                    if (file.isFormField()) {
                        //放入一个Map（文本的name,文本的字符串）
                        params.put(file.getFieldName(), file.getString("utf-8"));
                    }

                    //否则是上传文件
                    else {
                        //获取上传文件的字符串
                        String filename = file.getName().replace("\\", "/");
                        //这是截取这个字符串路径的文件夹，目的是在服务器端建立这样一个文件夹
                        filename = filename.substring(filename.lastIndexOf("/") + 1);
                        //new 这个文件到系统的临时文件夹
                        File f = new File(System.getProperty("java.io.tmpdir"), filename);

                        //输出流到指定文件夹
                        OutputStream out = new FileOutputStream(f);
                        //写文件
                        out.write(file.get());
                        out.close();
                        //放入Map
                        params.put(file.getFieldName(), file);
                    }
                }
            } catch (Exception e) {

            }
        }
    }

    public Object getAttribute(String name) {           //获取文件对象
        if (multipart && params.containsKey(name)) {
            return params.get(name);
        }
        return super.getAttribute(name);
    }

    public String getParameter(String name) {           //取值（取文件的字符串）
        if (multipart && params.containsKey(name)) {
            return params.get(name).toString();
        }
        return super.getParameter(name);
    }
}
*/
