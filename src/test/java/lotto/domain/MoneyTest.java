package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
	@Test
	@DisplayName("구매금액에 숫자 외 다른 문자가 포함된 경우 예외를 발생시킨다.")
	void validateNumberRangeTest1() {
		String inputMoney = "7000a";
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Money money = new Money(inputMoney);
		});

		String expectedMessage = "[ERROR] 숫자만 입력해 주시기 바랍니다.";
		assertThat(expectedMessage).isEqualTo(exception.getMessage());
	}

	@Test
	@DisplayName("구매금액에 공백이 포함된 경우 예외를 발생시킨다.")
	void validateNumberRangeTest2() {
		String inputMoney = " 7000";
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Money money = new Money(inputMoney);
		});

		String expectedMessage = "[ERROR] 숫자만 입력해 주시기 바랍니다.";
		assertThat(expectedMessage).isEqualTo(exception.getMessage());
	}

	@Test
	@DisplayName("구매금액의 첫째자리 숫자가 0인 경우 예외를 발생시킨다.")
	void validateFirstDigitZeroTest1() {
		String inputMoney = "09000";
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Money money = new Money(inputMoney);
		});

		String expectedMessage = "[ERROR] 두자리 이상의 숫자중 첫째자리는 1이상으로 입력해 주시기 바랍니다.";
		assertThat(expectedMessage).isEqualTo(exception.getMessage());
	}

	@Test
	@DisplayName("구매금액이 0인 경우 예외를 발생시킨다.")
	void validateFirstDigitZeroTest2() {
		String inputMoney = "0";
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Money money = new Money(inputMoney);
		});

		String expectedMessage = "[ERROR] 구매금액은 1.000이상으로 입력해 주시기 바랍니다.";
		assertThat(expectedMessage).isEqualTo(exception.getMessage());
	}

	@Test
	@DisplayName("구매금액이 1000보다 작은 경우 예외를 발생시킨다.")
	void validateMultipleOfThousandTest1() {
		String inputMoney = "900";
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Money money = new Money(inputMoney);
		});

		String expectedMessage = "[ERROR] 구매금액은 1000의 배수로 입력해 주시기 바랍니다.";
		assertThat(expectedMessage).isEqualTo(exception.getMessage());
	}

	@Test
	@DisplayName("구매금액이 1000의 배수가 아닌 경우 예외를 발생시킨다.")
	void validateMultipleOfThousandTest2() {
		String inputMoney = "1900";
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Money money = new Money(inputMoney);
		});

		String expectedMessage = "[ERROR] 구매금액은 1000의 배수로 입력해 주시기 바랍니다.";
		assertThat(expectedMessage).isEqualTo(exception.getMessage());
	}

	@Test
	@DisplayName("구매금액이 최대 입력 가능 금액 초과일때 예외를 발생시킨다.")
	void validateOverMaxNumberTest() {
		String inputMoney = "3000000000";
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Money money = new Money(inputMoney);
		});

		String expectedMessage = "[ERROR] 구매금액은 2,000,000,000이하로 입력해 주시기 바랍니다.";
		assertThat(expectedMessage).isEqualTo(exception.getMessage());
	}
}
