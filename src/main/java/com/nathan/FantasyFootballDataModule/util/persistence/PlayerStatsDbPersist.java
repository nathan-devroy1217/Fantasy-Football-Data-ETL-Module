package com.nathan.FantasyFootballDataModule.util.persistence;

import com.nathan.FantasyFootballDataModule.constants.FantasyConstants;
import com.nathan.FantasyFootballDataModule.exception.InvalidInputException;
import com.nathan.FantasyFootballDataModule.model.Player;
import com.nathan.FantasyFootballDataModule.model.RosterPlayer;
import com.nathan.FantasyFootballDataModule.runner.FantasyModuleRunner;
import com.nathan.FantasyFootballDataModule.util.CommonUtilities;
import com.nathan.FantasyFootballDataModule.util.Parser;
import com.nathan.FantasyFootballDataModule.util.Parser;
import com.nathan.FantasyFootballDataModule.util.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

@Component
public class PlayerStatsDbPersist {

    @Autowired
    private URIBuilder builder;

    @Autowired
    private FantasyModuleRunner runner;

    @Autowired
    CommonUtilities utilities;

    public void persistPlayeMetaDataForSeason(Parser parser) throws IOException {
        checkErrors(); //This method does nothing
        HashMap<String, String> playerMap = parser.parsePlayerDataForYear();
        Set<String> playerNames = playerMap.keySet();
        for (String name : playerNames) {
            Player player = new Player(name.split(" ")[0],
                    name.split(" ")[1],
                            Integer.parseInt(playerMap.get(name)));
            System.out.println("Inserting player..." + player.toJson());
            runner.insertPlayerData(player);
        }

    }

    //NOTE: THIS WILL BREAK UNTIL FOREIGN CONSTRAINTS ARE RESOLVED
    //FROM A DATA PERSPECTIVE
    public void persistPlayerStatsInBatch(Parser parser) throws IOException, InvalidInputException {
        checkErrors();  //This method does nothing right now
        switch(parser.getStatsMetric()) {
            case FantasyConstants.PLAYER_STATS_PASSING:
                HashMap<String, String> statsMap = parser.parsePlayerStats();
                Set<String> qbNames = statsMap.keySet();
                for (String name : qbNames) {
                    if(!name.endsWith("stats")) {
                        System.out.print(name);
                        System.out.println(" ---- " + statsMap.get(name + "-stats") );
                        String playerStatsLine = statsMap.get(name + "-stats");
                        if(playerStatsLine != null) {
                            Integer playerKey = utilities.getRosterPlayerKeyForName(name);
                            System.out.println("Player key: " + playerKey);
                            String[] statsArray = playerStatsLine.split(" ");
                            RosterPlayer player = new RosterPlayer(Integer.parseInt(parser.getWeek()),
                                    playerKey, null,
                                    Integer.parseInt(statsArray[1]), Integer.parseInt(statsArray[0]),
                                    Integer.parseInt(statsArray[2]), Integer.parseInt(statsArray[3]),
                                    Integer.parseInt(statsArray[4]), Integer.parseInt(statsArray[6]),
                                    null, null, null,
                                    null, null, null,
                                    null, null, null,
                                    null, null, null,
                                    null, null, null,
                                    null, null, null);
                            System.out.println("Inserting Player.... " + player);
                            System.out.println(runner);
                            runner.insertRosterPlayerData(player);
                        }
                    }
                }
                break;
            case FantasyConstants.PLAYER_STATS_RUSHING:
                break;
            case FantasyConstants.PLAYER_STATS_RECEIVING:
                break;
            case FantasyConstants.PLAYER_STATS_KICKING:
                break;
            case FantasyConstants.PLAYER_STATS_DEFENSIVE:
                break;

        }
    }

    private void checkErrors() {

    }
}
