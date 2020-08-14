package com.zy.minicodeluban.jvm.two;

import java.io.*;

/**
 * date:  2020-08-07 11:00
 *
 * @author zhengyao
 */
public class MyClassLoad_02 extends ClassLoader {
    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class<?> c = this.findLoadedClass(name);
        if (c == null) {
            if (name.startsWith("com.zy")) {
                c = findClass(name);
            } else {
                c = this.getParent().loadClass(name);
            }
        }
        return c;
    }


    private String classPath;

    public MyClassLoad_02(String classPath) {
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        System.out.println("---------------华丽分割线------------------");

        byte[] data = getData(className.replace('.', '/'));

        return defineClass(className, data, 0, data.length);
    }

    public static final String SUFFIX = ".class";

    private byte[] getData(String name) {
        InputStream inputStream = null;
        ByteArrayOutputStream outputStream = null;

        File file = new File(classPath + name + SUFFIX);
        if (!file.exists()) return null;

        try {
            inputStream = new FileInputStream(file);
            outputStream = new ByteArrayOutputStream();

            int size = 0;
            byte[] buffer = new byte[1024];

            while ((size = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, size);
            }
            return outputStream.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static void main(String[] args) throws ClassNotFoundException {
//        MyClassLoad_02 classLoad = new MyClassLoad_02();
//        Class<?> clazz = classLoad.loadClass(MyClassLoad_02.class.getName());
//        System.out.println(clazz);
//        System.out.println(clazz.getClassLoader());
    }
}
