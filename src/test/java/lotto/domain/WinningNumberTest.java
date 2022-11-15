package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumberTest {
	@DisplayName("보너스 번호가 1보다 작을 경우 예외가 발생한다.")
	@Test
	void createBonusNumberByNumberLessThen1() {
		assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 6), 0))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("보너스 번호가 45보다 클 경우 예외가 발생한다.")
	@Test
	void createBonusNumberByNumberGreaterThen45() {
		assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 6), 46))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("당첨 로또 번호에 보너스 번호와 같은 번호가 있을 경우 예외가 발생한다.")
	@Test
	void createWinningNumbersByDuplicateBonusNumber() {
		assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 6), 1))
				.isInstanceOf(IllegalArgumentException.class);
	}
}