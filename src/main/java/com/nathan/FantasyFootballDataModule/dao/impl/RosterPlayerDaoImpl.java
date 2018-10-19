package com.nathan.FantasyFootballDataModule.dao.impl;

import com.nathan.FantasyFootballDataModule.dao.IRosterPlayerDao;
import com.nathan.FantasyFootballDataModule.model.RosterPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class RosterPlayerDaoImpl implements IRosterPlayerDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    final String INSERT_QUERY = "insert into rosterPlayer" +
            "(rosterWeekId, playerKey, fantasyPoints, passAttempts, passCompletions," +
            " passYds, passTd, interceptions, fumbles, rushAttempts, rushYds," +
            " rushTd, plays, wrPassTargets, wrPassRec, wrReceivingYds, tdReceptions," +
            " fgMade, fgAttempt, xpMade, xpAttempt, defSack, defFumbleRec, defInt,"  +
            " defTd, defSafety, specTeamsTd)" +
            " values" +
            "(:rosterWeekId, :playerKey, :fantasyPoints, :passAttempts, :passCompletions," +
            " :passYds, :passTd, :interceptions, :fumbles, :rushAttempts, :rushYds," +
            " :rushTd, :plays, :wrPassTargets, :wrPassRec, :wrReceivingYds, :tdReceptions," +
            " :fgMade, :fgAttempt, :xpMade, :xpAttempt, :defSack, :defFumbleRec, :defInt,"  +
            " :defTd, :defSafety, :specTeamsTd)";

    @Override
    public RosterPlayer insertIntoRosterPlayer(RosterPlayer player) {
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("rosterWeekId", player.getRosterWeekId())
                .addValue("playerKey", player.getPlayerKey())
                .addValue("fantasyPoints", player.getFantasyPoints())
                .addValue("passAttempts", player.getPassAttempts())
                .addValue("passCompletions", player.getPassCompletions())
                .addValue("passYds", player.getPassYds())
                .addValue("passTd", player.getPassTd())
                .addValue("interceptions", player.getInterceptions())
                .addValue("fumbles", player.getFumbles())
                .addValue("rushAttempts", player.getRushAttempts())
                .addValue("rushYds", player.getRushYds())
                .addValue("rushTd", player.getRushTd())
                .addValue("plays", player.getPlays())
                .addValue("wrPassTargets", player.getWrPassTargets())
                .addValue("wrPassRec", player.getWrPassRec())
                .addValue("wrReceivingYds", player.getWrReceivingYds())
                .addValue("tdReceptions", player.getTdReceptions())
                .addValue("fgMade", player.getFgMade())
                .addValue("fgAttempt", player.getFgAttempt())
                .addValue("xpMade", player.getXpMade())
                .addValue("xpAttempt", player.getXpAttempt())
                .addValue("defSack", player.getDefSack())
                .addValue("defFumbleRec", player.getDefFumbleRec())
                .addValue("defInt", player.getDefInt())
                .addValue("defTd", player.getDefTd())
                .addValue("defSafety", player.getDefSafety())
                .addValue("specTeamsTd", player.getSpecTeamsTd());
        namedParameterJdbcTemplate.update(INSERT_QUERY, parameters, holder);

        return player;
    }
}
