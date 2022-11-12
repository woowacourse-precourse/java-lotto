package utils;

import static org.assertj.core.api.Assertions.*;
import static utils.InputLottoPurchaseAmount.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class InputLottoPurchaseAmountTest {

	@Nested
	class FailTest {

		@Test
		@DisplayName("구입금액 예외사항 테스트: 숫자가 아닌 입력")
		void inputNonNumericLottoPurchaseAmount() {
			// given, when
			String lottoPurchaseAmountKorean = "1000ㄱ";
			String lottoPurchaseAmountEnglish = "1s000";
			String lottoPurchaseAmountSpecialCharacter = "~1000";
			String lottoPurchaseAmountMix = "1r0ㄴ0!0";

			// then
			assertThatThrownBy(() -> validateNumeric(lottoPurchaseAmountKorean))
					.isInstanceOf(IllegalArgumentException.class);
			assertThatThrownBy(() -> validateNumeric(lottoPurchaseAmountEnglish))
					.isInstanceOf(IllegalArgumentException.class);
			assertThatThrownBy(() -> validateNumeric(lottoPurchaseAmountSpecialCharacter))
					.isInstanceOf(IllegalArgumentException.class);
			assertThatThrownBy(() -> validateNumeric(lottoPurchaseAmountMix))
					.isInstanceOf(IllegalArgumentException.class);
		}
	}
}