package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class WinConfirmationTest {
	private WinConfirmation confirmation;
	private static final List<Integer> LOTTERY = Arrays.asList(1, 2, 3, 4, 5, 6);

	@BeforeAll
	void setUp() {
		confirmation = new WinConfirmation();
	}

	@Test
	void 일치개수6개() {
		int result = confirmation.correctCount(LOTTERY, Arrays.asList(1, 2, 3, 4, 5, 6));
		assertThat(result).isEqualTo(6);
	}

	@Test
	void 일치개수3개() {
		int result = confirmation.correctCount(LOTTERY, Arrays.asList(7, 8, 9, 4, 5, 6));
		assertThat(result).isEqualTo(3);
	}

	@Test
	void 일치개수4개() {
		int result = confirmation.correctCount(LOTTERY, Arrays.asList(1, 2, 3, 4, 5, 6));
		assertThat(result).isEqualTo(6);
	}

}
