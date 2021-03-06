package com.zy.minicodeluban.jvm.two;

import java.io.*;

/**
 * date:  2020-08-07 11:00
 *
 * @author zhengyao
 */
public class MyClassLoad extends ClassLoader {
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

        File file = new File(name + SUFFIX);
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
        MyClassLoad classLoad = new MyClassLoad();
        Class<?> clazz = classLoad.loadClass(MyClassLoad.class.getName());
        System.out.println(clazz);
        System.out.println(clazz.getClassLoader());
    }
}
