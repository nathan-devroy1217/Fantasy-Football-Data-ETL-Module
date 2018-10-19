package com.nathan.FantasyFootballDataModule.dao;

import com.nathan.FantasyFootballDataModule.model.DraftRound;

public interface IDraftRoundDao {
    DraftRound insertDraftYearToDraftYearTable(DraftRound draftYear);
}
