package com.nathan.FantasyFootballDataModule.service.impl;

import com.nathan.FantasyFootballDataModule.dao.IDraftDao;
import com.nathan.FantasyFootballDataModule.model.Draft;
import com.nathan.FantasyFootballDataModule.service.IDraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DraftService implements IDraftService {

    @Autowired
    private IDraftDao draftDao;

    @Override
    public Draft insertDraftToDraftTable(Draft draft) {
        return draftDao.insertDrafttoDraftTable(draft);
    }
}
