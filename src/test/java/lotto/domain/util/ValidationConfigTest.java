package lotto.domain.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ValidationConfigTest {
	@DisplayName("유저가 입력한 구입금액이 숫자로만 이루어져 있는지 검증한다")
	@ParameterizedTest
	@ValueSource(strings = {"1,000", "10l", "ABab"})
	void VerifyNotANumberReturningTrue(String input) {
		assertThat(ValidationConfig.isNotANumber(input)).isTrue();
	}

	@DisplayName("유저가 입력한 구입금액이 숫자로만 이루어져 있는지 검증한다")
	@ParameterizedTest
	@ValueSource(strings = {"123", "10000000"})
	void VerifyNotANumberReturningFalse(String input) {
		assertThat(ValidationConfig.isNotANumber(input)).isFalse();
	}

	@DisplayName("유저가 입력한 구입금액이 1000원 단위인지 검증한다")
	@ParameterizedTest
	@ValueSource(strings = {"5000", "880000"})
	void VerifyAssignedCurrencyUnitReturningTrue(String input) {
		assertThat(ValidationConfig.isAssignedCurrencyUnit(input)).isTrue();
	}

	@DisplayName("유저가 입력한 구입금액이 1000원 단위인지 검증한다")
	@ParameterizedTest
	@ValueSource(strings = {"3700", "885200"})
	void VerifyAssignedCurrencyUnitReturningFalse(String input) {
		assertThat(ValidationConfig.isAssignedCurrencyUnit(input)).isFalse();
	}

	@DisplayName("유저가 입력한 구입금액이 1000원보다 큰지 검증한다")
	@Test
	void VerifyAmountIsLessThan1000() {
		assertTrue(ValidationConfig.isLessThanMinimumAmount("500"));
		assertFalse(ValidationConfig.isLessThanMinimumAmount("1000"));
		assertFalse(ValidationConfig.isLessThanMinimumAmount("22000"));
	}

	@DisplayName("유저가 입력한 당첨번호가 형식에 맞게 입력되었는지를 검증한다")
	@Test
	void VerifyIsCorrectlyFormatted() {
		assertTrue(ValidationConfig.isWinningNumberCorrectlyFormatted("1,2"));
		assertTrue(ValidationConfig.isWinningNumberCorrectlyFormatted("1,2,30,a,b,c"));
	}

	@DisplayName("유저가 입력한 당첨번호가 6개인지를 검증한다")
	@Test
	void VerifyIsCountCorrectlyProvided() {
		assertTrue(ValidationConfig.isWinningNumberCountCorrectlyProvided("1,2,5,10,20,30"));
	}

	@DisplayName("유저가 입력한 당첨번호가 1이상 45이하의 자연수인지를 검증한다")
	@Test
	void VerifyIsCorrectlyRanged() {
		assertTrue(ValidationConfig.isWinningNumberCorrectlyRanged("1,2,3,4,5,45"));
		assertFalse(ValidationConfig.isWinningNumberCorrectlyRanged("1,2,3,4,5,46"));
		assertFalse(ValidationConfig.isWinningNumberCorrectlyRanged("0,2,3,4,5,45"));
	}

	@DisplayName("유저가 입력한 당첨번호에 중복이 존재하는지를 검증한다")
	@Test
	void VerifyIsDuplicateExists() {
		assertTrue(ValidationConfig.isWinningNumberDuplicateExists("1,1,3,4,5,45"));
		assertFalse(ValidationConfig.isWinningNumberDuplicateExists("1,2,3,4,5,45"));
	}

	@DisplayName("유저가 입력한 보너스 번호가 1 이상 45 이하의 자연수인지를 검증한다")
	@Test
	void verifyIsBonusNumberCorrectlyRanged() {
		assertTrue(ValidationConfig.isBonusNumberCorrectlyRanged("10"));
	}

	@DisplayName("유저가 입력한 보너스 번호의 개수가 1개인지를 검증한다")
	@Test
	void verifyIsBonusNumberCountCorrectlyProvided() {
		assertTrue(ValidationConfig.isBonusNumberCountCorrectlyProvided("40"));
	}

	@DisplayName("유저가 입력한 보너스 번호와 당첨번호간 중복이 존재하는지를 검증한다")
	@Test
	void verifyIsBonusNumberDuplicateExistsReturningTrue() {
		List<Integer> testNumbers = List.of(1, 2, 3, 4, 10, 15);
		assertTrue(ValidationConfig.isBonusNumberDuplicateExists("10", testNumbers));
	}

	@DisplayName("유저가 입력한 보너스 번호와 당첨번호간 중복이 존재하는지를 검증한다")
	@Test
	void verifyIsBonusNumberDuplicateExistsReturningFalse() {
		List<Integer> testNumbers = List.of(1, 2, 3, 4, 5, 6);
		assertFalse(ValidationConfig.isBonusNumberDuplicateExists("30", testNumbers));
	}
}
