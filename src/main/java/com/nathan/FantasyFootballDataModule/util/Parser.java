package com.nathan.FantasyFootballDataModule.util;

import com.nathan.FantasyFootballDataModule.exception.InvalidInputException;
import com.nathan.FantasyFootballDataModule.constants.FantasyConstants;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.jsoup.nodes.Document;
import org.apache.commons.codec.binary.Base64;


import java.io.IOException;
import java.util.HashMap;

/**
 * The stats parser is used to persist player and player stats data.
 * Based on instance var input, a URL is created that pulls information from designated
 * sites and preps HashMap instances that can be persisted to DB tables in batch.
 * It WILL BE REQUIRED to set the season and week in order to generate the appropriate
 * url and begin parsing activity.
 *
 * This should be considered a major step in the parsing process.
 */
@Component
public class Parser {

    @Autowired
    private URIBuilder uriBuilder;

    private String sourceUrl;

    private String week;

    private String season;

    private String statsMetric;

    private HashMap<String, String> referenceMap;

    private String strUserId = "nrdevroy1217";

    private String strPasword = "Bedpan1217";

    private String authString = strUserId + ":" + strPasword;

    private String encodedString =
            new String( Base64.encodeBase64(authString.getBytes()));

    private void populateReferenceMap() {
        referenceMap = new HashMap<>();
        referenceMap.put(FantasyConstants.PLAYER_STATS_PASSING, "#passer");
        referenceMap.put(FantasyConstants.PLAYER_STATS_RUSHING, "#rusher");
        referenceMap.put(FantasyConstants.PLAYER_STATS_RECEIVING, "#receiver");
        referenceMap.put(FantasyConstants.PLAYER_STATS_KICKING, "#kicker");
        referenceMap.put(FantasyConstants.PLAYER_STATS_DEFENSIVE, "td.sort1");
        referenceMap.put(FantasyConstants.PLAYER_INGEST, "table");
        referenceMap.put(FantasyConstants.FANTASY_TEAM_INGEST, "tbody");
    }

    /**
     * Parse fantasy football player stats
     * @return Map of player data
     * @throws IOException
     * @throws InvalidInputException
     */
    public HashMap<String, String> parsePlayerStats() throws IOException, InvalidInputException {
        populateReferenceMap();
        if (referenceMap.get(statsMetric) == null) {
            throw new InvalidInputException("Invalid positional input key");
        }

        HashMap<String, String> statsMap = new HashMap<>();
        Document doc = Jsoup.connect(getSourceUrl()).maxBodySize(900000000).get();
        Elements elements = doc.select(referenceMap.get(statsMetric));

        switch (statsMetric) {
            case FantasyConstants.PLAYER_STATS_DEFENSIVE:
                int count = 0;
                String teamName = null;

                for (Element element : elements) {
                    System.out.println(element.text());
                    if(element.text().trim().matches(".*[a-zA-Z]+")) {
                        teamName = element.text().replaceAll(".*\\d\\.", "").trim();
                        count = 0;
                        statsMap.put(teamName, teamName);
                        count++;
                    }
                    switch(count) {
                        case 2: //Sacks
                            statsMap.put(new String(teamName + "_sacks"), element.text());
                            count++;
                            break;
                        case 3: //Fumble Recovery
                            statsMap.put(new String(teamName + "_fumble recovery"), element.text());
                            count++;
                            break;
                        case 4: //Int
                            statsMap.put(new String(teamName + "_interceptions"), element.text());
                            count++;
                            break;
                        case 5: //Def TD
                            statsMap.put(new String(teamName + "_defensive touchdowns"), element.text());
                            count++;
                            break;
                        case 9: //Safety
                            statsMap.put(new String(teamName + "_safety"), element.text());
                            count++;
                            break;
                        case 10: //Kick TD
                            statsMap.put(new String (teamName + "_spec teams td"), element.text());
                            count++;
                            break;
                        default:
                            count++;
                    }
                }
                break;

            default:
                for (Element element : elements) {
                    Elements rows = element.getElementsByTag("tr");
                    for (Element row : rows) {
                        String name = row.getElementsByClass("nameCell").text();
                        statsMap.put(name, name);
                        Elements stats = row.getElementsByClass("right");
                        String stat = stats.get(0).text().matches("-?\\d+") ? stats.text() : null;
                        if (stat != null) {
                            statsMap.put(name + "-stats", stat);
                        }
                    }
                }
        }
        return statsMap;
    }

