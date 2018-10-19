package com.nathan.FantasyFootballDataModule.dao.impl;

import com.nathan.FantasyFootballDataModule.dao.IFantasyTeamDao;
import com.nathan.FantasyFootballDataModule.model.FantasyTeam;
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

@Repository
public class FantasyTeamDaoImpl implements IFantasyTeamDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    final String INSERT_QUERY = "insert into fantasyTeam(teamName, owner) values (:teamName, :owner)";

    @Override
    public List<FantasyTeam> getFantasyTeams() {
        return null;
    }

    @Override
    public FantasyTeam insertToFantasyTeam(FantasyTeam fantasyTeam) {
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("teamName", fantasyTeam.getTeamName())
                .addValue("owner", fantasyTeam.getOwner());
        namedParameterJdbcTemplate.update(INSERT_QUERY, parameters, holder);

        return fantasyTeam;
    }
}
