package com.nathan.FantasyFootballDataModule.dao;

import com.nathan.FantasyFootballDataModule.model.Transaction;

public interface ITransactionDao {
    Transaction insertIntoTransaction(Transaction transaction);
}
