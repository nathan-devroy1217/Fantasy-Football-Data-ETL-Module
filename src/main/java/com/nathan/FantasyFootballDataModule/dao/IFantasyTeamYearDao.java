package com.nathan.FantasyFootballDataModule.dao;

import com.nathan.FantasyFootballDataModule.model.FantasyTeamYear;

import java.util.List;

public interface IFantasyTeamYearDao {
    List<FantasyTeamYear> getFantasyTeamYears();
    FantasyTeamYear insertToFantasyTeamYear(FantasyTeamYear fantasyTeamYear);
    int getMaxDraftId();
    int getMaxTeamId();
    int getMinYear();
    int getMaxYear();
    String getRandomTeamName();
}
