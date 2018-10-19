package com.nathan.FantasyFootballDataModule.util;

import com.nathan.FantasyFootballDataModule.model.Player;
import com.nathan.FantasyFootballDataModule.model.RosterPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class CommonUtilities {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    final String PLAYER_KEY_QUERY = "select distinct p.id from player p " +
            "where p.firstname = ? and p.lastname = ?";

    public Integer getRosterPlayerKeyForName(String playerName) {
        String[] splitNames = playerName.split(" ");

        Integer result = jdbcTemplate.queryForObject(PLAYER_KEY_QUERY,
                Integer.class, splitNames[0], splitNames[1]);
        return result;
    }
}
