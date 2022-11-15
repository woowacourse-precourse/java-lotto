package lotto.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidationUtilsTest {

	private static final String ERROR_MESSAGE = "[ERROR]";

	@DisplayName("입력된 문자열이 숫자로만 이루어져 있는지 검증할 수 있다.")
	@ParameterizedTest
	@ValueSource(strings = {"rksdfk", "r나다라1", "13456l"})
	void validateFormat_입력된_문자열이_숫자로만_이루어져_있는지_검증(final String input) {
		Assertions.assertThatThrownBy(
				() -> InputValidationUtils.validateFormat(input)
			).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ERROR_MESSAGE);
	}

	@DisplayName("입력된 당첨 번호가 유효한지 검증할 수 있다.")
	@ParameterizedTest
	@ValueSource(strings = {"rksdfk", "r나다,라:1", "1,2,a,3,4,5"})
	void validateNumbers_당첨번호가_유효한지_검증(final String numbers) {
		final String[] splitNumbers = numbers.split(",");

		Assertions.assertThatThrownBy(
				() -> InputValidationUtils.validateNumbers(splitNumbers)
			).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ERROR_MESSAGE);
	}
}
