package com.Diablo.JUnit;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

/**
 * Created by 黄粟 on 2015/5/14.
 */
public class JUnitTest {
    public static void main(String[] args)throws Exception {
        System.out.println("中文字符");
        Properties prop = new Properties();
        File f = new File("web/File/conf/1.txt");           //相对路径
        prop.load(new FileInputStream(f));
        for(Object s:prop.keySet()) {
            //String key = (String)s;
           System.out.println(new String(((String)s).getBytes("ISO8859-1"),"UTf-8") + "......");
        }


        /*String filename = file.getName().replace("\\", "/");
        filename = filename.substring(filename.lastIndexOf("/") + 1);*/


    }

}
