package com.angle.service;

import com.angle.domain.Client;

import java.util.List;

public interface ILoginService {
    public Client findOne(String username);

    public Client findById(int id);

    public void modify(Client client);

    public List<Client> findAll();

}
