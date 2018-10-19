package com.nathan.FantasyFootballDataModule.dao.impl;

import com.nathan.FantasyFootballDataModule.dao.IFantasyTeamWeekDao;
import com.nathan.FantasyFootballDataModule.model.FantasyTeamWeek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class FantasyTeamWeekDaoImpl implements IFantasyTeamWeekDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    final String INSERT_QUERY = "insert into fantasyTeamWeek(teamYearId, week, teamId)" +
            " values(:teamYearId, :week, :teamId)";

    @Override
    public FantasyTeamWeek insertIntoFantasyTeamWeek(FantasyTeamWeek fantasyTeamWeek) {
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("teamYearId", fantasyTeamWeek.getTeamYearId())
                .addValue("week", fantasyTeamWeek.getWeek())
                .addValue("teamId", fantasyTeamWeek.getTeamId());
        namedParameterJdbcTemplate.update(INSERT_QUERY, parameters, holder);

        return fantasyTeamWeek;
    }
}
