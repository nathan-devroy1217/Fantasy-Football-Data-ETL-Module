package com.nathan.FantasyFootballDataModule.dao.impl;

import com.nathan.FantasyFootballDataModule.dao.IRosterWeekDao;
import com.nathan.FantasyFootballDataModule.model.RosterWeek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class RosterWeekDaoImpl implements IRosterWeekDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    final String INSERT_QUERY = "insert into rosterWeek(playerRosterYearId, week, teamId, playerKey) " +
            "values (:playerRosterYearId, :week, :teamId, :playerKey)";

    @Override
    public RosterWeek insertIntoRosterWeek(RosterWeek rosterWeek) {
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("playerRosterYearId", rosterWeek.getPlayerRosterYearId())
                .addValue("week", rosterWeek.getWeek())
                .addValue("teamId", rosterWeek.getTeamId())
                .addValue("playerKey",rosterWeek.getPlayerKey());
        namedParameterJdbcTemplate.update(INSERT_QUERY, parameters, holder);

        return  rosterWeek;
    }
}
