package com.nathan.FantasyFootballDataModule.dao;

import com.nathan.FantasyFootballDataModule.model.FantasyTeam;
import com.nathan.FantasyFootballDataModule.model.FantasyTeamYear;

import java.util.List;

public interface IFantasyTeamDao {
    List<FantasyTeam> getFantasyTeams();
    FantasyTeam insertToFantasyTeam(FantasyTeam fantasyTeam);
}

