package lotto.domain.lotterystore;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ErrorCheckerTest {
	@DisplayName("구매자의 로또 구입금액이 숫자가 아니라면 예외가 발생한다.") @Test void 구매입력값이숫자가아닌경우() {
		assertThatThrownBy(() -> new ErrorChecker().validateMoneyFromBuyer("#!@#")).isInstanceOf(
			IllegalArgumentException.class);
		assertThatThrownBy(() -> new ErrorChecker().validateMoneyFromBuyer(" ")).isInstanceOf(
			IllegalArgumentException.class);
		assertThatThrownBy(() -> new ErrorChecker().validateMoneyFromBuyer("	")).isInstanceOf(
			IllegalArgumentException.class);
	}

	@DisplayName("구매자의 로또 구입금액이 음수라면 예외가 발생한다.") @Test void 구매입력값이음수인경우() {
		assertThatThrownBy(() -> new ErrorChecker().validateMoneyFromBuyer("-39")).isInstanceOf(
			IllegalArgumentException.class);
	}

	@DisplayName("구매자의 로또 구입금액이 천원단위가 아니라면 예외가 발생한다.") @Test void 구매입력값이천원단위가아닌경우() {
		assertThatThrownBy(() -> new ErrorChecker().validateMoneyFromBuyer("14879")).isInstanceOf(
			IllegalArgumentException.class);
	}


	@DisplayName("당첨번호가 콤마로 안되어 있는 경우") @Test void 당첨번호양식이안맞는경우1() {
		assertThatThrownBy(() -> new ErrorChecker().validateWinningNumbers("123456")).isInstanceOf(
			IllegalArgumentException.class);
		assertThatThrownBy(() -> new ErrorChecker().validateWinningNumbers("      ")).isInstanceOf(
			IllegalArgumentException.class);
		assertThatThrownBy(() -> new ErrorChecker().validateWinningNumbers("1,2,3,,,")).isInstanceOf(
			IllegalArgumentException.class);
		assertThatThrownBy(() -> new ErrorChecker().validateWinningNumbers("1,2,3")).isInstanceOf(
			IllegalArgumentException.class);
	}

	@DisplayName("당첨번호에 숫자가 아닌 글자가 들어간 경우") @Test void 당첨번호양식이안맞는경우2() {
		assertThatThrownBy(() -> new ErrorChecker().validateWinningNumbers("1,$,3,4,5,6")).isInstanceOf(
			IllegalArgumentException.class);
		assertThatThrownBy(() -> new ErrorChecker().validateWinningNumbers("1,$,3, ,5,6")).isInstanceOf(
			IllegalArgumentException.class);
	}

	@DisplayName("당첨번호에 음수가 들어간 경우") @Test void 당첨번호양식이안맞는경우3() {
		assertThatThrownBy(() -> new ErrorChecker().validateWinningNumbers("1,2,3,-4,5,6")).isInstanceOf(
			IllegalArgumentException.class);
	}

	@DisplayName("당첨번호에 범위가 아닌 수가 있는 경우") @Test void 당첨번호양식이안맞는경우4() {
		assertThatThrownBy(() -> new ErrorChecker().validateWinningNumbers("1,2,4353,4,5,6")).isInstanceOf(
			IllegalArgumentException.class);
	}

	@DisplayName("당첨번호에 중복된 수가 있는 경우") @Test void 당첨번호양식이안맞는경우5() {
		assertThatThrownBy(() -> new ErrorChecker().validateWinningNumbers("1,1,2,3,4,5")).isInstanceOf(
			IllegalArgumentException.class);
		assertThatThrownBy(() -> new ErrorChecker().validateWinningNumbers("1,2,2,2,4,5")).isInstanceOf(
			IllegalArgumentException.class);
	}

}
