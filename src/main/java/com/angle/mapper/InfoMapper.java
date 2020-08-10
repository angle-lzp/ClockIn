package com.angle.mapper;

import com.angle.domain.Info;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Info record);

    Info selectByPrimaryKey(Integer id);

    List<Info> findAll();

    List<Info> findByCid(int cid);

    List<Info> findResultByCid(int cid);

    int updateByPrimaryKey(Info record);

    List<Info> findAllByCid(int cid);

    List<Info> findPageByCid(@Param("cid") int cid, @Param("offset") int offset);//offset偏移量


}