package lotto.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserServiceTest {

	private final UserService userService = new UserService();

	@Test
	@DisplayName("올바르지 못한 금액 입려시 예외 발생")
	void getLottoQuantityTest() {
		Integer lottoQuantity = userService.getLottoQuantity(1000L);

		assertThat(lottoQuantity).isEqualTo(1);
		assertThatThrownBy(() -> userService.getLottoQuantity(-1000L))
			.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> userService.getLottoQuantity(1200L))
			.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> userService.getLottoQuantity(0L))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
