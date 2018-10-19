package com.nathan.FantasyFootballDataModule.dao.impl;

import com.nathan.FantasyFootballDataModule.dao.IPlayerYearDao;
import com.nathan.FantasyFootballDataModule.model.PlayerYear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class PlayerYearDaoImpl implements IPlayerYearDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    final String INSERT_QUERY = "insert into playerYear(playerKey, positionKey, nflTeamId, adp, yearKey) " +
            "values(:playerKey, :positionKey, :nflTeamId, :adp, :yearKey)";

    @Override
    public PlayerYear insertIntoPlayerYear(PlayerYear playerYear) {
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("playerKey", playerYear.getPlayerKey())
                .addValue("positionKey", playerYear.getPositionKey())
                .addValue("nflTeamId", playerYear.getNflTeamId())
                .addValue("adp", playerYear.getAdp())
                .addValue("yearKey", playerYear.getYearKey());
        namedParameterJdbcTemplate.update(INSERT_QUERY, parameters, holder);

        return playerYear;
    }
}
