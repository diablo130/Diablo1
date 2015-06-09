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
 * Created by ���� on 2015/6/4.
 * Description����ȡ�ļ��б�
 */
@WebServlet(name = "GetDownMapServlet",urlPatterns = "/src/com.Diablo.Web/GetDownMapServlet")
public class GetDownMapServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //��ȡ�ϴ��ļ���Ŀ¼
        String uploadFilePath = this.getServletContext().getRealPath("/WEB-INF/upload");
        //�洢Ҫ���ص��ļ���
        Map<String,String> fileNameMap = new HashMap<String,String>();

        //�ݹ����filepathĿ¼�µ������ļ���Ŀ¼�����ļ����ļ����洢��map������
        listFile(new File(uploadFilePath),fileNameMap);//File�ȿ��Դ���һ���ļ�Ҳ���Դ���һ��Ŀ¼
        /*//��Map���Ϸ��͵�listfile.jspҳ�������ʾ
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