    /**
     * Parse player meta data for the player DB table
     * @return a map with player data to persist
     * @throws IOException
     */
    public HashMap<String, String> parsePlayerDataForYear() throws IOException {
        populateReferenceMap();
        HashMap<String, String> playersMap = new HashMap<>();
        Document doc = Jsoup.connect(getSourceUrl()).maxBodySize(900000000).get();
        Elements elements = doc.select(referenceMap.get(statsMetric));
        for (Element element : elements) {
            Elements rows = element.getElementsByTag("td");
            for (Element row : rows) {
                String line = row.text();
                if(line.matches("^[a-zA-Z]+,.*")) {
                    String[] lineSplit = line.split(" ");
                    String lastName = lineSplit[0].replaceAll(",", "");
                    String firstName = lineSplit[1];
                    Integer posKey = null;
                    switch(lineSplit[lineSplit.length - 1]) {
                        case "QB":
                            posKey = 1;
                            break;
                        case "RB":
                            posKey = 2;
                            break;
                        case "WR":
                            posKey = 3;
                            break;
                        case "TE":
                            posKey = 4;
                            break;
                        case "PK":
                            posKey = 5;
                            break;
                        case "Def":
                            posKey = 6;
                            if(lineSplit.length > 4) {
                                firstName = lineSplit[1].concat(" ").concat(lineSplit[2]);
                            }
                            break;
                        default:
                            posKey = 7;
                    }
                    playersMap.put(firstName + " " + lastName, posKey.toString());
                }
            }
        }
        return playersMap;
    }

    /**
     * Grab ESPN data based on String input
     * @param input the league data page we need to parse
     * @return raw html in a JSoup document
     * @throws IOException
     */
    private Document getLeagueDataDocumentByField(String input) throws IOException {
        HashMap<String, String> leagueMap = new HashMap<>();
        String leagueUrl = getSourceUrl();
        Document doc = Jsoup.connect(leagueUrl)
                .maxBodySize(900000000)
                .header("Host","games.espn.go.com")
                .header("User-Agent", " Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36")
                .header("Upgrade-Insecure-Requests", "1")
                .header("Referer", "http://games.espn.com/ffl/signin?redir=http%3A%2F%2Fgames.espn.com%2Fffl%2Ftools%2Fdraftrecap%3FleagueId%3D700327")
                .header("Proxy-Connection", "keep-alive")
                .header("Cookie", "FFL_LM_COOKIE=AAAAARoAAAACAQALY291bnRyeUNvZGUBAAN1c2EBAA9jbGllbnRJUEFkZHJlc3MBAA8xOTguMjAzLjE4MS4xODE; s_vi=[CS]v1|2DA480AE85079925-600001072003A2A0[CE]; UNID=374b9af2-086c-472b-ae8d-82383b4e4778; espnAuth={\"swid\":\"{03640C81-A7BE-4DC1-A40C-81A7BE1DC153}\"}; UNID=374b9af2-086c-472b-ae8d-82383b4e4778; ctoLocalVisitor={%22user_visitor_id_local%22:%221537901220835-5776457008661%22}; optimizelyBuckets=%7B%228792134866%22%3A%220%22%7D; optimizelyEndUserId=oeu1537901221361r0.8497185906873703; s_fid=054BB7A847432B83-32AC38B7BBFFF63C; dtcAuth=; check=true; optimizelySegments=%7B%22310954789%22%3A%22none%22%2C%22311043393%22%3A%22false%22%2C%22311047346%22%3A%22gc%22%2C%22311052307%22%3A%22search%22%2C%22793783561%22%3A%22true%22%2C%22806111078%22%3A%22fantasy%22%2C%22806950111%22%3A%22desktop%22%7D; AMCVS_EE0201AC512D2BE80A490D4C%40AdobeOrg=1; AMCV_EE0201AC512D2BE80A490D4C%40AdobeOrg=-330454231%7CMCAID%7C2DA480AE85079925-600001072003A2A0%7CMCIDTS%7C17822%7CMCMID%7C50780077432047492170286440549952142047%7CMCAAMLH-1540404238%7C7%7CMCAAMB-1540404238%7CRKhpRz8krg2tLO6pguXWp5olkAcUniQYPHaMWWgdJ3xzPWQmdj0y%7CMCOPTOUT-1539806638s%7CNONE%7CvVersion%7C3.1.2; _omnicwtest=works; userZip=55442; mbox=PC#986f764a993445148d53b93f82bd6f0c.28_72#1601146020|session#d8f25cecf13e4686ab6bd26d3902681e#1539801300; ctoBrowserSession=1539799439438; ctoVisitor={%22sessionCount%22:5}; DE2=\"dXNhO21uO21pbm5lYXBvbGlzO2Jyb2FkYmFuZDs1OzU7NTs2MTM7NDUuMTY0OTQ7LTkzLjMyMDM0Ozg0MDsyNDsyOTI7Njt1czs=\"; DS=PzswO3VuaXRlZGhlYWx0aCBncm91cCBpbmNvcnBvcmF0ZWQ7; mp_6893c4491047e14ee49156ed3f91c9a5_mixpanel=%7B%22distinct_id%22%3A%20%2203640C81-A7BE-4DC1-A40C-81A7BE1DC153%22%2C%22%24initial_referrer%22%3A%20%22%24direct%22%2C%22%24initial_referring_domain%22%3A%20%22%24direct%22%2C%22__mps%22%3A%20%7B%7D%2C%22__mpso%22%3A%20%7B%7D%2C%22__mpus%22%3A%20%7B%7D%2C%22__mpa%22%3A%20%7B%7D%2C%22__mpu%22%3A%20%7B%7D%2C%22__mpap%22%3A%20%5B%5D%2C%22%24search_engine%22%3A%20%22google%22%7D; _omnicwtest=1539976977844; s_pers=%20s_c24%3D1539976977859%7C1634584977859%3B%20s_c24_s%3DLess%2520than%25201%2520day%7C1539978777859%3B%20s_gpv_pn%3Dfantasy%253Afootball%253Affl%253Asignin%7C1539978777867%3B; s_sess=%20s_ppv%3D100%3B%20s_cc%3Dtrue%3B%20s_omni_lid%3D%3B%20s_sq%3D%3B; espn_s2=AEBMvntA3%2FGX259KrK0TynJdSXY%2BX3iIbf2R4hdPSyYkfdUWVdMGIN7JmNY%2F0eCvRJNjYRJ%2B3VCU68ffArebd2EGbtefM7SudhSdBz%2F8KPKg9R8IUwBI9SYZZaplNdfI%2Bj0XkwWh7TTIQOdTmetv%2BXC6rTym7i4ozk01FEHpQHgaZ%2FOU%2Be7MNm%2FiIhGLrc1KC1HDrGIuaUga73h98KbXJWEyjQt9MuUivA7fiX9JuMLSK3uqqqMVEDK%2B7Y4gymrvkPRzxvAdJhR4Dp9avM%2F%2FWPGrp63397PRuOkqTEx3SvZryA%3D%3D; ESPN-ONESITE.WEB-PROD.api=t7EzX7qPwh6+voG9XXMEldT7y35+4a1qHV6OmTwKb/B+ZMJCNh0vzwhMS/qhGoRzmyzZGgz5vNqfEmuqsv8p0vOrRB63; ESPN-ONESITE.WEB-PROD.ts=2018-10-19T19:53:16.372Z; ESPN-ONESITE.WEB-PROD.auth=disneyid; ESPN-ONESITE.WEB-PROD-ac=XUS; SWID={03640C81-A7BE-4DC1-A40C-81A7BE1DC153}; SWID_NT=0; userZip=55442")
                .header("Accept-Language", "en-US,en;q=0.9")
                .header("Accept-Encoding", "gzip, deflate")
                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
                .header("Authorization", "Basic " + encodedString)
                .get();
        return doc;
    }

