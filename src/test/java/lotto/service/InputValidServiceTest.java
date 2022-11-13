package lotto.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidServiceTest {

	private InputValidService inputValidService;

	@BeforeEach
	void setUp() {
		inputValidService = new InputValidService();
	}

	// @ParameterizedTest(name = "로토 번호가 1~45 가 아닌 경우 테스트")
	// @ValueSource(strings = {"@#", })
	@DisplayName("보너스 번호 valid 오류 테스트")
	@Test
	void validateBonusTest() {
		Assertions.assertAll(
			() -> assertThatThrownBy(() -> inputValidService.validateBonus("!@ ")),
			() -> assertThatThrownBy(() -> inputValidService.validateBonus("46")),
			() -> assertThatThrownBy(() -> inputValidService.validateBonus("-1"))
		);
	}

	@Test
	void validAnswerTest() {
		Assertions.assertAll(
			() -> assertThatThrownBy(() -> inputValidService.validAnswer("1,2,3,4,5,6,7")),
			() -> assertThatThrownBy(() -> inputValidService.validAnswer("1,2,3,!,5,6")),
			() -> assertThatThrownBy(() -> inputValidService.validAnswer("1,2,3,4,5,100"))
		);
	}

	@Test
	void validateUserMoneyTest() {
		//given

		//when

		//then
	}
}
