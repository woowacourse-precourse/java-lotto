package lotto.domain.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PayTest {

	@Test
	void 제대로_작동() {
		Pay pay = new Pay("123000");
		long answer = 123000;

		assertEquals(answer, pay.getPay());
	}

	@Test
	void 예외처리_문자() {
		assertThatThrownBy(() -> new Pay("a"))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 예외처리_문자2() {
		assertThatThrownBy(() -> new Pay("1000a"))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 예외처리_문자3() {
		assertThatThrownBy(() -> new Pay("12a1000"))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 예외처리_공백() {
		assertThatThrownBy(() -> new Pay(""))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 예외처리_가격() {
		assertThatThrownBy(() -> new Pay("1200"))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 예외처리_가격2() {
		assertThatThrownBy(() -> new Pay("1500"))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 예외처리_가격_음수() {
		assertThatThrownBy(() -> new Pay("-1000"))
				.isInstanceOf(IllegalArgumentException.class);
	}
}