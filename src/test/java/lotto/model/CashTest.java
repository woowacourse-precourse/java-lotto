package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

class CashTest {
	@DisplayName("구입 금액 테스트")
	@Test
	void 정상_케이스_테스트(){
		assertThatCode(() -> new Cash(140000L))
				.doesNotThrowAnyException();
	}

	@Test
	void 예외_케이스_음수_테스트(){
		Assertions.assertThatThrownBy(() -> new Cash(-1L))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 예외_케이스_1_단위_테스트(){
		Assertions.assertThatThrownBy(() -> new Cash(1234L))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 예외_케이스_10_단위_테스트(){
		Assertions.assertThatThrownBy(() -> new Cash(1230L))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 예외_케이스_100_단위_테스트(){
		Assertions.assertThatThrownBy(() -> new Cash(1200L))
				.isInstanceOf(IllegalArgumentException.class);
	}
}