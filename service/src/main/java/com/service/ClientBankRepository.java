package com.service;

import com.domain.model.Client;
import com.service.model.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientBankRepository extends JpaRepository<ClientEntity, Long> {
     ClientEntity findByName(String name);
}
