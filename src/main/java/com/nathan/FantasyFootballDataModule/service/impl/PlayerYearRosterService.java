package com.nathan.FantasyFootballDataModule.service.impl;

import com.nathan.FantasyFootballDataModule.dao.IPlayerYearRosterDao;
import com.nathan.FantasyFootballDataModule.model.PlayerYearRoster;
import com.nathan.FantasyFootballDataModule.service.IPlayerYearRosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerYearRosterService implements IPlayerYearRosterService {

    @Autowired
    private IPlayerYearRosterDao playerYearRosterDao;

    @Override
    public PlayerYearRoster insertToPlayerYearRosterTable(PlayerYearRoster playerYearRoster) {
        return playerYearRosterDao.insertIntoPlayerYearRoster(playerYearRoster);
    }
}
