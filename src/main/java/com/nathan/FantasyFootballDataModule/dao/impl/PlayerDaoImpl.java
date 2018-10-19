package com.nathan.FantasyFootballDataModule.dao.impl;

import com.nathan.FantasyFootballDataModule.dao.IPlayerDao;
import com.nathan.FantasyFootballDataModule.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class PlayerDaoImpl implements IPlayerDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    final String INSERT_QUERY = "insert into player(firstName, lastName, positionKey) values(:firstName, :lastName, :positionKey) " +
            "on duplicate key update firstName = :firstName, lastName = :lastName, positionKey = :positionKey";

    @Override
    public Player insertIntoPlayer(Player player) {
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("firstName", player.getFirstName())
                .addValue("lastName", player.getLastName())
                .addValue("positionKey", player.getPositionKey());
        namedParameterJdbcTemplate.update(INSERT_QUERY, parameters, holder);

        return player;
    }
}
