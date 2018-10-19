package com.nathan.FantasyFootballDataModule.runner;

import com.nathan.FantasyFootballDataModule.constants.FantasyConstants;
import com.nathan.FantasyFootballDataModule.exception.InvalidInputException;
import com.nathan.FantasyFootballDataModule.util.Parser;
import com.nathan.FantasyFootballDataModule.util.URIBuilder;
import com.nathan.FantasyFootballDataModule.util.mock.FantasyTeamMock;
import com.nathan.FantasyFootballDataModule.util.mock.FantasyTeamYearDataMock;
import com.nathan.FantasyFootballDataModule.util.mock.PlayerMock;
import com.nathan.FantasyFootballDataModule.util.persistence.FantasyTeamDbPersist;
import com.nathan.FantasyFootballDataModule.util.persistence.PlayerStatsDbPersist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;

@Component
class GlobalRunListener implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    FantasyModuleRunner runner;

    @Autowired
    FantasyTeamYearDataMock fantasyTeamYearDataMock;

    @Autowired
    FantasyTeamMock fantasyTeamMock;

    @Autowired
    PlayerMock playerMock;

    @Autowired
    URIBuilder builder;

    @Autowired
    Parser parser;

    @Autowired
    PlayerStatsDbPersist playerStatsDbPersist;

    @Autowired
    FantasyTeamDbPersist fantasyTeamDbPersist;


    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        System.out.println("\n\n-~----~-~-~~~-----~---~--STARTING RUN LISTENER-~---~----~--~--------~-----~\n");

        //System.out.println(builder.buildNflStatsUri(String.valueOf(1), String.valueOf(2018), "Passing"));

        parser.setWeek("6");
        parser.setSeason("2018");
        parser.setStatsMetric(FantasyConstants.FANTASY_TEAM_INGEST);
        try {
            parser.setSourceUrl();
            fantasyTeamDbPersist.persistFantasyTeamDataForSeason(parser);

            //playerStatsDbPersist.persistPlayerStatsInBatch(parser);
        } catch (InvalidInputException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        /*try {
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }
        */
       /* try {
            HashMap<String, String> map = parser.parse();
            for(String key : map.keySet()) {
                if(!key.endsWith("stats") && map.get(key + "-stats") != null) {
                    String name = key;
                    System.out.println(name);
                    System.out.println(map.get(name + "-stats"));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidInputException e) {
            e.printStackTrace();
        } */
        System.out.println("\n-~----~-~-~~~-----~---~--STOPPING RUN LISTENER-~---~----~--~--------~-----~");
    }
}
