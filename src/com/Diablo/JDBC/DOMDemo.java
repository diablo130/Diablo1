package com.Diablo.JDBC;/*
package com.Rebecca.JDBC;
import org.dom4j.io.*;
import org.dom4j.*;

import java.io.FileOutputStream;
import java.util.List;

*/
/**
 * Created by ���� on 2015/5/14.
 *//*

public class DOMDemo {
    public static void main(String[] args) throws Exception {
        //��ȡ������
        SAXReader reader = new SAXReader();
        //����xml����ȡ���������ĵ���dom����
        Document dom = reader.read("book.xml");
        //��ȡ���ڵ�
        Element root=dom.getRootElement();
       */
/* String bookEle = root.element("book").element("name").getText();
        System.out.println(bookEle);*//*
*/
/*
        List<Element> list=root.elements();
        Element bookele=list.get(1);
        System.out.println(bookele.element("price").getText());*//*



        UpdateXML();
    }

    public static void UpdateXML()  throws Exception{   //���½ڵ�
        SAXReader reader = new SAXReader();
        Document dom = reader.read("book.xml");
        Element root=dom.getRootElement();
        root.element("book").element("special").setText("1.00");

        XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("book.xml"),OutputFormat.createCompactFormat());
        xmlWriter.write(dom);
        xmlWriter.close();
    }

    public static void AddXML() throws Exception {      //��ӽڵ�
        SAXReader reader = new SAXReader();
        Document dom = reader.read("book.xml");
        Element root=dom.getRootElement();

        Element price2ele = DocumentHelper.createElement("special");
        price2ele.setText("30");

        Element bookele = root.element("book");
        bookele.add(price2ele);

        XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("book.xml"),OutputFormat.createCompactFormat());
        xmlWriter.write(dom);
        xmlWriter.close();
    }

    public static void DelXML()  throws Exception{      //ɾ��
        SAXReader reader = new SAXReader();
        Document dom = reader.read("book.xml");
        Element root=dom.getRootElement();
        Element price2ele = root.element("book").element("special");

        price2ele.getParent().remove(price2ele);

        XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("book.xml"),OutputFormat.createCompactFormat());
        xmlWriter.write(dom);
        xmlWriter.close();
    }
    public static void attr()throws Exception{      //��������
        SAXReader reader = new SAXReader();
        Document dom = reader.read("book.xml");
        Element root=dom.getRootElement();

        Element bookele = root.element("book");
        bookele.addAttribute("publishmen", "tingshua");
    }
}
*/
