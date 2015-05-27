package com.Diablo.JDBC;/*
package com.Rebecca.JDBC;
import org.dom4j.io.*;
import org.dom4j.*;

import java.io.FileOutputStream;
import java.util.List;

*/
/**
 * Created by 黄粟 on 2015/5/14.
 *//*

public class DOMDemo {
    public static void main(String[] args) throws Exception {
        //获取解析器
        SAXReader reader = new SAXReader();
        //解析xml，获取代表整个文档的dom对象
        Document dom = reader.read("book.xml");
        //获取根节点
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

    public static void UpdateXML()  throws Exception{   //更新节点
        SAXReader reader = new SAXReader();
        Document dom = reader.read("book.xml");
        Element root=dom.getRootElement();
        root.element("book").element("special").setText("1.00");

        XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("book.xml"),OutputFormat.createCompactFormat());
        xmlWriter.write(dom);
        xmlWriter.close();
    }

    public static void AddXML() throws Exception {      //添加节点
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

    public static void DelXML()  throws Exception{      //删除
        SAXReader reader = new SAXReader();
        Document dom = reader.read("book.xml");
        Element root=dom.getRootElement();
        Element price2ele = root.element("book").element("special");

        price2ele.getParent().remove(price2ele);

        XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("book.xml"),OutputFormat.createCompactFormat());
        xmlWriter.write(dom);
        xmlWriter.close();
    }
    public static void attr()throws Exception{      //设置属性
        SAXReader reader = new SAXReader();
        Document dom = reader.read("book.xml");
        Element root=dom.getRootElement();

        Element bookele = root.element("book");
        bookele.addAttribute("publishmen", "tingshua");
    }
}
*/
