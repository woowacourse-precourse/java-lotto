package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ValidationTest {

	@DisplayName("유저가 입력한 구입금액이 숫자로만 이루어져 있는지 검증한다")
	@ParameterizedTest
	@ValueSource(strings={"1,000", "10l", "ABab"})
	void VerifyNotANumberReturningTrue(String input) {
		assertThat(Validation.isNotANumber(input)).isFalse();
	}

	@DisplayName("유저가 입력한 구입금액이 숫자로만 이루어져 있는지 검증한다")
	@ParameterizedTest
	@ValueSource(strings={"123", "10000000"})
	void VerifyNotANumberReturningFalse(String input) {
		assertThat(Validation.isNotANumber(input)).isTrue();
	}

	@DisplayName("유저가 입력한 구입금액이 1000원 단위인지 검증한다")
	@ParameterizedTest
	@ValueSource(strings={"5000", "880000"})
	void VerifyAssignedCurrencyUnitReturningTrue(String input) {
		assertThat(Validation.isAssignedCurrencyUnit(input)).isTrue();
	}

	@DisplayName("유저가 입력한 구입금액이 1000원 단위인지 검증한다")
	@ParameterizedTest
	@ValueSource(strings={"3700", "885200"})
	void VerifyAssignedCurrencyUnitReturningFalse(String input) {
		assertThat(Validation.isAssignedCurrencyUnit(input)).isFalse();
	}

	@DisplayName("유저가 입력한 구입금액이 1000원보다 큰지 검증한다")
	@Test
	void VerifyAmountIsLessThan1000(){
		assertTrue(Validation.isLessThan1000("500"));
		assertFalse(Validation.isLessThan1000("1000"));
		assertFalse(Validation.isLessThan1000("22000"));

	}

}
