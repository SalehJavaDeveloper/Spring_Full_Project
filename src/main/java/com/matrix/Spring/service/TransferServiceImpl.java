package com.matrix.Spring.service;

import com.matrix.Spring.entity.AccountEntity;

public interface TransferServiceImpl {

    public void transfer(AccountEntity source, AccountEntity target, Double transferAmount) throws Exception;
}
