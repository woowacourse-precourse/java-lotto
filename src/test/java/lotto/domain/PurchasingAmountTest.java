package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchasingAmountTest {

	@Test
	@DisplayName("발행할 수 있는 로또의 수량을 계산한다.")
	void getNumberOfTickets() {
		PurchasingAmount purchasingAmount = new PurchasingAmount(45000);
		assertThat(purchasingAmount.getNumberOfTickets()).isEqualTo(45);
	}
}