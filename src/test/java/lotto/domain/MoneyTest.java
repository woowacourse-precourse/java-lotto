package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
	@Test
	@DisplayName("숫자 외 다른 문자가 포함된 경우 예외를 발생시킨다.")
	void validateNumberRangeTest1() {
		String inputMoney = "7000a";
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Money money = new Money(inputMoney);
		});

		String expectedMessage = "[ERROR] 숫자만 입력이 가능합니다.";
		assertThat(expectedMessage).isEqualTo(exception.getMessage());
	}

	@Test
	@DisplayName("공백이 포함된 경우 예외를 발생시킨다.")
	void validateNumberRangeTest2() {
		String inputMoney = " 7000";
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Money money = new Money(inputMoney);
		});

		String expectedMessage = "[ERROR] 숫자만 입력이 가능합니다.";
		assertThat(expectedMessage).isEqualTo(exception.getMessage());
	}

	@Test
	@DisplayName("첫째자리 숫자가 0인 경우 예외를 발생시킨다.")
	void validateFirstDigitZeroTest() {
		String inputMoney = "09000";
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Money money = new Money(inputMoney);
		});

		String expectedMessage = "[ERROR] 숫자의 첫째자리로 0은 불가능합니다.";
		assertThat(expectedMessage).isEqualTo(exception.getMessage());
	}

	@Test
	@DisplayName("1000보다 작은 경우 예외를 발생시킨다.")
	void validateMultipleOfThousandTest1() {
		String inputMoney = "900";
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Money money = new Money(inputMoney);
		});

		String expectedMessage = "[ERROR] 숫자는 1000이상부터 가능합니다.";
		assertThat(expectedMessage).isEqualTo(exception.getMessage());
	}

	@Test
	@DisplayName("1000의 배수가 아닌 경우 예외를 발생시킨다.")
	void validateMultipleOfThousandTest2() {
		String inputMoney = "1900";
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Money money = new Money(inputMoney);
		});

		String expectedMessage = "[ERROR] 숫자는 1000이상부터 가능합니다.";
		assertThat(expectedMessage).isEqualTo(exception.getMessage());
	}
}
