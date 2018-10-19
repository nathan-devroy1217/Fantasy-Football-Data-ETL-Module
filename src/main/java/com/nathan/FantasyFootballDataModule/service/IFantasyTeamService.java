package com.nathan.FantasyFootballDataModule.service;

import com.nathan.FantasyFootballDataModule.model.FantasyTeam;

import java.util.List;

public interface IFantasyTeamService {
    List<FantasyTeam> getAllFantasyTeams();
    FantasyTeam insertToFantasyTeamYear(FantasyTeam fantasyTeam);
}
