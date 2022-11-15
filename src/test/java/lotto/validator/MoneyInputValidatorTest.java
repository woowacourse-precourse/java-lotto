package lotto.validator;

import static lotto.validator.ErrorMessage.*;
import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyInputValidatorTest {
	@DisplayName("구입금액 입력값이 하나의 숫자입력인지 확인")
	@Test
	void isNotConsistOneData() {
		//	given
		MoneyInputValidator moneyInputValidator = new MoneyInputValidator();

		assertThatThrownBy(() -> moneyInputValidator.runMoneyInputValidator("1,2,3,4,5,6"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(NOT_NUMBER.getErrorMessage());
	}

	@DisplayName("구입금액 입력값이 1000으로 나누어 떨어지는지 확인")
	@Test
	void isNotDivided() {
		// given
		MoneyInputValidator moneyInputValidator = new MoneyInputValidator();

		assertThatThrownBy(() -> moneyInputValidator.runMoneyInputValidator("12500"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(NOT_DIVIDED.getErrorMessage());
	}

}
