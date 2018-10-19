package com.nathan.FantasyFootballDataModule.service.impl;

import com.nathan.FantasyFootballDataModule.dao.ITransactionDao;
import com.nathan.FantasyFootballDataModule.model.Transaction;
import com.nathan.FantasyFootballDataModule.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService implements ITransactionService {

    @Autowired
    ITransactionDao transactionDao;

    @Override
    public Transaction insertIntoTransactionTable(Transaction transaction) {
        return transactionDao.insertIntoTransaction(transaction);
    }
}
