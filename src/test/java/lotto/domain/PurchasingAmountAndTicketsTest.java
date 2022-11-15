package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchasingAmountAndTicketsTest {
	PurchasingAmountAndTickets purchasingAmountAndTickets;

	@Test
	@DisplayName("발행할 수 있는 로또의 수량을 계산한다.")
	void getNumberOfTickets() {
		purchasingAmountAndTickets = new PurchasingAmountAndTickets(45000);
		assertThat(purchasingAmountAndTickets.getNumberOfTickets()).isEqualTo(45);
	}

	@Test
	@DisplayName("1000원 단위가 아닌 구입 금액이 입력되면 예외가 발생한다.")
	void validateNotDivisibleInput() {
		assertThatThrownBy(() -> purchasingAmountAndTickets = new PurchasingAmountAndTickets(242221)).isInstanceOf(
			IllegalArgumentException.class);
	}
}