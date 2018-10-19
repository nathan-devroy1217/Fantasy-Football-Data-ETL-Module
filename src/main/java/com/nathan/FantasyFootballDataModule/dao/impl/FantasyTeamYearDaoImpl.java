package com.nathan.FantasyFootballDataModule.dao.impl;

import com.nathan.FantasyFootballDataModule.dao.IFantasyTeamYearDao;
import com.nathan.FantasyFootballDataModule.model.FantasyTeamYear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;

@Repository
public class FantasyTeamYearDaoImpl implements IFantasyTeamYearDao {

    final String INSERT_QUERY = "insert into fantasyTeamYear(year, teamId, draftId, owner) values (:year, :teamId, :draftId, :owner)";
    final String MAX_DRAFT_ID_QUERY = "select max(draftId) from fantasyTeamYear";
    final String MAX_TEAM_ID_QUERY = "select max(teamId) from fantasyTeamYear";
    final String MIN_YEAR_QUERY = "select min(year) from fantasyTeamYear";
    final String MAX_YEAR_QUERY = "select max(year) from fantasyTeamYear";
    final String TEAM_NUMBERS_QUERY = "select count(*) from fantasyTeam";
    final String TEAM_NAME_QUERY = "select teamName from fantasyTeam where teamId = :teamId";

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<FantasyTeamYear> getFantasyTeamYears() {
        return null;
    }

    @Override
    public FantasyTeamYear insertToFantasyTeamYear(FantasyTeamYear fantasyTeamYear) {
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("year", fantasyTeamYear.getYear())
                .addValue("teamId", fantasyTeamYear.getTeamId())
                .addValue("draftId", fantasyTeamYear.getDraftId())
                .addValue("owner", fantasyTeamYear.getOwner());
        namedParameterJdbcTemplate.update(INSERT_QUERY, parameters, holder);

        return fantasyTeamYear;
    }

    public int getMaxDraftId() {
        int result = jdbcTemplate.queryForObject(MAX_DRAFT_ID_QUERY, Integer.class);
        return result;
    }

    @Override
    public int getMaxTeamId() {
        int result = jdbcTemplate.queryForObject(MAX_TEAM_ID_QUERY, Integer.class);
        return result;
    }

    @Override
    public int getMinYear() {
        int result = jdbcTemplate.queryForObject(MIN_YEAR_QUERY, Integer.class);
        return result;
    }

    @Override
    public int getMaxYear() {
        int result = jdbcTemplate.queryForObject(MAX_YEAR_QUERY, Integer.class);
        return result;
    }

    @Override
    public String getRandomTeamName() {
        int teamNumsInFantasyTeam = jdbcTemplate.queryForObject(TEAM_NUMBERS_QUERY, Integer.class);
        int rand = new Random().nextInt(teamNumsInFantasyTeam + 1);
        SqlParameterSource namedParameters = new MapSqlParameterSource("teamId",
                rand);
        return namedParameterJdbcTemplate.queryForObject(TEAM_NAME_QUERY, namedParameters, String.class);

    }

    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
        return namedParameterJdbcTemplate;
    }

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
}
