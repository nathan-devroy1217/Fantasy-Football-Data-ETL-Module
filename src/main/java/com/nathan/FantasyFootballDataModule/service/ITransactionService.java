package com.nathan.FantasyFootballDataModule.service;

import com.nathan.FantasyFootballDataModule.model.Transaction;

public interface ITransactionService {
    Transaction insertIntoTransactionTable(Transaction transaction);
}
