package com.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Client {


    private final String name;

    private final List<Account> accounts = new ArrayList<>();
    public Client(String name){
        this.name = name;
    }

    public void addAccounts(List<Account> accounts){
        this.accounts.addAll(accounts);
    }

    public void addAccount(Account account){
        this.accounts.add(account);
    }

    public String getName() {
        return name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }




}
