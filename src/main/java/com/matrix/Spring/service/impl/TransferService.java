package com.matrix.Spring.service.impl;

import com.matrix.Spring.entity.AccountEntity;
import com.matrix.Spring.repository.AccountRepository;
import com.matrix.Spring.service.TransferServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TransferService implements TransferServiceImpl {

    @Autowired
    private final AccountRepository accountRepository;

    @Override
    public void transfer(AccountEntity source, AccountEntity target, Double transferAmount) throws Exception{

        if(source.getBalance() < transferAmount){
            throw new RuntimeException("Transfer olunacaq məbləğ balansda yoxdu");
        }

        source.setBalance(source.getBalance() - transferAmount);
        accountRepository.save(source);

       // if(true)
         //   throw new Exception("This is just testing");
        target.setBalance(target.getBalance() + transferAmount);
        accountRepository.save(target);
    }
}
