package org.example.ws.service;

import org.example.ws.model.Account;
import org.example.ws.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The AccountServiceBean encapsulates all business behaviors for operations on
 * the Account entity model and some related entities such as Role.
 * 
 * @author Matt Warman
 */
@Service
public class AccountServiceBean implements AccountService {

    /**
     * The Logger for this class.
     */
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * The Spring Data repository for Account entities.
     */
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account findByUsername(String username) {
        logger.info("> findByUsername");
        Account account = accountRepository.findByUsername(username);

        logger.info("< findByUsername");
        return account;
    }

}
