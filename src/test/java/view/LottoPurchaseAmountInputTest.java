package view;

import static org.assertj.core.api.Assertions.*;
import static view.LottoPurchaseAmountInput.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class LottoPurchaseAmountInputTest {
	
	LottoPurchaseAmountInput inputLottoPurchaseAmount = new LottoPurchaseAmountInput();
	
	@Nested
	class FailTest {

		@Test
		@DisplayName("구입금액 예외사항 테스트: 숫자가 아닌 입력")
		void inputNonNumericLottoPurchaseAmount() {
			// given, when: 한글이 섞인 입력
			List<String> lottoPurchaseAmounts = List.of("1000ㄱ", "1s000", "~1000", "1r0ㄴ0!0");

			for (String lottoPurchaseAmount : lottoPurchaseAmounts) {
				readLine(lottoPurchaseAmount);
				assertThatThrownBy(() -> inputLottoPurchaseAmount.readLottoPurchaseAmount()).isInstanceOf(IllegalArgumentException.class);
			}
		}

		@Test
		@DisplayName("구입금액 예외사항 테스트: 1,000원 미만 입력")
		void inputLessThanMinimumPurchaseAmount() {
			// given, when
			List<String> lottoPurchaseAmounts = List.of("999", "0", "-1");

			// then
			for (String lottoPurchaseAmount : lottoPurchaseAmounts) {
				readLine(lottoPurchaseAmount);
				assertThatThrownBy(() -> inputLottoPurchaseAmount.readLottoPurchaseAmount()).isInstanceOf(IllegalArgumentException.class);
			}
		}

		@Test
		@DisplayName("구입금액 예외사항 테스트: 8,145,060,000원 초과 입력")
		void inputMoreThanMaximumPurchaseAmount() {
			// given, when
			List<String> lottoPurchaseAmounts = List.of("8145061000", "743210100000");

			// then
			for (String lottoPurchaseAmount : lottoPurchaseAmounts) {
				readLine(lottoPurchaseAmount);
				assertThatThrownBy(() -> inputLottoPurchaseAmount.readLottoPurchaseAmount()).isInstanceOf(IllegalArgumentException.class);
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
				assertThatThrownBy(() -> inputLottoPurchaseAmount.readLottoPurchaseAmount()).isInstanceOf(IllegalArgumentException.class);
			}
		}
	}

	@Nested
	class SuccessTest {

		@Test
		@DisplayName("구입금액 유효성 검증 성공 테스트")
		void inputNumericLottoPurchaseAmount() {
			// given
			List<String> lottoPurchaseAmounts = List.of("1000", "22000", "54835000", "8145060000");
			List<Long> expectedLottoPurchaseAmounts = List.of(1000L, 22000L, 54835000L, 8145060000L);

			for (int idx = 0; idx < lottoPurchaseAmounts.size(); idx++) {

				String lottoPurchaseAmount = lottoPurchaseAmounts.get(idx);

				// when
				long expectedLottoPurchaseAmount = expectedLottoPurchaseAmounts.get(idx);
				readLine(lottoPurchaseAmount);
				long result = inputLottoPurchaseAmount.readLottoPurchaseAmount();

				// then
				assertThat(result).isEqualTo(expectedLottoPurchaseAmount);
			}
		}
	}

	private void readLine(String lottoPurchaseAmount) {
		InputStream in = new ByteArrayInputStream(lottoPurchaseAmount.getBytes());
		System.setIn(in);
	}
}