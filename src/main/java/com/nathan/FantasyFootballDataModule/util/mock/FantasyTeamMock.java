package com.nathan.FantasyFootballDataModule.util.mock;

import com.github.javafaker.Faker;
import com.nathan.FantasyFootballDataModule.dao.IFantasyTeamDao;
import com.nathan.FantasyFootballDataModule.model.FantasyTeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FantasyTeamMock {

    @Autowired
    private IFantasyTeamDao fantasyTeamDao;

    public FantasyTeam mockFantasyTeamData() {
        FantasyTeam ft = new FantasyTeam();
        ft.setOwner(generateRandomName());
        ft.setTeamName(generateRandomTeamName());

        System.out.println(ft.toJson());
        return ft;
    }

    private String generateRandomName() {
        Faker generator = new Faker();
        return generator.name().fullName();
    }

    private String generateRandomTeamName() {
        Faker generator = new Faker();
        return generator.team().name();
    }
}
