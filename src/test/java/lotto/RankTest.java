package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RankTest {


	@Test
	public void enum_CountTest() {
		assertThat(Rank.FIRST.getCountOfMatch()).isEqualTo(6);
		assertThat(Rank.SECOND.getCountOfMatch()).isEqualTo(5);
		assertThat(Rank.THIRD.getCountOfMatch()).isEqualTo(5);
		assertThat(Rank.FOURTH.getCountOfMatch()).isEqualTo(4);
		assertThat(Rank.FIFTH.getCountOfMatch()).isEqualTo(3);
		assertThat(Rank.MISS.getCountOfMatch()).isEqualTo(0);
	}

	@Test
	public void enum_MoneyTest() {
		assertThat(Rank.FIRST.getWinningMoney()).isEqualTo(2000000000);
		assertThat(Rank.SECOND.getWinningMoney()).isEqualTo(30000000);
		assertThat(Rank.THIRD.getWinningMoney()).isEqualTo(1500000);
		assertThat(Rank.FOURTH.getWinningMoney()).isEqualTo(50000);
		assertThat(Rank.FIFTH.getWinningMoney()).isEqualTo(5000);
		assertThat(Rank.MISS.getWinningMoney()).isEqualTo(0);
	}

	@Test
	public void valueOfTest_보너스통과() {
		assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
	}
}
