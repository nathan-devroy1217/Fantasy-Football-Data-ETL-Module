package com.nathan.FantasyFootballDataModule.service.impl;

import com.nathan.FantasyFootballDataModule.dao.IDraftRoundDao;
import com.nathan.FantasyFootballDataModule.model.DraftRound;
import com.nathan.FantasyFootballDataModule.service.IDraftRoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DraftRoundService implements IDraftRoundService {

    @Autowired
    private IDraftRoundDao draftRoundDao;

    @Override
    public DraftRound insertDraftRoundToDraftRoundTable(DraftRound draftRound) {
        return draftRoundDao.insertDraftYearToDraftYearTable(draftRound);
    }
}
