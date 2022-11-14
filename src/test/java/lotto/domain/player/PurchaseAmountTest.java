package lotto.domain.player;

import lotto.domain.util.ValidationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class PurchaseAmountTest {
	@DisplayName("유저가 구입금액을 입력시 PurchaseAmount 객체 생성을 확인한다")
	@ParameterizedTest
	@ValueSource(strings = {"1000", "50000"})
	void verifyPurchaseAmountProperlyReceived(String input) {
		assertThat(PurchaseAmount.from(input)).isInstanceOf(PurchaseAmount.class);
	}

	@DisplayName("유저가 구입금액을 잘못된 값으로 입력시 Exception 발생과 메시지를 확인한다")
	@ParameterizedTest
	@ValueSource(strings = {"100g", "1000원", "1,000"})
	void verifyPurchaseAmountNotANumber(String input) {
		assertThatThrownBy(()->PurchaseAmount.from(input))
				.isInstanceOf(ValidationException.class)
				.hasMessage(ValidationException.AMOUNT_NOT_A_NUMBER);
	}

	@DisplayName("유저가 구입금액을 잘못된 값으로 입력시 Exception 발생과 메시지를 확인한다")
	@ParameterizedTest
	@ValueSource(strings = {"999", "500", "0"})
	void verifyPurchaseAmountNotUnderLottoPrice(String input) {
		assertThatThrownBy(()-> PurchaseAmount.from(input))
				.isInstanceOf(ValidationException.class)
				.hasMessage(ValidationException.AMOUNT_LESS_THAN_1000);
	}

	@DisplayName("유저가 구입금액을 잘못된 값으로 입력시 Exception 발생과 메시지를 확인한다")
	@ParameterizedTest
	@ValueSource(strings = {"1010", "5501", "10005"})
	void verifyPurchaseAmountNotAssignedCurrencyUnit(String input) {
		assertThatThrownBy(()->PurchaseAmount.from(input))
				.isInstanceOf(ValidationException.class)
				.hasMessage(ValidationException.AMOUNT_NOT_ASSIGNED_CURRENCY_UNIT);
	}
}
