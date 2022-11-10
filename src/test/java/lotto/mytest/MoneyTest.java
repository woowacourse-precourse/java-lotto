package lotto.mytest;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.Money;

public class MoneyTest {
	@DisplayName("금액 입력 예외처리 모음")
	@ParameterizedTest
	@ValueSource(strings = {"abc", "1.5", "-1", "1q2w3e4r", " ", "-", "!@#", ""})
	void notRightNumber(String money) {
		assertThatThrownBy(() -> {
			Money.checkMoneyInput(money);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("금액 입력 시 1000원 단위가 아니라면 예외 발생")
	@ParameterizedTest
	@ValueSource(strings = {"1500", "12345", "500", "77700"})
	void notUnitOfThousand(String money) {
		assertThatThrownBy(() -> {
			Money.checkMoneyInput(money);
		}).isInstanceOf(IllegalArgumentException.class);
	}
}
