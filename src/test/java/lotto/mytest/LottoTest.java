package lotto.mytest;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.service.Lotto;

public class LottoTest {
	@DisplayName("로또 번호의 개수가 6개가 아닌 경우 예외가 발생")
	@Test
	void notSixNumbers() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Lotto(List.of(1, 2, 3, 4, 5));
		});
	}

	@DisplayName("중복된 로또 번호가 있는 경우 예외가 발생")
	@Test
	void duplicatedNumbers() {
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
