package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CashTest {
	@DisplayName("구입 금액 테스트")
	@Test
	void 정상_케이스_테스트(){
		assertThatCode(() -> new Cash(140000L))
				.doesNotThrowAnyException();
	}

	@Test
	void 예외_케이스_음수_테스트(){
		assertThatThrownBy(() -> new Cash(-1L))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 예외_케이스_1_단위_테스트(){
		assertThatThrownBy(() -> new Cash(1234L))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 예외_케이스_10_단위_테스트(){
		assertThatThrownBy(() -> new Cash(1230L))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 예외_케이스_100_단위_테스트(){
		assertThatThrownBy(() -> new Cash(1200L))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("남은 금액이 1000 보다 작을 경우 복권을 구매할 수 없어야 한다.")
	@Test
	void 구입_함수_테스트(){
		Cash cash = new Cash(1000L);
		cash.withdraw();
		assertThat(cash.canBuy()).isFalse();
	}
}