package com.nathan.FantasyFootballDataModule.util.mock;

import com.nathan.FantasyFootballDataModule.dao.IFantasyTeamYearDao;
import com.nathan.FantasyFootballDataModule.model.FantasyTeamYear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class FantasyTeamYearDataMock {

    @Autowired
    private IFantasyTeamYearDao fantasyTeamYearDao;

    public FantasyTeamYear mockFantasyTeamYear() {
        FantasyTeamYear fty = new FantasyTeamYear();

        int draftIdCeiling = fantasyTeamYearDao.getMaxDraftId();
        fty.setDraftId(generateRandomInteger(1, draftIdCeiling));
        fty.setOwner(fantasyTeamYearDao.getRandomTeamName());
        int teamIdCeiling = fantasyTeamYearDao.getMaxTeamId();
        fty.setTeamId(generateRandomInteger(1, teamIdCeiling));
        int firstYear = fantasyTeamYearDao.getMinYear();
        int lastYear = fantasyTeamYearDao.getMaxYear();
        fty.setYear(generateRandomInteger(firstYear, lastYear));

        System.out.println(fty.toJson());
        return fty;
    }

    private int generateRandomInteger(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Min argument must be less than max");
        }
        Random generator = new Random(System.currentTimeMillis()); // see comments!
        int randomNum = generator.nextInt((max - min) + 1) + min;

        return randomNum;
    }
}
