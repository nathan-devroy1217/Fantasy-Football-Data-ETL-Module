package com.nathan.FantasyFootballDataModule.service.impl;

import com.nathan.FantasyFootballDataModule.dao.IPlayerYearDao;
import com.nathan.FantasyFootballDataModule.model.PlayerYear;
import com.nathan.FantasyFootballDataModule.service.IPlayerYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerYearService implements IPlayerYearService {

    @Autowired
    IPlayerYearDao playerYearDao;

    @Override
    public PlayerYear insertIntoPlayerYearTable(PlayerYear playerYear) {
        return playerYearDao.insertIntoPlayerYear(playerYear);
    }
}
