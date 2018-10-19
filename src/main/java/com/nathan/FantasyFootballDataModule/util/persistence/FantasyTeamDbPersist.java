package com.nathan.FantasyFootballDataModule.util.persistence;

import com.nathan.FantasyFootballDataModule.model.FantasyTeam;
import com.nathan.FantasyFootballDataModule.runner.FantasyModuleRunner;
import com.nathan.FantasyFootballDataModule.util.Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;

@Component
public class FantasyTeamDbPersist {

    @Autowired
    private FantasyModuleRunner runner;

    public void persistFantasyTeamDataForSeason(Parser parser) throws IOException {
        HashMap<String, String> fantasyTeamMap = parser.parseFantasyTeamData();
        for(String val : fantasyTeamMap.keySet()) {
          String[] splitVals = val.split("-");
          String owner = splitVals[0];
          String team = splitVals[1];
          System.out.println("Persisting " + owner.trim() + "--->" + team.trim());
          FantasyTeam fantasyTeam = new FantasyTeam(team, owner);
          runner.insertFantasyTeamData(fantasyTeam);
        }
    }
}
