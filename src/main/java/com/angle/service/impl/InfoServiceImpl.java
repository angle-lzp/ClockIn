package com.angle.service.impl;

import com.angle.domain.Info;
import com.angle.mapper.InfoMapper;
import com.angle.service.IInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoServiceImpl implements IInfoService {

    @Autowired
    private InfoMapper infoMapper;

    @Override
    public List<Info> findAll() {
        return infoMapper.findAll();
    }

    @Override
    public List<Info> findByCid(int cid) {
        return infoMapper.findByCid(cid);
    }

    @Override
    public void insert(Info info) {
        infoMapper.insert(info);
    }

    @Override
    public void modify(Info info) {
        infoMapper.updateByPrimaryKey(info);
    }

    @Override
    public List<Info> findAllByCid(int cid) {
        return infoMapper.findAllByCid(cid);
    }

    @Override
    public List<Info> findPageByCid(int cid, int offset) {
        return infoMapper.findPageByCid(cid, offset);
    }
}
