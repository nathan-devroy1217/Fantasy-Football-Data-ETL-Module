package com.nathan.FantasyFootballDataModule.service;

import com.nathan.FantasyFootballDataModule.model.PlayerYear;

public interface IPlayerYearService {
    PlayerYear insertIntoPlayerYearTable(PlayerYear playerYear);
}
