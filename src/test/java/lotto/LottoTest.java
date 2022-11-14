package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

	@DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
	@Test
	void createLottoByOverSize() {
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
	@Test
	void createLottoByDuplicatedNumber() {
		// TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
				.isInstanceOf(IllegalArgumentException.class);
	}

	// 아래에 추가 테스트 작성 가능
	@DisplayName("로또 구매 금액은 1000원이상 10만원 이하여야 한다.")
	@Test
	void betCheck() {
		Request request = new Request();

		request.setUserInputBettingMoney("999");
		assertThatThrownBy(() -> request.validateBettingMoney()).isInstanceOf(IllegalArgumentException.class);

		request.setUserInputBettingMoney("100001");
		assertThatThrownBy(() -> request.validateBettingMoney()).isInstanceOf(IllegalArgumentException.class);

		request.setUserInputBettingMoney("a");
		assertThatThrownBy(() -> request.validateBettingMoney()).isInstanceOf(IllegalArgumentException.class);

		request.setUserInputBettingMoney("asdfasdf");
		assertThatThrownBy(() -> request.validateBettingMoney()).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("당첨번호는 6자리이며 쉼표(',')로 구분지어 입력한다.")
	@Test
	void winningNumberPatternCheck() {
		Request request = new Request();

		request.setUserInputWinningNumbers("asdf");
		assertThatThrownBy(() -> request.validateWinningNumbers()).isInstanceOf(IllegalArgumentException.class);

		request.setUserInputBettingMoney("123456");
		assertThatThrownBy(() -> request.validateWinningNumbers()).isInstanceOf(IllegalArgumentException.class);

		request.setUserInputBettingMoney("4544433231");
		assertThatThrownBy(() -> request.validateWinningNumbers()).isInstanceOf(IllegalArgumentException.class);

		request.setUserInputBettingMoney("1,2,3,4,5,5");
		assertThatThrownBy(() -> request.validateWinningNumbers()).isInstanceOf(IllegalArgumentException.class);

		request.setUserInputBettingMoney("51,42,63,84,565,5");
		assertThatThrownBy(() -> request.validateWinningNumbers()).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("보너스 번호는 1에서 45 사이 숫자 중 1개이며 당첨번호와 중복될 수 없다.")
	@Test
	void bonusNumberPatternCheck() {
		Request request = new Request();

		request.setUserInputBonusNumber("asdf");
		assertThatThrownBy(() -> request.validateBonusNumber()).isInstanceOf(IllegalArgumentException.class);

		request.setUserInputBonusNumber("123456");
		assertThatThrownBy(() -> request.validateBonusNumber()).isInstanceOf(IllegalArgumentException.class);

		request.setUserInputBonusNumber("0");
		assertThatThrownBy(() -> request.validateBonusNumber()).isInstanceOf(IllegalArgumentException.class);

		request.setUserInputBonusNumber("1,2,3");
		assertThatThrownBy(() -> request.validateBonusNumber()).isInstanceOf(IllegalArgumentException.class);

		request.setUserInputBonusNumber("a");
		assertThatThrownBy(() -> request.validateBonusNumber()).isInstanceOf(IllegalArgumentException.class);

		request.setUserInputWinningNumbers("1,2,3,4,5,6");
		request.validateWinningNumbers();
		request.setUserInputBonusNumber("6");
		assertThatThrownBy(() -> request.validateBonusNumber()).isInstanceOf(IllegalArgumentException.class);
	}
}
