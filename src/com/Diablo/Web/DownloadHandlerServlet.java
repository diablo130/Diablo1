package com.Diablo.Web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.util.Map;

/**
 * Created by 黄粟 on 2015/6/4.
 * Description：完成下载
 */
@WebServlet(name = "DownloadHandlerServlet",urlPatterns = "/src/com.Diablo.Web/DownloadHandlerServlet")
public class DownloadHandlerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //得到要下载的文件名
        String fileName = request.getParameter("filename");  //23239283-92489-阿凡达.avi
        //fileName = new String(fileName.getBytes("iso8859-1"),"UTF-8");
        //上传的文件都是保存在/WEB-INF/upload目录下的子目录当中
        /*String fileSaveRootPath=this.getServletContext().getRealPath("/WEB-INF/upload");*/
        HttpSession session=request.getSession();
        Map<String,String> map= (Map<String, String>) session.getAttribute("fileNameMap");
        String fileSaveRootPath = map.get(fileName);
        /*//通过文件名找出文件的所在目录
        String path = findFileSavePathByFileName(fileName,fileSaveRootPath);*/
        //得到要下载的文件
        File file = new File(fileSaveRootPath);
        System.out.println(file.getAbsolutePath());
        //如果文件不存在
        if(!file.exists()){
            request.setAttribute("message", "您要下载的资源已被删除！！");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
            return;
        }
        /*//处理文件名
        String realname = fileName.substring(fileName.indexOf("_")+1);*/
        //如果不设置这句就直接从浏览器打开
        //设置响应头，控制浏览器下载该文件                          /*URLEncoder.encode(fileName,"gb2312")*/
        /*response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName,"UTF-8") );*/
        response.setHeader("Content-disposition","attachment; filename="+new String(fileName.getBytes("gb2312"),"iso8859-1"));
        //读取要下载的文件，保存到文件输入流

        FileInputStream in = new FileInputStream(fileSaveRootPath);
        //创建输出流
        OutputStream out = response.getOutputStream();
        //创建缓冲区
        byte buffer[] = new byte[1024];
        int len = 0;
        //循环将输入流中的内容读取到缓冲区当中
        while((len=in.read(buffer))>0){
            //输出缓冲区的内容到浏览器，实现文件下载
            out.write(buffer, 0, len);
        }
        //关闭文件输入流
        in.close();
        //关闭输出流
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
