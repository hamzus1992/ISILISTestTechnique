package com.domain.tdd;

import com.domain.ClientBankDomainService;
import com.domain.model.Account;
import com.domain.model.Client;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class ClientBanckDomainServiceTest {
    Client client;
    ClientBankDomainService clientBankDomainService;
    @Before                        // This will run **before** EACH @Test
    public void setUptestDepositUpdatesBalance(){
        clientBankDomainService = new ClientBankDomainService();
        client = new Client("TEST");
        client.addAccount(new Account("TEST_001"));
        Account account = new Account("TEST_002");
        account.setBalance(100);
        client.addAccount(account);
        client.addAccount(new Account("TEST_003"));

    }
    @Test
    public void testRead(){
        assertEquals(clientBankDomainService.readAccount(client,"TEST_002").getBalance(),100.0);
        assertEquals(clientBankDomainService.readAccount(client,"TEST_004"),null);
    }

    @Test
    public void testDeposit(){
        assertEquals(clientBankDomainService.depositAccount(client,"TEST_002",10.0).getBalance(),110.0);
    }
    @Test
    public void testWithdraw(){
        assertEquals(clientBankDomainService.withdrawAccount(client,"TEST_002",10.0).getBalance(),90.0);
    }

}
