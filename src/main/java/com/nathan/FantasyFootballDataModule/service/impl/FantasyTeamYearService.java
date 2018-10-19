package com.nathan.FantasyFootballDataModule.service.impl;

import com.nathan.FantasyFootballDataModule.dao.IFantasyTeamYearDao;
import com.nathan.FantasyFootballDataModule.model.FantasyTeam;
import com.nathan.FantasyFootballDataModule.model.FantasyTeamYear;
import com.nathan.FantasyFootballDataModule.service.IFantasyTeamService;
import com.nathan.FantasyFootballDataModule.service.IFantasyTeamYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FantasyTeamYearService implements IFantasyTeamYearService {

    @Autowired
    IFantasyTeamYearDao fantasyTeamYearDao;

    @Override
    public List<FantasyTeamYear> getAllFantasyTeamYears() {
        return null;
    }

    @Override
    public FantasyTeamYear insertToFantasyTeamYear(FantasyTeamYear fantasyTeamYear) {
        return fantasyTeamYearDao.insertToFantasyTeamYear(fantasyTeamYear);
    }
}
