package com.nathan.FantasyFootballDataModule.dao;

import com.nathan.FantasyFootballDataModule.model.RosterPlayer;

public interface IRosterPlayerDao {
    RosterPlayer insertIntoRosterPlayer(RosterPlayer player);
}
