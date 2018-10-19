package com.nathan.FantasyFootballDataModule.constants;

public class FantasyConstants {

    //Position key constants
    public static final int QB_POSITION_KEY = 1;
    public static final int RB_POSITION_KEY = 2;
    public static final int WR_POSITION_KEY = 3;
    public static final int TE_POSITION_KEY = 4;
    public static final int K_POSITION_KEY = 5;
    public static final int DEF_ST_POSITION_KEY = 6;
    public static final int OTHER_POSITION_KEY = 7;

    //Build all URI's except DEF
    public static final String NFL_STATS_MAIN_STATIC = "http://www.nfl.com/stats/weeklyleaders";
    public static final String NFL_STATS_WEEK_PREFIX = "?week=";
    public static final String NFL_STATS_SEASON_PREFIX = "&season=";
    public static final String NFL_STATS_REGULAR_SEASON_STATIC = "&type=REG";
    public static final String NFL_STATS_POSITION_CATEGORY = "&showCategory=";

    //Build DEF URI
    public static final String NFL_STATS_DEF_MAIN_STATIC = "http://fftoday.com/stats/playerstats.php?Season=";
    public static final String NFL_STATS_DEF_POST_YEAR_STATC = "&GameWeek=";
    public static final String NFL_STATS_DEF_POST_WEEK_STATIC = "&PosID=99&LeagueID=";

    //Build player data import URI
    public static final String PLAYER_DATA_MAIN_STATIC = "http://www03.myfantasyleague.com/";
    public static final String PLAYER_DATA_POST_YEAR = "/adp?COUNT=500&POS=&ROOKIES=0&INJURED=0&CUTOFF=5&FRANCHISES=-1&IS_PPR=-1&IS_KEEPER=0&IS_MOCK=-1&TIME=";

    //ESPN Fantasy League uri paths
    public static final String LEAGUE_DATA_ALL_TEAM_ROSTERS = "http://games.espn.com/ffl/leaguerosters?leagueId=700327&seasonId=";
    public static final String LEAGUE_DATA_ALL_LEAGUE_MEMBERS = "http://games.espn.com/ffl/leaguesetup/ownerinfo?leagueId=700327&seasonId=";
    public static final String LEAGUE_DATA_FULL_SEASON_SCHEDULE = "http://games.espn.com/ffl/schedule?leagueId=700327&seasonId=";
    public static final String LEAGUE_DATA_DRAFT_HISTORY = "http://games.espn.com/ffl/tools/draftrecap?leagueId=700327&seasonId=";

    //Uri string constants for parser
    public static final String PLAYER_STATS_PASSING = "Passing";
    public static final String PLAYER_STATS_RUSHING = "Rushing";
    public static final String PLAYER_STATS_RECEIVING = "Receiving";
    public static final String PLAYER_STATS_KICKING = "Placekick";
    public static final String PLAYER_STATS_DEFENSIVE = "Defensive";
    public static final String PLAYER_INGEST = "Ingest";
    public static final String FANTASY_TEAM_INGEST = "Fantasy Team Ingest";
}
