package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import lotto.domain.Money;

public class MoneyTest {

	@DisplayName("로또 구입 금액이 0이면 예외가 발생한다")
	@Test
	void createMoneyByZero() {
		assertThatThrownBy(() -> new Money(0))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("로또 구입 금액이 1000원 단위가 아니면 예외가 발생한다")
	@Test
	void createMoneyByInDivisible() {

		assertThatThrownBy(() -> new Money(1500))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
