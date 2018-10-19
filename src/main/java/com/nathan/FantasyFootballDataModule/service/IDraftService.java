package com.nathan.FantasyFootballDataModule.service;

import com.nathan.FantasyFootballDataModule.model.Draft;

public interface IDraftService {
    Draft insertDraftToDraftTable(Draft draft);
}
