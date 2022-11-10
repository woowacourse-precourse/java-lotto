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

	@DisplayName("금액 입력 시 정수가 아니라면 예외 발생")
	@Test
	void notInteger() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			money.checkMoneyInput("1.5");
		});
	}

	@DisplayName("금액 입력 시 음수라면 예외 발생")
	@Test
	void notPositive() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			money.checkMoneyInput("-1");
		});
	}

	@DisplayName("금액 입력 시 1000원 단위가 아니라면 예외 발생")
	@Test
	void notUnitOfThousand() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			money.checkMoneyInput("1500");
		});
	}
}
