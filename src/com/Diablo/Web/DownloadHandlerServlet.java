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
 * Created by ���� on 2015/6/4.
 * Description���������
 */
@WebServlet(name = "DownloadHandlerServlet",urlPatterns = "/src/com.Diablo.Web/DownloadHandlerServlet")
public class DownloadHandlerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //�õ�Ҫ���ص��ļ���
        String fileName = request.getParameter("filename");  //23239283-92489-������.avi
        //fileName = new String(fileName.getBytes("iso8859-1"),"UTF-8");
        //�ϴ����ļ����Ǳ�����/WEB-INF/uploadĿ¼�µ���Ŀ¼����
        /*String fileSaveRootPath=this.getServletContext().getRealPath("/WEB-INF/upload");*/
        HttpSession session=request.getSession();
        Map<String,String> map= (Map<String, String>) session.getAttribute("fileNameMap");
        String fileSaveRootPath = map.get(fileName);
        /*//ͨ���ļ����ҳ��ļ�������Ŀ¼
        String path = findFileSavePathByFileName(fileName,fileSaveRootPath);*/
        //�õ�Ҫ���ص��ļ�
        File file = new File(fileSaveRootPath);
        System.out.println(file.getAbsolutePath());
        //����ļ�������
        if(!file.exists()){
            request.setAttribute("message", "��Ҫ���ص���Դ�ѱ�ɾ������");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
            return;
        }
        /*//�����ļ���
        String realname = fileName.substring(fileName.indexOf("_")+1);*/
        //�������������ֱ�Ӵ��������
        //������Ӧͷ��������������ظ��ļ�                          /*URLEncoder.encode(fileName,"gb2312")*/
        /*response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName,"UTF-8") );*/
        response.setHeader("Content-disposition","attachment; filename="+new String(fileName.getBytes("gb2312"),"iso8859-1"));
        //��ȡҪ���ص��ļ������浽�ļ�������

        FileInputStream in = new FileInputStream(fileSaveRootPath);
        //���������
        OutputStream out = response.getOutputStream();
        //����������
        byte buffer[] = new byte[1024];
        int len = 0;
        //ѭ�����������е����ݶ�ȡ������������
        while((len=in.read(buffer))>0){
            //��������������ݵ��������ʵ���ļ�����
            out.write(buffer, 0, len);
        }
        //�ر��ļ�������
        in.close();
        //�ر������
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
