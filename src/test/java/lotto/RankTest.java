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
}
