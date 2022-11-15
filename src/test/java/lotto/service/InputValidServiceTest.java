package lotto.service;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidServiceTest {

	private InputValidService inputValidService;

	@BeforeEach
	void setUp() {
		inputValidService = new InputValidService();
	}

	@DisplayName("보너스 번호 valid 오류 테스트 - 숫자가 아닌경우")
	@Test
	void validateBonusErrorTestAboutNotNumber() {
		List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
		assertThatThrownBy(() -> inputValidService.validateBonus("!@ ", winningNumbers)).isInstanceOf(
			RuntimeException.class);
		assertThatThrownBy(() -> inputValidService.validateBonus("46", winningNumbers)).isInstanceOf(
			RuntimeException.class);
		assertThatThrownBy(() -> inputValidService.validateBonus(" ", winningNumbers)).isInstanceOf(
			RuntimeException.class);
	}

	@DisplayName("보너스 번호 valid 오류 테스트 - 1~45 범위가 아닌 경우")
	@Test
	void validateBonusErrorTestAboutNotInRange() {
		List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
		assertThatThrownBy(() -> inputValidService.validateBonus("46", winningNumbers)).isInstanceOf(
			RuntimeException.class);
		assertThatThrownBy(() -> inputValidService.validateBonus("0", winningNumbers)).isInstanceOf(
			RuntimeException.class);
		assertThatThrownBy(() -> inputValidService.validateBonus("-1", winningNumbers)).isInstanceOf(
			RuntimeException.class);
	}

	@ParameterizedTest(name = "보너스 번호 valid 오류 테스트 - 당첨번호와 중복이 된겅우")
	@ValueSource(strings = {"1", "2", "3", "4", "5", "6"})
	void validateBonusErrorTestAboutDuplicate(String bonus) {
		List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
		assertThatThrownBy(() -> inputValidService.validateBonus(bonus, winningNumbers)).isInstanceOf(
			RuntimeException.class);
	}

	@ParameterizedTest(name = "올바른 보너스 번호 테스트")
	@ValueSource(strings = {"1", "2", "3"})
	void validateBonusTest(String bonus) {
		List<Integer> winningNumbers = List.of(4, 5, 6, 7, 8, 9);
		Assertions.assertDoesNotThrow(() -> inputValidService.validateBonus(bonus, winningNumbers));
	}

	@DisplayName("당첨 번호 valid 오류 테스트 - 숫자가 아닌 경우, 1~45 범위가 아닌 경우, 6개의 숫자를 입력하지 않은경우")
	@Test
	void validAnswerErrorTest() {
		assertThatThrownBy(() -> inputValidService.validWinningNumber("1,2,3,4,5,6,7")).isInstanceOf(
			RuntimeException.class);
		assertThatThrownBy(() -> inputValidService.validWinningNumber("1,2,3,!,5,6")).isInstanceOf(
			RuntimeException.class);
		assertThatThrownBy(() -> inputValidService.validWinningNumber("1,2,3,4,5,100")).isInstanceOf(
			RuntimeException.class);
	}

	@ParameterizedTest(name = "올바른 당첨 번호 테스트")
	@ValueSource(strings = {"1,2,3,4,5,6", "1,2,3,4,5,45"})
	void validAnswerTest(String answer) {
		Assertions.assertDoesNotThrow(() -> inputValidService.validWinningNumber(answer));
	}

	@DisplayName("사용자가 입력한 돈 valid 테스트 - 1000으로 나눠지는지, 숫자인지 확인하는 테스트")
	@Test
	void validateUserMoneyErrorTest() {
		assertThatThrownBy(() -> inputValidService.validateUserMoney("6!!")).isInstanceOf(RuntimeException.class);
		assertThatThrownBy(() -> inputValidService.validateUserMoney("412312")).isInstanceOf(RuntimeException.class);
	}

	@ParameterizedTest(name = "올바른 사용자 지불 금액 테스트")
	@ValueSource(strings = {"1231231000", "1000"})
	void validateUserMoneyTest(String userMoneyPrice) {
		Assertions.assertDoesNotThrow(() -> inputValidService.validateUserMoney(userMoneyPrice));
	}
}
