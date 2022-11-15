package lotto.domain;

import static lotto.domain.Lottery.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteryTest {

	@Test
	@DisplayName("count 6인 경우 FIRST_PLACE 반환")
	void case1() throws Exception {
		// given
		final int count = 6;
		final boolean hasBonusNumber = false;
		final Lottery expected = FIRST_PLACE;

		// when
		final Lottery result = of(count, hasBonusNumber);

		// then
		assertThat(result).isEqualTo(expected);
	}

	@Test
	@DisplayName("count 5, hasBonusNumber true 인 경우 SECOND_PLACE 반환")
	void case2() throws Exception {
		// given
		final int count = 5;
		final boolean hasBonusNumber = true;
		final Lottery expected = SECOND_PLACE;

		// when
		final Lottery result = of(count, hasBonusNumber);

		// then
		assertThat(result).isEqualTo(expected);
	}

	@Test
	@DisplayName("count 5, hasBonusNumber false 인 경우 THIRD_PLACE 반환")
	void case3() throws Exception {
		// given
		final int count = 5;
		final boolean hasBonusNumber = false;
		final Lottery expected = THIRD_PLACE;

		// when
		final Lottery result = of(count, hasBonusNumber);

		// then
		assertThat(result).isEqualTo(expected);
	}

	@Test
	@DisplayName("count 4 인 경우 FOURTH_PLACE 반환")
	void case4() throws Exception {
		// given
		final int count = 4;
		final boolean hasBonusNumber = true;
		final Lottery expected = FOURTH_PLACE;

		// when
		final Lottery result = of(count, hasBonusNumber);

		// then
		assertThat(result).isEqualTo(expected);
	}

	@Test
	@DisplayName("count 3 인 경우 FIFTH_PLACE 반환")
	void case5() throws Exception {
		// given
		final int count = 3;
		final boolean hasBonusNumber = true;
		final Lottery expected = FIFTH_PLACE;

		// when
		final Lottery result = of(count, hasBonusNumber);

		// then
		assertThat(result).isEqualTo(expected);
	}

	@Test
	@DisplayName("count 2 이하인 경우 BANG 반환")
	void case6() throws Exception {
		// given
		final int count = 2;
		final boolean hasBonusNumber = true;
		final Lottery expected = BANG;

		// when
		final Lottery result = of(count, hasBonusNumber);

		// then
		assertThat(result).isEqualTo(expected);
	}

}