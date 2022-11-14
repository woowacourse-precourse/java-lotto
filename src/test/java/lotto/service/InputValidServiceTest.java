package lotto.service;

import static org.assertj.core.api.Assertions.*;

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

	@DisplayName("보너스 번호 valid 오류 테스트 - 숫자가 아닌경우, 1~45 범위가 아닌 경우")
	@Test
	void validateBonusErrorTest() {
		assertThatThrownBy(() -> inputValidService.validateBonus("!@ ")).isInstanceOf(RuntimeException.class);
		assertThatThrownBy(() -> inputValidService.validateBonus("46")).isInstanceOf(RuntimeException.class);
		assertThatThrownBy(() -> inputValidService.validateBonus("-1")).isInstanceOf(RuntimeException.class);
	}

	@ParameterizedTest(name = "올바른 보너스 번호 테스트")
	@ValueSource(strings = {"1", "2", "3"})
	void validateBonusTest(String bonus) {
		Assertions.assertDoesNotThrow(() -> inputValidService.validateBonus(bonus));
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
