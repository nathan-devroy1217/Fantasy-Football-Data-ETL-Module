package com.nathan.FantasyFootballDataModule.util;

import com.nathan.FantasyFootballDataModule.model.FantasyTeam;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FantasyTeamRowMapper implements RowMapper<FantasyTeam> {

    @Override
    public FantasyTeam mapRow(ResultSet resultSet, int i) throws SQLException {
        FantasyTeam fantasyTeam = new FantasyTeam();
        fantasyTeam.setTeamName(resultSet.getString("teamName"));
        fantasyTeam.setOwner(resultSet.getString("owner"));

        return fantasyTeam;
    }
}