    public HashMap<String, String> parseFantasyTeamData() throws IOException {
        populateReferenceMap();
        HashMap<String, String> fantasyTeamMap = new HashMap<>();
        Document doc = getLeagueDataDocumentByField(FantasyConstants.LEAGUE_DATA_ALL_LEAGUE_MEMBERS);
        System.out.println(getSourceUrl());
        Elements elements = doc.select(referenceMap.get(statsMetric));
        for (Element element : elements) {
            Elements rows = element.getElementsByTag("tr");
            for (Element row : rows) {
                System.out.println(row.text());
            }
        }
        return fantasyTeamMap;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getStatsMetric() {
        return statsMetric;
    }

    public void setStatsMetric(String statsMetric) {
        this.statsMetric = statsMetric;
    }

    public void setSourceUrl() throws InvalidInputException {
        if(statsMetric == null) {
            throw new InvalidInputException("Must set the stats metric before defining the source URI");
        }
        if(statsMetric.equalsIgnoreCase(FantasyConstants.PLAYER_STATS_DEFENSIVE)) {
            sourceUrl = uriBuilder.buildDefStatsUri(getSeason(), getWeek());

        }
        if(statsMetric.equalsIgnoreCase(FantasyConstants.PLAYER_INGEST)) {
            sourceUrl = uriBuilder.buildPlayerIngestStatsUri(getSeason());
        }
        if(statsMetric.equalsIgnoreCase(FantasyConstants.FANTASY_TEAM_INGEST)) {
            sourceUrl = uriBuilder.buildFantasyTeamIngestUri(getSeason());
        }
        else {
            sourceUrl = uriBuilder.buildNflStatsUri(getWeek(), getSeason(), getStatsMetric());
        }
    }

    public String getSourceUrl() {
        return sourceUrl;
    }
}
