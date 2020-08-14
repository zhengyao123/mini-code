package com.zy.minicodemybatis.dbutils;


import com.zy.minicodemybatis.dbutils.dao.BlogDao;

public class Main {
    public static void main(String[] args) throws Exception {
        HikariUtil.init();
        BlogDao.selectBlog(1);
        BlogDao.selectList();
    }
}
