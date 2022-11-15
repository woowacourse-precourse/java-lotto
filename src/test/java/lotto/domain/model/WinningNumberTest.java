package lotto.domain.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumberTest {

	@Test
	void 정상작동() {
		WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");
		List<Integer> answer = Arrays.asList(1, 2, 3, 4, 5, 6);

		assertEquals(answer, winningNumber.getWinningNumbers());
	}

	@Test
	void 예외처리_1미만() {
		assertThatThrownBy(() -> new WinningNumber("1,0,3,4,5,6"))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 예외처리_45초과() {
		assertThatThrownBy(() -> new WinningNumber("1,46,3,4,5,6"))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 예외처리_잘못된_문자() {
		assertThatThrownBy(() -> new WinningNumber("1,a,3,4,5,6"))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 예외처리_갯수() {
		assertThatThrownBy(() -> new WinningNumber("1,3,4,5,6"))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 예외처리_쉼표() {
		assertThatThrownBy(() -> new WinningNumber("1,46,,4,5,6,7"))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 예외처리_공백() {
		assertThatThrownBy(() -> new WinningNumber(""))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 예외처리_스페이스() {
		assertThatThrownBy(() -> new WinningNumber("1 3 43,4,5,6"))
				.isInstanceOf(IllegalArgumentException.class);
	}
}