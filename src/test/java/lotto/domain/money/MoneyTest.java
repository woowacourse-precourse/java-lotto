package lotto.domain.money;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

	private Money money;

	@BeforeEach
	void setUp() {
		money = new Money("1000");
	}

	@DisplayName("로또 구매 가능 개수 구하기")
	@Test
	void 로또_구매가능_개수() {
		assertEquals(1, money.getLottoPurchaseCount());
	}

	@DisplayName("구매금액 0원일때 예외 발생 시키기")
	@Test
	void 구매금액은_0보다_커야합니다() {
		assertThatThrownBy(() -> new Money("0"))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("사용자가 입력한 구매금액이 로또 구매금액에 딱 안맞게 떨어질 때 예외 테스트")
	@Test
	void isRemainderZero() {
		assertThatThrownBy(() -> new Money("1200"))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("구매금액이 숫자가 아닐때 예외 테스트")
	@Test
	void isNumber() {
		assertThatThrownBy(() -> new Money("a"))
				.isInstanceOf(IllegalArgumentException.class);
	}
}