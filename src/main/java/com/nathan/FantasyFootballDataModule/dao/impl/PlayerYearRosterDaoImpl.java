package com.nathan.FantasyFootballDataModule.dao.impl;

import com.nathan.FantasyFootballDataModule.dao.IPlayerYearRosterDao;
import com.nathan.FantasyFootballDataModule.model.PlayerYearRoster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class PlayerYearRosterDaoImpl implements IPlayerYearRosterDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    final String INSERT_QUERY = "insert into playerYearRoster(playerYearId, teamId, teamName, year)" +
            " values(:playerYearId, :teamId, :teamName, :year)";

    @Override
    public PlayerYearRoster insertIntoPlayerYearRoster(PlayerYearRoster playerYearRoster) {
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("playerYearId", playerYearRoster.getPlayerYearId())
                .addValue("teamId", playerYearRoster.getTeamId())
                .addValue("teamName", playerYearRoster.getTeamName())
                .addValue("year", playerYearRoster.getYear());
        namedParameterJdbcTemplate.update(INSERT_QUERY, parameters, holder);

        return playerYearRoster;
    }
}
