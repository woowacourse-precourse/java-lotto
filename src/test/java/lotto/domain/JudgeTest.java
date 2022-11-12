package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.utils.LottoType;

class JudgeTest {
	@DisplayName("1등 당첨시.")
	@Test
	void firstWin() {
		assertThat(
			Judge.getPrize(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new LottoBonus(7),
				new LottoTicket(List.of(1, 2, 3, 4, 5, 6)))).isEqualTo(
			LottoType.FIRST);
	}

	@DisplayName("2등 당첨시")
	@Test
	void secondWin() {
		assertThat(
			Judge.getPrize(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new LottoBonus(7),
				new LottoTicket(List.of(1, 2, 3, 4, 5, 7)))).isEqualTo(
			LottoType.SECOND);
	}

	@DisplayName("3등 당첨시")
	@Test
	void thirdWin() {
		assertThat(
			Judge.getPrize(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new LottoBonus(7),
				new LottoTicket(List.of(1, 2, 3, 4, 5, 8)))).isEqualTo(
			LottoType.THIRD);
	}

	@DisplayName("4등 당첨시")
	@Test
	void fourthWin() {
		assertThat(
			Judge.getPrize(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new LottoBonus(7),
				new LottoTicket(List.of(1, 2, 3, 4, 8, 9)))).isEqualTo(
			LottoType.FOURTH);
	}

	@DisplayName("5등 당첨시")
	@Test
	void fifthWin() {
		assertThat(
			Judge.getPrize(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new LottoBonus(7),
				new LottoTicket(List.of(1, 2, 3, 8, 9, 10)))).isEqualTo(
			LottoType.FIFTH);
	}
}