package lotto.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {

	@Test
	@DisplayName("정수인 입력을 검증한다.")
	void validateIntegerInput() {
		assertThatNoException().isThrownBy(() -> Validator.validateIntegerOrNot("1234"));
	}

	@Test
	@DisplayName("정수가 아닌 입력이 들어오면 예외가 발생한다.")
	void validate() {
		assertThatThrownBy(() -> Validator.validateIntegerOrNot("abc")).isInstanceOf(IllegalArgumentException.class);
	}
}