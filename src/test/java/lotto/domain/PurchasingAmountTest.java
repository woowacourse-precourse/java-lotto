package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchasingAmountTest {
	PurchasingAmount purchasingAmount;

	@Test
	@DisplayName("발행할 수 있는 로또의 수량을 계산한다.")
	void getNumberOfTickets() {
		purchasingAmount = new PurchasingAmount(45000);
		assertThat(purchasingAmount.getNumberOfTickets()).isEqualTo(45);
	}

	@Test
	@DisplayName("1000원 단위가 아닌 구입 금액이 입력되면 예외가 발생한다.")
	void validateNotDivisibleInput() {
		assertThatThrownBy(() -> purchasingAmount = new PurchasingAmount(242221)).isInstanceOf(
			IllegalArgumentException.class);
	}
}