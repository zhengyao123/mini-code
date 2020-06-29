package com.zy.servertwo;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DemoDao {

    @Insert("insert into t_test(name) values(#{name})")
    public void insert(@Param("name") String name);
}
