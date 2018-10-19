package com.nathan.FantasyFootballDataModule.service.impl;

import com.nathan.FantasyFootballDataModule.dao.IFantasyTeamDao;
import com.nathan.FantasyFootballDataModule.dao.IFantasyTeamYearDao;
import com.nathan.FantasyFootballDataModule.model.FantasyTeam;
import com.nathan.FantasyFootballDataModule.model.FantasyTeamYear;
import com.nathan.FantasyFootballDataModule.service.IFantasyTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FantasyTeamService implements IFantasyTeamService {

    @Autowired
    private IFantasyTeamDao fantasyTeamDao;

    @Override
    public List<FantasyTeam> getAllFantasyTeams() {
        return null;
    }

    @Override
    public FantasyTeam insertToFantasyTeamYear(FantasyTeam fantasyTeam) {
        return fantasyTeamDao.insertToFantasyTeam(fantasyTeam);
    }
}
