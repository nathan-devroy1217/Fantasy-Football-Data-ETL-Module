package com.nathan.FantasyFootballDataModule.service.impl;

import com.nathan.FantasyFootballDataModule.dao.IFantasyTeamWeekDao;
import com.nathan.FantasyFootballDataModule.model.FantasyTeamWeek;
import com.nathan.FantasyFootballDataModule.service.IFantasyTeamWeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FantasyTeamWeekService implements IFantasyTeamWeekService {

    @Autowired
    IFantasyTeamWeekDao fantasyTeamWeekDao;

    @Override
    public FantasyTeamWeek insertToFantasyTeamWeek(FantasyTeamWeek fantasyTeamWeek) {
        return fantasyTeamWeekDao.insertIntoFantasyTeamWeek(fantasyTeamWeek);
    }
}
