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
}
