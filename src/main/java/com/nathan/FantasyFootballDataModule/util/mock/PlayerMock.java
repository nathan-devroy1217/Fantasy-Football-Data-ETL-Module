package com.nathan.FantasyFootballDataModule.util.mock;

import com.github.javafaker.Faker;
import com.nathan.FantasyFootballDataModule.constants.FantasyConstants;
import com.nathan.FantasyFootballDataModule.dao.IPlayerDao;
import com.nathan.FantasyFootballDataModule.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlayerMock {

    @Autowired
    private IPlayerDao playerDao;

    public Player mockPlayerQbData() {
        Faker generator = new Faker();
        Player player = new Player();
        player.setPositionKey(FantasyConstants.QB_POSITION_KEY);
        player.setFirstName(generator.name().firstName());
        player.setLastName(generator.name().lastName());

        System.out.println(player.toJson());
        return player;
    }

    public Player mockPlayerRbData() {
        Faker generator = new Faker();
        Player player = new Player();
        player.setPositionKey(FantasyConstants.RB_POSITION_KEY);
        player.setFirstName(generator.name().firstName());
        player.setLastName(generator.name().lastName());

        System.out.println(player.toJson());
        return player;
    }

    public Player mockPlayerWrData() {
        Faker generator = new Faker();
        Player player = new Player();
        player.setPositionKey(FantasyConstants.WR_POSITION_KEY);
        player.setFirstName(generator.name().firstName());
        player.setLastName(generator.name().lastName());

        System.out.println(player.toJson());
        return player;
    }

    public Player mockPlayerTeData() {
        Faker generator = new Faker();
        Player player = new Player();
        player.setPositionKey(FantasyConstants.TE_POSITION_KEY);
        player.setFirstName(generator.name().firstName());
        player.setLastName(generator.name().lastName());

        System.out.println(player.toJson());
        return player;
    }

    public Player mockPlayerKData() {
        Faker generator = new Faker();
        Player player = new Player();
        player.setPositionKey(FantasyConstants.K_POSITION_KEY);
        player.setFirstName(generator.name().firstName());
        player.setLastName(generator.name().lastName());

        System.out.println(player.toJson());
        return player;
    }

    public Player mockPlayerDefStData() {
        Faker generator = new Faker();
        Player player = new Player();
        player.setPositionKey(FantasyConstants.DEF_ST_POSITION_KEY);
        player.setFirstName(generator.name().firstName());
        player.setLastName(generator.name().lastName());

        System.out.println(player.toJson());
        return player;
    }
}
