package lotto.domain.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BonusBallTest {

	@Test
	void 제대로_동작() {
		List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		BonusBall bonusBall = new BonusBall("45", winningNumbers);
		assertEquals(45, bonusBall.getBonusBall());
	}

	@Test
	void 범위_예외처리_1미만() {
		List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

		assertThatThrownBy(() -> new BonusBall("0", winningNumbers))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 범위_예외처리_45초과() {
		List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

		assertThatThrownBy(() -> new BonusBall("46", winningNumbers))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 문자_예외처리() {
		List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

		assertThatThrownBy(() -> new BonusBall("4a6", winningNumbers))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 당첨번호랑_중복() {
		List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

		assertThatThrownBy(() -> new BonusBall("1", winningNumbers))
				.isInstanceOf(IllegalArgumentException.class);
	}
}