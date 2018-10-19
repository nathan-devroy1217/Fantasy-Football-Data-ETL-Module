package com.nathan.FantasyFootballDataModule.util;

import com.nathan.FantasyFootballDataModule.constants.FantasyConstants;
import org.springframework.stereotype.Component;

@Component
public class URIBuilder {

    public String buildNflStatsUri(String week, String season, String statsMetric) {
        String result = FantasyConstants.NFL_STATS_MAIN_STATIC +
                FantasyConstants.NFL_STATS_WEEK_PREFIX + week +
                FantasyConstants.NFL_STATS_SEASON_PREFIX + season +
                FantasyConstants.NFL_STATS_REGULAR_SEASON_STATIC +
                FantasyConstants.NFL_STATS_POSITION_CATEGORY + statsMetric;
        return result;
    }

    public String buildDefStatsUri(String year, String week) {
        String result = FantasyConstants.NFL_STATS_DEF_MAIN_STATIC + year +
                FantasyConstants.NFL_STATS_DEF_POST_YEAR_STATC + week +
                FantasyConstants.NFL_STATS_DEF_POST_WEEK_STATIC;
        return result;
    }

    public String buildPlayerIngestStatsUri(String year) {
        String result = FantasyConstants.PLAYER_DATA_MAIN_STATIC + year +
                FantasyConstants.PLAYER_DATA_POST_YEAR;
        return result;
    }

    public String buildFantasyTeamIngestUri(String year) {
        String result = FantasyConstants.LEAGUE_DATA_ALL_LEAGUE_MEMBERS + year;
        return result;
    }
}