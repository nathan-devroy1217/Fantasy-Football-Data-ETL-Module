package com.nathan.FantasyFootballDataModule.service.impl;

import com.nathan.FantasyFootballDataModule.dao.ICompetitionDao;
import com.nathan.FantasyFootballDataModule.model.Competition;
import com.nathan.FantasyFootballDataModule.service.ICompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompetitionService implements ICompetitionService {

    @Autowired
    ICompetitionDao competitionDao;

    @Override
    public Competition insertToCompetitionTable(Competition competition) {
        return competitionDao.insertIntoCompetition(competition);
    }
}
