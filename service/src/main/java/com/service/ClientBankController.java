package com.service;

import com.domain.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ClientBankController {

    @Autowired
    ClientBankService clientBankService;

    @RequestMapping(value = "clients/{name}/accounts/{code}",method = RequestMethod.GET)
    public Account readAccount(@PathVariable("name") String name, @PathVariable("code") String code){
        return clientBankService.readAccount(name,code);
    }

    @RequestMapping(value = "clients/{name}/accounts/{code}/deposit/{deposit}",method = RequestMethod.GET)
    public Account depositAccount(@PathVariable("name") String name, @PathVariable("code") String code,@PathVariable("deposit") Double deposit){
        return clientBankService.depositAccount(name,code,deposit);
    }
    @RequestMapping(value = "clients/{name}/accounts/{code}/withdraw/{withdraw}",method = RequestMethod.GET)
    public Account withdrawAccount(@PathVariable("name") String name, @PathVariable("code") String code,@PathVariable("withdraw") Double deposit){
        return clientBankService.withdrawAccount(name,code,deposit);
    }
}
