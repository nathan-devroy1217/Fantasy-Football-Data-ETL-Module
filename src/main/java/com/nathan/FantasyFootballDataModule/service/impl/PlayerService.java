package com.nathan.FantasyFootballDataModule.service.impl;

import com.nathan.FantasyFootballDataModule.dao.IPlayerDao;
import com.nathan.FantasyFootballDataModule.model.Player;
import com.nathan.FantasyFootballDataModule.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class PlayerService implements IPlayerService {

    @Autowired
    IPlayerDao playerDao;

    @Override
    public Player insertToPlayer(Player player) {
        return playerDao.insertIntoPlayer(player);
    }
}
