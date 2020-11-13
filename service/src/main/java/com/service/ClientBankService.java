package com.service;

import com.domain.ClientBankDomainService;
import com.domain.model.Account;
import com.domain.model.Client;
import com.service.model.ClientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientBankService {

    private ClientBankDomainService innerService;
    @Autowired
    ClientBankRepository clientBankRepository;

    public ClientBankService() {
        this.innerService = new ClientBankDomainService();
    }

    public Client getClient(String name) {
        ClientEntity clientEntity = clientBankRepository.findByName(name);
        if(clientEntity != null) {
            if (clientEntity.getAccounts() != null) {
                List<Account> accounts = clientEntity.getAccounts().stream()
                        .map(accountEntity -> new Account(accountEntity.getCode(), accountEntity.getBalance()))
                        .collect(Collectors.toList());
                Client client = new Client(clientEntity.getName());
                client.addAccounts(accounts);
                return client;
            }
        }
        return null;
    }

    public Account readAccount(String name, String code){
        Client client = getClient(name);
        if(client != null) {
            return innerService.readAccount(client, code);
        }
        return null;
    }

    public Account depositAccount(String name,String code,Double deposit){
        Client client = getClient(name);
        if(client != null) {
            return innerService.depositAccount(client, code,deposit);
        }
        return null;
    }

    public Account withdrawAccount(String name,String code,Double withdraw){
        Client client = getClient(name);
        if(client != null) {
            return innerService.withdrawAccount(client, code,withdraw);
        }
        return null;
    }



}
