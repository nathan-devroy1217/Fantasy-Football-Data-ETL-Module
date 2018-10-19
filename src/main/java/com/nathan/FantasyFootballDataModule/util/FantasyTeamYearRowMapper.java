package com.nathan.FantasyFootballDataModule.util;

import com.nathan.FantasyFootballDataModule.model.FantasyTeamYear;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FantasyTeamYearRowMapper implements RowMapper<FantasyTeamYear> {

    @Override
    public FantasyTeamYear mapRow(ResultSet resultSet, int i) throws SQLException {
        FantasyTeamYear fantasyTeamYear = new FantasyTeamYear();
        fantasyTeamYear.setYear(resultSet.getInt("year"));
        fantasyTeamYear.setTeamId(resultSet.getInt("teamId"));
        fantasyTeamYear.setDraftId(resultSet.getInt("draftId"));
        fantasyTeamYear.setOwner(resultSet.getString("owner"));

        return fantasyTeamYear;
    }
}
