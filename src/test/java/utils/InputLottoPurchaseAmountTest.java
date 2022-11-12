package utils;

import static org.assertj.core.api.Assertions.*;
import static utils.InputLottoPurchaseAmount.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class InputLottoPurchaseAmountTest {

	@Nested
	class FailTest {

		@Test
		@DisplayName("구입금액 예외사항 테스트: 숫자가 아닌 입력")
		void inputNonNumericLottoPurchaseAmount() {
			// given, when: 한글이 섞인 입력
			List<String> lottoPurchaseAmounts = List.of("1000ㄱ", "1s000", "~1000", "1r0ㄴ0!0");

			for (String lottoPurchaseAmount : lottoPurchaseAmounts) {
				readLine(lottoPurchaseAmount);
				assertThatThrownBy(() -> readLottoPurchaseAmount()).isInstanceOf(IllegalArgumentException.class);
			}
		}

		private void readLine(String lottoPurchaseAmount) {
			InputStream in = new ByteArrayInputStream(lottoPurchaseAmount.getBytes());
			System.setIn(in);
		}

		@Test
		@DisplayName("구입금액 예외사항 테스트: 1000원 미만 입력")
		void inputOutOfRangeLottoPurchaseAmount() {
			// given, when
			List<String> lottoPurchaseAmounts = List.of("999", "0", "-1");

			// then
			for (String lottoPurchaseAmount : lottoPurchaseAmounts) {
				readLine(lottoPurchaseAmount);
				assertThatThrownBy(() -> readLottoPurchaseAmount()).isInstanceOf(IllegalArgumentException.class);
			}
		}

		@Test
		@DisplayName("구입금액 예외사항 테스트: 1000원 단위 아닌 입력")
		void inputInvalidUnitLottoPurchaseAmount() {
			// given, when
			List<String> lottoPurchaseAmounts = List.of("1001", "1000000270", "1234");

			// then
			for (String lottoPurchaseAmount : lottoPurchaseAmounts) {
				readLine(lottoPurchaseAmount);
				assertThatThrownBy(() -> readLottoPurchaseAmount()).isInstanceOf(IllegalArgumentException.class);
			}
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

		@Test
		@DisplayName("구입금액 최소금액 유효성 검증 성공 테스트: 1000원 이상 입력")
		void inputInRangeLottoPurchaseAmount() {
			// given, when
			int lottoPurchaseAmountOne = 1000;
			int lottoPurchaseAmountTwo = 124011;

			// then
			assertThatNoException().isThrownBy(() -> validatePurchaseAmountRange(lottoPurchaseAmountOne));
			assertThatNoException().isThrownBy(() -> validatePurchaseAmountRange(lottoPurchaseAmountTwo));

		}

		@Test
		@DisplayName("구입금액 천원 단위 유효성 검증 성공 테스트: 1000원 단위 입력")
		void inputValidatePurchaseAmountUnit() {
			// given, when
			int lottoPurchaseAmountOne = 1000;
			int lottoPurchaseAmountTwo = 5000000;

			// then
			assertThatNoException().isThrownBy(() -> validatePurchaseAmountRange(lottoPurchaseAmountOne));
			assertThatNoException().isThrownBy(() -> validatePurchaseAmountRange(lottoPurchaseAmountTwo));
		}
	}
}