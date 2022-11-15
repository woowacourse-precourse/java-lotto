package lotto.mytest;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.util.Rank;

public class RankTest {
	int matchCount;
	boolean matchBonus;

	@DisplayName("로또 1등 당첨 확인")
	@Test
	void first() {
		matchCount = 6;
		matchBonus = false;
		assertThat(Rank.setRank(matchCount, matchBonus)).isEqualTo(Rank.FIRST);
	}

	@DisplayName("로또 2등 당첨 확인")
	@Test
	void second() {
		matchCount = 5;
		matchBonus = true;
		assertThat(Rank.setRank(matchCount, matchBonus)).isEqualTo(Rank.SECOND);
	}

	@DisplayName("로또 3등 당첨 확인")
	@Test
	void third() {
		matchCount = 5;
		matchBonus = false;
		assertThat(Rank.setRank(matchCount, matchBonus)).isEqualTo(Rank.THIRD);
	}

	@DisplayName("로또 4등 당첨 확인")
	@Test
	void fourth() {
		matchCount = 4;
		matchBonus = false;
		assertThat(Rank.setRank(matchCount, matchBonus)).isEqualTo(Rank.FOURTH);
	}

	@DisplayName("로또 5등 당첨 확인")
	@Test
	void fifth() {
		matchCount = 3;
		matchBonus = false;
		assertThat(Rank.setRank(matchCount, matchBonus)).isEqualTo(Rank.FIFTH);
	}

	@DisplayName("로또 꽝 확인")
	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2})
	void miss(int matchCount) {
		this.matchCount = matchCount;
		matchBonus = false;
		assertThat(Rank.setRank(matchCount, matchBonus)).isEqualTo(Rank.NOTHING);
	}
}
