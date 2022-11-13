package lotto.util;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {

	@Test
	@DisplayName("당첨 번호 입력의 형식이 올바른지 검증한다.")
	void v1alidateIntegerInput() {
		assertThatThrownBy(() -> Validator.validateFormOfWinningNumbers("12,3,4,5,5")).isInstanceOf(
			IllegalArgumentException.class);
	}

	@Test
	@DisplayName("정수인 입력을 검증한다.")
	void validateIntegerInput() {
		assertThatNoException().isThrownBy(() -> Validator.validateIntegerOrNot("1234"));
	}

	@Test
	@DisplayName("정수가 아닌 입력이 들어오면 예외가 발생한다.")
	void validateNotIntegerInput() {
		assertThatThrownBy(() -> Validator.validateIntegerOrNot("abc")).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("1000원 단위가 아닌 구입 금액이 입력되면 예외가 발생한다.")
	void validateNotDivisibleInput() {
		assertThatThrownBy(() -> Validator.validateDivisibility(242221)).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("1000원 단위의 입력인지 검증한다.")
	void validateDivisibleInput() {
		assertThatNoException().isThrownBy(() -> Validator.validateDivisibility(4214000));
	}

	@Test
	@DisplayName("1부터 45까지의 숫자인지 검증한다.")
	void validateNumberRange() {
		assertThatThrownBy(() -> Validator.validateNumberRange(47)).isInstanceOf(
			IllegalArgumentException.class);
	}

	@Test
	@DisplayName("숫자 간에 중복이 있는지 검증한다.")
	void validateNoDuplication() {
		assertThatThrownBy(() -> Validator.validateNoDuplication(List.of(2, 4, 16, 23, 23, 42))).isInstanceOf(
			IllegalArgumentException.class);
	}

	@Test
	@DisplayName("숫자들의 개수가 6개인지 검증한다.")
	void validateSizeOfNumbers() {
		assertThatThrownBy(() -> Validator.validateSizeOfNumbers(List.of(1, 5, 16, 25, 32))).isInstanceOf(
			IllegalArgumentException.class);
	}

	@DisplayName("숫자가 리스트에 들어있지 않은지 검증한다.")
	@Test
	void validateExclusion() {
		assertThatThrownBy(() -> Validator.validateExclusion(2, List.of(1,2,15,16))).isInstanceOf(IllegalArgumentException.class);
	}
}