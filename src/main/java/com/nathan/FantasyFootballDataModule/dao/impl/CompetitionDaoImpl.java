package com.nathan.FantasyFootballDataModule.dao.impl;

import com.nathan.FantasyFootballDataModule.dao.ICompetitionDao;
import com.nathan.FantasyFootballDataModule.model.Competition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class CompetitionDaoImpl implements ICompetitionDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    final String INSERT_QUERY = "insert into competition(teamWeekId, week, homeTeamKey, " +
            "awayTeamKey, homeTeamScore, awayTeamScore) " +
            "values(:teamWeekId, :week, :homeTeamKey, :awayTeamKey, " +
            ":homeTeamScore, :awayTeamScore)";

    @Override
    public Competition insertIntoCompetition(Competition competition) {
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("teamWeekId", competition.getTeamWeekId())
                .addValue("week", competition.getWeek())
                .addValue("homeTeamKey", competition.getHomeTeamKey())
                .addValue("awayTeamKey", competition.getAwayTeamKey())
                .addValue("homeTeamScore", competition.getHomeTeamScore())
                .addValue("awayTeamScore", competition.getAwayTeamScore());
        namedParameterJdbcTemplate.update(INSERT_QUERY, parameters, holder);

        return competition;
    }
}
