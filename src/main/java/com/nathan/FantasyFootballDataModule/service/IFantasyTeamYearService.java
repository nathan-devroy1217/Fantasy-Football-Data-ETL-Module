package com.nathan.FantasyFootballDataModule.service;

import com.nathan.FantasyFootballDataModule.model.FantasyTeamYear;

import java.util.List;

public interface IFantasyTeamYearService {
    List<FantasyTeamYear> getAllFantasyTeamYears();
    FantasyTeamYear insertToFantasyTeamYear(FantasyTeamYear fantasyTeamYear);
}
