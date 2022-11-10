package lotto.domain.lotterystore;

import lotto.domain.lottery.lotterystore.ErrorChecker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ErrorCheckerTest {
	@DisplayName("구매자의 로또 구입금액이 숫자가 아니라면 예외가 발생한다.") @Test void 구매입력값이숫자가아닌경우() {
		assertThatThrownBy(() -> new ErrorChecker().isValidMoneyFromBuyer("#!@#")).isInstanceOf(
			IllegalArgumentException.class);
		assertThatThrownBy(() -> new ErrorChecker().isValidMoneyFromBuyer("    ")).isInstanceOf(
			IllegalArgumentException.class);
		assertThatThrownBy(() -> new ErrorChecker().isValidMoneyFromBuyer("	")).isInstanceOf(
			IllegalArgumentException.class);
	}

	@DisplayName("구매자의 로또 구입금액이 음수라면 예외가 발생한다.") @Test void 구매입력값이음수인경우() {
		assertThatThrownBy(() -> new ErrorChecker().isValidMoneyFromBuyer("-39")).isInstanceOf(
			IllegalArgumentException.class);
	}

	@DisplayName("구매자의 로또 구입금액이 천원단위가 아니라면 예외가 발생한다.") @Test void 구매입력값이천원단위가아닌경우() {
		assertThatThrownBy(() -> new ErrorChecker().isValidMoneyFromBuyer("14879")).isInstanceOf(
			IllegalArgumentException.class);
	}
}
