package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.User;
import lotto.utils.Notice;

public class userTest {
	@DisplayName("돈이 1000원 단위로 떨어지지 않을 경우 예외가 발생한다.")
	@Test
	void createMoney() {
		assertThatThrownBy(() -> new User(14500))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(Notice.ERROR.getNoticeMessage());
	}

	@DisplayName("돈이 1000원 미만일 경우 예외가 발생한다.")
	@Test
	void createMoneyBelowSellingPrice() {
		assertThatThrownBy(() -> new User(200))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(Notice.ERROR.getNoticeMessage());
	}

	@DisplayName("0원일 경우")
	@Test
	void isZero() {
		assertThatThrownBy(() -> new User(0))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(Notice.ERROR.getNoticeMessage());
	}
}
