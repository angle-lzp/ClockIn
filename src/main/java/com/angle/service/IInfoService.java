package com.angle.service;

import com.angle.domain.Info;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IInfoService {

    public List<Info> findAll();

    public List<Info> findByCid(int cid);

    public void insert(Info info);

    public void modify(Info info);

    public List<Info> findAllByCid(int cid);

    public List<Info> findPageByCid(int cid, int offset);//offset偏移量

}
