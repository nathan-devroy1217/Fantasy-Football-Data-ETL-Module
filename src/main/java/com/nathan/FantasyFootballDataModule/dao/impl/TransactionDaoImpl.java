package com.nathan.FantasyFootballDataModule.dao.impl;

import com.nathan.FantasyFootballDataModule.dao.ITransactionDao;
import com.nathan.FantasyFootballDataModule.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionDaoImpl implements ITransactionDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    final String INSERT_QUERY = "insert into transaction(teamWeekId, transactionKey," +
            "tradeSenderId, tradeReceiverId, playerId, waiverAddPlayerId, waiverDropPlayerId)" +
            "values(:teamWeekId, :transactionKey, :tradeSenderId, :tradeReceiverId, " +
            ":playerId, :waiverAddPlayerId, :waiverDropPlayerId)";

    @Override
    public Transaction insertIntoTransaction(Transaction transaction) {
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("teamWeekId", transaction.getTeamWeekId())
                .addValue("transactionKey", transaction.getTransactionKey())
                .addValue("tradeSenderId", transaction.getTradeSenderId())
                .addValue("tradeReceiverId", transaction.getTradeReceiverId())
                .addValue("playerId", transaction.getPlayerId())
                .addValue("waiverAddPlayerId", transaction.getWaiverAddPlayerId())
                .addValue("waiverDropPlayerId", transaction.getWaiverDropPlayerId());
        namedParameterJdbcTemplate.update(INSERT_QUERY, parameters, holder);

        return transaction;
    }
}
