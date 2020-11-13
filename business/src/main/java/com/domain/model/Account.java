package com.domain.model;

public class Account {

    private final String code;

    private double balance = 0;

    public Account(String code) {
        this.code = code;
    }

    public Account(String code, double balance) {
        this.code = code;
        this.balance = balance;
    }

    public String getCode() {
        return code;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
