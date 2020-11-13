package com.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ClientBankController clientBankController;

    @Test
    public void shouldReadClientAccount() throws Exception {
        this.mockMvc.perform(get("/api/v1/clients/{name}/accounts/{code}","me","00000"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("code").value("00000"))
                .andExpect(jsonPath("balance").value("100.0"));;
    }

    @Test
    public void shouldDepositClientAccount() throws Exception {
        this.mockMvc.perform(get("/api/v1/clients/{name}/accounts/{code}/deposit/{deposit}","me","00000","10"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("code").value("00000"))
                .andExpect(jsonPath("balance").value("110.0"));;
    }

    @Test
    public void shouldwithdrawClientAccount() throws Exception {
        this.mockMvc.perform(get("/api/v1/clients/{name}/accounts/{code}/withdraw/{withdraw}","me","00000","10"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("code").value("00000"))
                .andExpect(jsonPath("balance").value("90.0"));;
    }
}
