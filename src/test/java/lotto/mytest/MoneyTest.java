package lotto.mytest;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.Money;

public class MoneyTest {

	@DisplayName("금액 입력 예외처리 모음")
	@ParameterizedTest
	@ValueSource(strings = {"abc", "1.5", "-1", "1q2w3e4r", " ", "-", "!@#"})
	void exceptionTest(String money) {
		assertThatThrownBy(() -> {
			Money.checkMoneyInput(money);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("금액 입력 시 1000원 단위가 아니라면 예외 발생")
	@Test
	void notUnitOfThousand() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Money.checkMoneyInput("1500");
		});
	}
}
