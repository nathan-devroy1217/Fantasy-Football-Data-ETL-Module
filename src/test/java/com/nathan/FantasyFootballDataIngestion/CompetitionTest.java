package com.nathan.FantasyFootballDataIngestion;

import com.nathan.FantasyFootballDataModule.FantasyFootballDataIngestionApplication;
import com.nathan.FantasyFootballDataModule.model.Competition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
public class CompetitionTest {

	@Test
	public void modelTest() {
		Competition competition = new Competition();
		competition.setAwayTeamKey(1);
		competition.setAwayTeamScore(22);
		competition.setHomeTeamKey(2);
		competition.setHomeTeamScore(34);
		competition.setTeamWeekId(2);
		competition.setWeek(4);

		assertTrue(competition != null);
	}

}
