package com.nathan.FantasyFootballDataModule.dao.impl;

import com.nathan.FantasyFootballDataModule.dao.IDraftDao;
import com.nathan.FantasyFootballDataModule.model.Draft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class DraftDaoImpl implements IDraftDao {

    private String INSERT_DRAFT_QUERY = "insert into draft(year) values(:year)";

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Draft insertDrafttoDraftTable(Draft draft) {
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("year", draft.getYear());
        namedParameterJdbcTemplate.update(INSERT_DRAFT_QUERY, parameters, holder);

        return draft;
    }
}
