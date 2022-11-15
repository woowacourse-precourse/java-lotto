package lotto.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidationUtilsTest {
	private static final String ERROR_MESSAGE = "[ERROR]";

	@DisplayName("입력이 1,000 단위로 나누어 떨어지는 수인지 검증할 수 있다.")
	@ParameterizedTest
	@ValueSource(ints = {-1, 0, 11, 12, 7004, 4_444_001})
	void validatePrice_입력이_1000_단위로_나누어떨어지는_수인지_검증(final int money) {
		Assertions.assertThatThrownBy(
				() -> InputValidationUtils.validatePrice(money)
			).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ERROR_MESSAGE);
	}

	@DisplayName("입력된 숫자가 1~45 사이의 숫자인지 검증할 수 있다.")
	@ParameterizedTest
	@ValueSource(ints = {0, 46, -1})
	void validateNumber_입력된_숫자가_1에서_45_사이의_숫자인지_검증(final int number) {
		Assertions.assertThatThrownBy(
				() -> InputValidationUtils.validateNumber(number)
			).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ERROR_MESSAGE);
	}

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
	@ValueSource(strings = {"rksdfk", "r나다,라:1", "1,2,3,4,5,6,7", "1,2,a,3,4,5"})
	void validateNumbers_당첨번호가_유효한지_검증(final String numbers) {
		final String[] splitNumbers = numbers.split(",");

		Assertions.assertThatThrownBy(
				() -> InputValidationUtils.validateNumbers(splitNumbers)
			).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ERROR_MESSAGE);
	}
}
