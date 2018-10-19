package com.nathan.FantasyFootballDataModule.dao;

import com.nathan.FantasyFootballDataModule.model.Player;

public interface IPlayerDao {
    Player insertIntoPlayer(Player player);
}
