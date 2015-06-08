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
 * Created by ���� on 2015/5/29.
 * function:�ļ��ϴ���
 *//*

public class UploadRequestWrapper extends HttpServletRequestWrapper{
    //�ļ�����ͷ
    private static final String MULTIPART_HEADER = "Content-type";
    //�ϴ��ļ�
    private boolean multipart;
    //�ύ������
    private Map<String, Object> params = new HashMap<String,Object>();
    //����һ���ϴ������װ��
    public UploadRequestWrapper(HttpServletRequest request) {
        super(request);
        //�ж�����ͷ
        multipart=request.getHeader(MULTIPART_HEADER)!=null &&
                request.getHeader(MULTIPART_HEADER).startsWith("multipart/form-data");
        if (multipart) {            //������ϴ����ļ�
            try {
                */
/*DiskFileUpload upload = new DiskFileUpload();*//*

                //��ʱ�ķ��������滻������ķ�������
                */
/*1) public static final int DEFAULT_SIZE_THRESHOLD�����ļ��������ڴ滹�Ǵ�����ʱ�ļ��е�Ĭ���ٽ�ֵ��ֵΪ10240����10kb��

                2) private File repository�����������ڴ����ļ���Ŀʱ�����ļ���Ŀ�����ٽ�ֵʱʹ�õ���ʱ�ļ��У�Ĭ�ϲ���ϵͳĬ�ϵ���ʱ�ļ�·��������ͨ��ϵͳ���� java.io.tmpdir��ȡ��*//*


                //����һ���ϴ��ļ���
                DiskFileItemFactory factory = new DiskFileItemFactory(0,new File("web/File/conf/"));
                */
/*factory.setSizeThreshold(0);
                if(saveDir != null)
                    factory.setRepository(new File(saveDir));*//*

                ServletFileUpload upload = new ServletFileUpload(factory);


                //�ƶ�ͷ������
                upload.setHeaderEncoding("utf-8");


                //�������ݵ�һ��LIst
                List<FileItem> fileItems=upload.parseRequest(request);
                for (Iterator<FileItem> it = fileItems.iterator(); it.hasNext(); ) {
                    FileItem file = it.next();

                    //������ı�
                    if (file.isFormField()) {
                        //����һ��Map���ı���name,�ı����ַ�����
                        params.put(file.getFieldName(), file.getString("utf-8"));
                    }

                    //�������ϴ��ļ�
                    else {
                        //��ȡ�ϴ��ļ����ַ���
                        String filename = file.getName().replace("\\", "/");
                        //���ǽ�ȡ����ַ���·�����ļ��У�Ŀ�����ڷ������˽�������һ���ļ���
                        filename = filename.substring(filename.lastIndexOf("/") + 1);
                        //new ����ļ���ϵͳ����ʱ�ļ���
                        File f = new File(System.getProperty("java.io.tmpdir"), filename);

                        //�������ָ���ļ���
                        OutputStream out = new FileOutputStream(f);
                        //д�ļ�
                        out.write(file.get());
                        out.close();
                        //����Map
                        params.put(file.getFieldName(), file);
                    }
                }
            } catch (Exception e) {

            }
        }
    }

    public Object getAttribute(String name) {           //��ȡ�ļ�����
        if (multipart && params.containsKey(name)) {
            return params.get(name);
        }
        return super.getAttribute(name);
    }

    public String getParameter(String name) {           //ȡֵ��ȡ�ļ����ַ�����
        if (multipart && params.containsKey(name)) {
            return params.get(name).toString();
        }
        return super.getParameter(name);
    }
}
*/
