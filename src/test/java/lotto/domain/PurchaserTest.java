package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PurchaserTest {
	@DisplayName("구매금액이 1000원 단위가 아닐 경우 예외를 발생한다")
	@Test
	void createPurchaseMoneyByNotUnitOf1000() {
		assertThatThrownBy(() -> new Purchaser(1500))
				.isInstanceOf(IllegalArgumentException.class);
	}
}