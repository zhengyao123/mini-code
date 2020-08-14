package com.zy.minicodeluban.jvm.two;

import sun.misc.Launcher;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * date:  2020-08-06 17:18
 *
 * @author zhengyao
 */
public class TestClassLoad {
    public static void main(String[] args) throws ClassNotFoundException {

        //new TestClassLoad().getClass().getClassLoader();
//
//        ClassLoader parent = ClassLoader.getSystemClassLoader().getParent().getParent();
//
//        System.out.println(parent);
//
//        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
//        for (URL urL : urLs) {
//            System.out.println(urL);
//        }
//
//
//        ClassLoader classLoader = ClassLoader.getSystemClassLoader().getParent();
//
//        URLClassLoader urlClassLoader = (URLClassLoader) classLoader;
//
//        URL[] urls = urlClassLoader.getURLs();
//        for (URL url : urls) {
//            System.out.println(url);
//
//        }

        MyClassLoad_02 myClassLoad = new MyClassLoad_02("D:\\IdeaProjects\\mini-code\\mini-code-luban\\target\\classes\\");
        System.out.println(myClassLoad.loadClass("com.zy.minicodeluban.jvm.two.Demo").getClassLoader());
    }
}
