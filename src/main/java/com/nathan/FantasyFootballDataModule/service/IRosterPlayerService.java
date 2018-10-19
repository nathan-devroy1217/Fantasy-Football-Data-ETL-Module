package com.nathan.FantasyFootballDataModule.service;

import com.nathan.FantasyFootballDataModule.model.RosterPlayer;

public interface IRosterPlayerService {
    RosterPlayer insertIntoRosterPlayerTable(RosterPlayer player);
}
