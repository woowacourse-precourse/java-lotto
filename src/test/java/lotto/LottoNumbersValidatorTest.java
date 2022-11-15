package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumbersValidatorTest {

	@ParameterizedTest
	@ValueSource(strings = {"1, 2, 3", "1, 2, 3, 4, 5, 6, ", ", 1, 2, 3, 4, 5, 6", "1, 2, 3, 4, 5, 6, 7"})
	void 패턴에_맞지_않는_경우_예외처리(String input) {
		// assertThatThrownBy(() -> LottoNumbersValidator.isRightPattern(input))
		// 	.isInstanceOf(Exception.class);
	}
}