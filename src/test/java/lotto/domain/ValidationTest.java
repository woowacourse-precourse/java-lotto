package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class ValidationTest {


	@DisplayName("유저가 입력한 구입금액이 숫자로만 이루어져 있는지 검증한다")
	@ParameterizedTest
	@ValueSource(strings={"123", "10000000"})
	void canVerifyNumberOnlyReturningTrue(String input) {
		assertThat(Validation.isNumberOnly(input)).isTrue();
	}

	@DisplayName("유저가 입력한 구입금액이 숫자로만 이루어져 있는지 검증한다")
	@ParameterizedTest
	@ValueSource(strings={"1,000", "10l", "ABab"})
	void canVerifyNumberOnlyReturningFalse(String input) {
		assertThat(Validation.isNumberOnly(input)).isFalse();
	}

	@DisplayName("유저가 입력한 구입금액이 1000원보다 크고 1000원 단위인지 검증한다")
	@ParameterizedTest
	@ValueSource(strings={"1000", "880000"})
	void canVerifyAssignedCurrencyUnitReturningTrue(String input) {
		assertThat(Validation.isAssignedCurrencyUnit(input)).isTrue();
	}

	@DisplayName("유저가 입력한 구입금액이 1000원보다 크고 1000원 단위인지 검증한다")
	@ParameterizedTest
	@ValueSource(strings={"500", "3700", "885200"})
	void canVerifyAssignedCurrencyUnitReturningFalse(String input) {
		assertThat(Validation.isAssignedCurrencyUnit(input)).isFalse();
	}

}
