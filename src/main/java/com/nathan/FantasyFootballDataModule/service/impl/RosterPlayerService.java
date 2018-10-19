package com.nathan.FantasyFootballDataModule.service.impl;

import com.nathan.FantasyFootballDataModule.dao.IRosterPlayerDao;
import com.nathan.FantasyFootballDataModule.model.RosterPlayer;
import com.nathan.FantasyFootballDataModule.service.IRosterPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RosterPlayerService implements IRosterPlayerService {

    @Autowired
    IRosterPlayerDao rosterPlayerDao;

    @Override
    public RosterPlayer insertIntoRosterPlayerTable(RosterPlayer player) {
        return rosterPlayerDao.insertIntoRosterPlayer(player);
    }
}
