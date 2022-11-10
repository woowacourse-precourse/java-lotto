package lotto.mytest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.Money;

public class MoneyTest {
	Money money = new Money();

	@DisplayName("금액 입력 시 숫자가 아니라면 예외 발생")
	@Test
	void notNumber() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			money.checkMoneyInput("abc");
		});
	}
}
