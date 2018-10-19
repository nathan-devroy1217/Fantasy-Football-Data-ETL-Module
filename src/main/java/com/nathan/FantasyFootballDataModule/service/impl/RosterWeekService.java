package com.nathan.FantasyFootballDataModule.service.impl;

import com.nathan.FantasyFootballDataModule.dao.IRosterWeekDao;
import com.nathan.FantasyFootballDataModule.model.RosterWeek;
import com.nathan.FantasyFootballDataModule.service.IRosterWeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RosterWeekService implements IRosterWeekService {

    @Autowired
    IRosterWeekDao rosterWeekDao;

    @Override
    public RosterWeek insertIntoRosterWeekTable(RosterWeek rosterWeek) {
        return rosterWeekDao.insertIntoRosterWeek(rosterWeek);
    }
}
