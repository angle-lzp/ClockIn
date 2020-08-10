package com.angle.mapper;

import com.angle.domain.Client;
import com.angle.domain.Info;

import java.util.List;

public interface ClientMapper {
    public int deleteByPrimaryKey(Integer id);

    public int insert(Client record);

    public Client selectByPrimaryKey(Integer id);

    public List<Client> selectAll();

    public int updateByPrimaryKey(Client record);

    public Client findOne(String username);
}