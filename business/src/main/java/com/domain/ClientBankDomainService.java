package com.domain;

import com.domain.model.Account;
import com.domain.model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
 * THIS IS NOT EXPECTED TO BECOME A SPRING-BOOT SERVICE
 */
public class ClientBankDomainService {
    public Account readAccount(Client client, String code){
        return client.getAccounts().stream().filter(accountToFind -> accountToFind.getCode()
                .equals(code)).findFirst()
                .orElse(null);
    }
    public Account depositAccount(Client client,String code,Double deposit){
        Account account = readAccount(client,code);
        if(account !=null) {
            account.setBalance(account.getBalance() + deposit);
            return account;
        }
        return null;
    }

    public Account withdrawAccount(Client client,String code,Double withdraw){
        Account account = readAccount(client,code);
        if(account !=null) {
            if(account.getBalance()>=withdraw) {
                account.setBalance(account.getBalance() - withdraw);
                return account;
            }
        }
        return null;
    }


}