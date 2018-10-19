package com.nathan.FantasyFootballDataModule.runner;

import com.nathan.FantasyFootballDataModule.model.*;
import com.nathan.FantasyFootballDataModule.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Call all services as needed
 */
@Component
public class FantasyModuleRunner {

    @Autowired
    IFantasyTeamYearService fantasyTeamYearService;

    @Autowired
    IFantasyTeamService fantasyTeamService;

    @Autowired
    IPlayerService playerService;

    @Autowired
    IPlayerYearService playerYearService;

    @Autowired
    IDraftService draftService;

    @Autowired
    IDraftRoundService draftRoundService;

    @Autowired
    IPlayerYearRosterService playerYearRosterService;

    @Autowired
    IRosterWeekService rosterWeekService;

    @Autowired
    IRosterPlayerService rosterPlayerService;

    @Autowired
    ITransactionService transactionService;

    @Autowired
    IFantasyTeamWeekService fantasyTeamWeekService;

    @Autowired
    ICompetitionService competitionService;

    public void insertFantasyTeamYearData(FantasyTeamYear fantasyTeamYear) {
        System.out.println(fantasyTeamYearService.insertToFantasyTeamYear(fantasyTeamYear).toJson());
    }

    public void insertFantasyTeamData(FantasyTeam fantasyTeam) {
        System.out.println(fantasyTeamService.insertToFantasyTeamYear(fantasyTeam).toJson());
    }

    public void insertPlayerData(Player player) {
        System.out.println(playerService.insertToPlayer(player).toJson());
    }

    public void insertPlayerYearData(PlayerYear playerYear) {
        System.out.println(playerYearService.insertIntoPlayerYearTable(playerYear).toJson());
    }

    public void insertDraftData(Draft draft) {
        System.out.println(draftService.insertDraftToDraftTable(draft).toJson());
    }

    public void insertDraftRoundData(DraftRound draftRound) {
        System.out.println(draftRoundService.insertDraftRoundToDraftRoundTable(draftRound).toJson());
    }

    public void insertPlayerYearRosterData(PlayerYearRoster playerYearRoster) {
        System.out.println(playerYearRosterService.insertToPlayerYearRosterTable(playerYearRoster).toJson());
    }

    public void insertRosterWeekData(RosterWeek rosterWeek) {
        System.out.println(rosterWeekService.insertIntoRosterWeekTable(rosterWeek).toJson());
    }

    public void insertRosterPlayerData(RosterPlayer player) {
        System.out.println(rosterPlayerService.insertIntoRosterPlayerTable(player).toJson());
    }

    public void insertTransactionData(Transaction transaction) {
        System.out.println(transactionService.insertIntoTransactionTable(transaction).toJson());
    }

    public void insertFantasyTeamWeekData(FantasyTeamWeek fantasyTeamWeek) {
        System.out.println(fantasyTeamWeekService.insertToFantasyTeamWeek(fantasyTeamWeek).toJson());
    }

    public void insertCompetitionData(Competition competition) {
        System.out.println(competitionService.insertToCompetitionTable(competition));
    }
}