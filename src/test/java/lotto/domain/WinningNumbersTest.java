package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

	@DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
	@Test
	void validateSize() {
		assertThatThrownBy(() -> new WinningNumbers("2,15,17,35,37,42,44,45"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
	@Test
	void validateNoDuplication() {
		assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,5"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("당첨 번호에 1부터 45까지에 없는 숫자가 있으면 예외가 발생한다.")
	@Test
	void validateNumberRange() {
		assertThatThrownBy(() -> new WinningNumbers("2,12,16,25,35,47"))
			.isInstanceOf(IllegalArgumentException.class);
	}
}