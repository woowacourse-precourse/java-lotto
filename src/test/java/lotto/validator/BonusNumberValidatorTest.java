package lotto.validator;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberValidatorTest {
	@SuppressWarnings("checkstyle:WhitespaceAfter")
	@DisplayName("보너스번호와 당첨번호 중복여부 확인")
	@Test
	void runBonusNumberValidator() {
		//	given
		BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();

		//when
		Integer expectedMoney = 7;

		//	then
		// 보너스번호와 당첨번호의 중복
		/*assertThatThrownBy(() -> bonusNumberValidator.runBonusNumberValidator("6", List.of(1, 2, 3, 4, 5, 6)))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(NOT_DUPLICATED.getErrorMessage());*/

		// 중복되지않은 올바른 보너스번호
		assertThat(bonusNumberValidator.runBonusNumberValidator(7, List.of(1, 2, 3, 4, 5, 6))).isEqualTo(
			expectedMoney);
	}
}
