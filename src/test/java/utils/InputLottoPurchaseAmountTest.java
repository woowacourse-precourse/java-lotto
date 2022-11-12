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

		@Test
		@DisplayName("구입금액 예외사항 테스트: 1000원 미만 입력")
		void inputOutOfRangeLottoPurchaseAmount() {
			// given, when
			int lottoPurchaseAmountOne = 999;
			int lottoPurchaseAmountTwo = 0;
			int lottoPurchaseAmountThree = -1;

			// then
			assertThatThrownBy(() -> validatePurchaseAmountRange(lottoPurchaseAmountOne))
					.isInstanceOf(IllegalArgumentException.class);
			assertThatThrownBy(() -> validatePurchaseAmountRange(lottoPurchaseAmountTwo))
					.isInstanceOf(IllegalArgumentException.class);
			assertThatThrownBy(() -> validatePurchaseAmountRange(lottoPurchaseAmountThree))
					.isInstanceOf(IllegalArgumentException.class);
		}
	}

	@Nested
	class SuccessTest {
		@Test
		@DisplayName("구입금액 숫자 유효성 검증 성공 테스트: 숫자만 입력")
		void inputNumericLottoPurchaseAmount() {
			// given, when
			String lottoPurchaseAmountOne = "1000";
			String lottoPurchaseAmountTwo = "1234";
			String lottoPurchaseAmountThree = "100000";

			// then
			assertThatNoException().isThrownBy(() -> validateNumeric(lottoPurchaseAmountOne));
			assertThatNoException().isThrownBy(() -> validateNumeric(lottoPurchaseAmountTwo));
			assertThatNoException().isThrownBy(() -> validateNumeric(lottoPurchaseAmountThree));
		}
	}
}