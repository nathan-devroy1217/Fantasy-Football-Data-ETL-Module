package com.nathan.FantasyFootballDataModule.dao;

import com.nathan.FantasyFootballDataModule.model.Draft;

public interface IDraftDao {
    Draft insertDrafttoDraftTable(Draft draft);
}
