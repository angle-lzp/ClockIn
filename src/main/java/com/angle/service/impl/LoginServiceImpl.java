package com.angle.service.impl;

import com.angle.domain.Client;
import com.angle.mapper.ClientMapper;
import com.angle.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private ClientMapper clientMapper;

    @Override
    public Client findOne(String username) {

        return clientMapper.findOne(username);
    }

    @Override
    public Client findById(int id) {
        return clientMapper.selectByPrimaryKey(id);
    }

    @Override
    public void modify(Client client) {
        clientMapper.updateByPrimaryKey(client);
    }

    @Override
    public List<Client> findAll() {
        return clientMapper.selectAll();
    }
}