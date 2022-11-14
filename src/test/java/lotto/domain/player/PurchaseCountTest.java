package lotto.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class PurchaseCountTest {
	@DisplayName("유저가 구입금액을 입력시 PurchaseCount 객체 생성을 확인한다")
	@Test
	void verifyPurchaseCountProperlyProcessed() {
		PurchaseAmount purchaseAmount = PurchaseAmount.from("1000");
		assertThat(PurchaseCount.from(purchaseAmount)).isInstanceOf(PurchaseCount.class);
	}

	@DisplayName("유저가 구입금액에 따른 로또 개수 계산을 확인한다")
	@ParameterizedTest
	@CsvSource(value = {"1000, 1", "50000, 50"})
	void verifyPurchaseAmountNotANumber(String value, int expected) {
		PurchaseAmount purchaseAmount = PurchaseAmount.from(value);
		int actual = PurchaseCount.from(purchaseAmount).toLotto();
		assertThat(actual).isEqualTo(expected);
	}
}
