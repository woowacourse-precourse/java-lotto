package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoStoreTest {
	@DisplayName("1000 단위 숫자를 제외한 값이 입력되면 예외가 발생한다.")
	@Nested
	class ValidateUnitTest {
		@Test
		void case1() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				LottoStore lottoStore = new LottoStore("500");
			});
			assertEquals(Error.UNIT.getMessage(), exception.getMessage());
		}

		@Test
		void case2() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				LottoStore lottoStore = new LottoStore("4030");
			});
			assertEquals(Error.UNIT.getMessage(), exception.getMessage());
		}

		@Test
		void case3() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				LottoStore lottoStore = new LottoStore("15001");
			});
			assertEquals(Error.UNIT.getMessage(), exception.getMessage());
		}

	}

	@DisplayName("1000 미만의 숫자가 입력되면 예외가 발생한다.")
	@Nested
	class ValidateZeroTest {
		@Test
		void case1() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				LottoStore lottoStore = new LottoStore("0000");
			});
			assertEquals(Error.ZERO.getMessage(), exception.getMessage());
		}

		@Test
		void case2() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				LottoStore lottoStore = new LottoStore("00000");
			});
			assertEquals(Error.ZERO.getMessage(), exception.getMessage());
		}

	}

	@DisplayName("입력값이 유효성 검사를 통과하면 getPurchaseAmount와 getNumberOfTickets로 다시 값을 확인할 수 있다.")
	@Nested
	class GetPurchaseAmountTest {
		@Test
		void case1() {
			String testPurchaseAmount = "3000";
			LottoStore lottoStore = new LottoStore(testPurchaseAmount);

			assertEquals(lottoStore.getPurchaseAmount(), Integer.parseInt(testPurchaseAmount));
			assertEquals(lottoStore.getNumberOfTickets(),
				(Integer.parseInt(testPurchaseAmount) / Number.UNIT.getValue()));
		}

		@Test
		void case2() {
			String testPurchaseAmount = "35000";
			LottoStore lottoStore = new LottoStore(testPurchaseAmount);

			assertEquals(lottoStore.getPurchaseAmount(), Integer.parseInt(testPurchaseAmount));
			assertEquals(lottoStore.getNumberOfTickets(),
				(Integer.parseInt(testPurchaseAmount) / Number.UNIT.getValue()));
		}

		@Test
		void case3() {
			String testPurchaseAmount = "357000";
			LottoStore lottoStore = new LottoStore(testPurchaseAmount);

			assertEquals(lottoStore.getPurchaseAmount(), Integer.parseInt(testPurchaseAmount));
			assertEquals(lottoStore.getNumberOfTickets(),
				(Integer.parseInt(testPurchaseAmount) / Number.UNIT.getValue()));
		}

	}
}
