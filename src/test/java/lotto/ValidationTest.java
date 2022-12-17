package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.checker.Validation;

public class ValidationTest {
	public String userInput = "";
	public List<String> winningNumber;
	public List<String> bonusNumber;

	@DisplayName("로또 구입 금액 input 검증 테스트")
	@Test
	void validatePriceExceptionTest_메서드_테스트() {
		Assertions.assertAll(
			() -> validateNumberOnlyException_메서드_테스트(),
			() -> validatePriceRangeException_메서드_테스트()
		);
	}

	@DisplayName("숫자 외의 입력 예외처리")
	void validateNumberOnlyException_메서드_테스트() {
		userInput = "ㅁ";
		Assertions.assertThrows(IllegalArgumentException.class,
			() -> Validation.validateNumberOnly(Arrays.asList(userInput)));
	}

	@DisplayName("올바르지 않은 구매금액 예외처리")
	@ParameterizedTest
	@CsvSource(value = {"1000001", "999", "1004"})
	void validatePriceRangeException_메서드_테스트() {
		Assertions.assertThrows(IllegalArgumentException.class,
			() -> Validation.validateNumberOnly(Arrays.asList(userInput)));
	}

	@DisplayName("당첨 번호 input 검증 테스트")
	@Test
	void validateWinningNumberInput_메서드_테스트() {
		Assertions.assertAll(
			() -> validateNumberOnlyException_메서드_테스트(),
			() -> validateLengthException_메서드_테스트(),
			() -> validateSameNumberException_메서드_테스트(),
			() -> validateNumberRangeException_메서드_테스트()
		);
	}

	@DisplayName("[1,45] 범위가 아닌 숫자 예외 처리")
	private void validateNumberRangeException_메서드_테스트() {
		winningNumber = new ArrayList<>(List.of("1", "2", "3", "4", "0", "50"));
		Assertions.assertThrows(IllegalArgumentException.class,
			() -> Validation.validateNumberRange(Arrays.asList(userInput)));
	}

	@DisplayName("중복된 숫자 예외 처리")
	private void validateSameNumberException_메서드_테스트() {
		winningNumber = new ArrayList<>(List.of("1", "2", "3", "4", "5", "1"));
		Assertions.assertThrows(IllegalArgumentException.class,
			() -> Validation.validateSameNumber(winningNumber));
	}

	@DisplayName("올바르지 않은 길이의 input 예외처리")
	private void validateLengthException_메서드_테스트() {
		List<String> winningNumber = new ArrayList<>(List.of("1", "2", "3", "4", "5", "6", "7"));
		Assertions.assertThrows(IllegalArgumentException.class,
			() -> Validation.validateLength(winningNumber, 6));
	}

	@DisplayName("보너스 번호 input 테스트")
	@Test
	void validateBonusNumberInput_메서드_테스트() {
		Assertions.assertAll(
			() -> validateNumberOnlyException_메서드_테스트(),
			() -> validateLengthException_메서드_테스트(),
			() -> validateSameNumberInWinningNumberException_메서드_테스트(),
			() -> validateNumberRangeException_메서드_테스트()
		);
	}

	@DisplayName("보너스 번호, 당첨 번호 중복시 예외 처리")
	private void validateSameNumberInWinningNumberException_메서드_테스트() {
		winningNumber = new ArrayList<>(List.of("1", "2", "3", "4", "5", "6"));
		bonusNumber = new ArrayList<>(List.of("1"));

		Assertions.assertThrows(IllegalArgumentException.class,
			() -> Validation.validateSameNumberInWinningNumber(winningNumber, bonusNumber));
	}
}
