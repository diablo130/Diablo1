package com.Diablo.JUnit;

import com.Diablo.JDBC.Person;
import net.sf.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

/**
 * Created by ���� on 2015/5/14.
 * Descriptions:���ֲ���java
 */
public class JUnitTest {
    public static void main(String[] args)throws Exception {

        //���Զ�ȡproperty
        /*System.out.println("�����ַ�");
        Properties prop = new Properties();
        File f = new File("web/File/conf/1.txt");           //���·��
        prop.load(new FileInputStream(f));
        for(Object s:prop.keySet()) {
            //String key = (String)s;
           System.out.println(new String(((String)s).getBytes("ISO8859-1"),"UTf-8") + "......");
        }*/

        String json = "{id:'1001',name:'����',age:'22',sex:'��'}";
        Person stu = new Person();
        JSONObject obj = JSONObject.fromObject(json);
        stu = (Person)JSONObject.toBean(obj, Person.class);
        System.out.println(stu);

    }

}
