package com.Diablo.Web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 黄粟 on 2015/6/4.
 * Description：获取文件列表
 */
@WebServlet(name = "GetDownMapServlet",urlPatterns = "/src/com.Diablo.Web/GetDownMapServlet")
public class GetDownMapServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取上传文件的目录
        String uploadFilePath = this.getServletContext().getRealPath("/WEB-INF/upload");
        //存储要下载的文件名
        Map<String,String> fileNameMap = new HashMap<String,String>();

        //递归遍历filepath目录下的所有文件和目录，将文件的文件名存储到map集合中
        listFile(new File(uploadFilePath),fileNameMap);//File既可以代表一个文件也可以代表一个目录
        /*//将Map集合发送到listfile.jsp页面进行显示
        request.setAttribute("fileNameMap", fileNameMap);
        request.setAttribute("uploadFilePath",uploadFilePath);
        request.getRequestDispatcher("/MainPage.jsp").forward(request, response);*/
        HttpSession session=request.getSession();
        session.setAttribute("fileNameMap", fileNameMap);
        session.setAttribute("uploadFilePath",uploadFilePath);
        response.sendRedirect("/MainPage.jsp");
    }

    public void listfile(File file, Map<String, String> map) {
        if (!file.isFile()) {
            File[] files=file.listFiles();
            for (File f : files) {
                listfile(f,map);
            }
        }
        else
        {
            map.put(file.getName(),file.getAbsolutePath());
        }
    }

    public void listFile(File file, Map<String, String> map) {
        File[] files=file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                listfile(f,map);
            }
            else {
                map.put(f.getName(), f.getName());
            }
        }
    }
}
