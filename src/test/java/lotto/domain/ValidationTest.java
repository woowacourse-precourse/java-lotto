package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class ValidationTest {

	@DisplayName("스트링의 내용이 숫자로만 이루어져 있는지 검증한다")
	@ParameterizedTest
	@ValueSource(strings={"1,000", "10l", "ABab"})
	void canVerifyNumberOnlyReturningFalse(String input) {
		assertThat(Validation.isNumberOnly(input)).isFalse();
	}

	@DisplayName("스트링의 내용이 숫자로만 이루어져 있는지 검증한다")
	@ParameterizedTest
	@ValueSource(strings={"123", "10000000"})
	void canVerifyNumberOnlyReturningTrue(String input) {
		assertThat(Validation.isNumberOnly(input)).isTrue();
	}


}
