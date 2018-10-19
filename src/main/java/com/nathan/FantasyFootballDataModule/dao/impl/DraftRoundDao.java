package com.nathan.FantasyFootballDataModule.dao.impl;

import com.nathan.FantasyFootballDataModule.dao.IDraftRoundDao;
import com.nathan.FantasyFootballDataModule.model.DraftRound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class DraftRoundDao implements IDraftRoundDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private String INSERT_DRAFT_YEAR_QUERY = "insert into draftRound(id, round, pickNum, team," +
            " playerId, year) values(:id, :round, :pickNum, :team,\" +\n" +
            "            \" :playerId, :year)";

    @Override
    public DraftRound insertDraftYearToDraftYearTable(DraftRound draftRound) {
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("id", draftRound.getId())
                .addValue("round", draftRound.getRound())
                .addValue("pickNum", draftRound.getPickNum())
                .addValue("team", draftRound.getTeam())
                .addValue("playerId", draftRound.getTeam())
                .addValue("year", draftRound.getYear());
        namedParameterJdbcTemplate.update(INSERT_DRAFT_YEAR_QUERY, parameters, holder);

        return draftRound;
    }
}
