package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

	@DisplayName("1~45사이의 자연수를 제외한 값이 입력되면 예외가 발생한다.")
	@Nested
	class ValidateREGEXTest {
		@Test
		void case1() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				WinningNumbers winningNumbers = new WinningNumbers("a,b,c,d,e,f", "1");
			});
			assertEquals(Error.NUMBER.getMessage(), exception.getMessage());
		}

		@Test
		void case2() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6", "0");
			});
			assertEquals(Error.NUMBER.getMessage(), exception.getMessage());
		}

		@Test
		void case3() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6", "46");
			});
			assertEquals(Error.NUMBER.getMessage(), exception.getMessage());
		}

		@Test
		void case4() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6", "a");
			});
			assertEquals(Error.NUMBER.getMessage(), exception.getMessage());
		}

		@Test
		void case5() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,46", "7");
			});
			assertEquals(Error.NUMBER.getMessage(), exception.getMessage());
		}

		@Test
		void case6() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				WinningNumbers winningNumbers = new WinningNumbers("10,20,30,40,41,42", "57");
			});
			assertEquals(Error.NUMBER.getMessage(), exception.getMessage());
		}
	}

	@DisplayName("보너스 번호는 당첨 번호와 중복되면 예외가 발생한다.")
	@Nested
	class ValidateBonusTest {
		@Test
		void case1() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6", "1");
			});
			assertEquals(Error.BONUS.getMessage(), exception.getMessage());
		}

		@Test
		void case2() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6", "2");
			});
			assertEquals(Error.BONUS.getMessage(), exception.getMessage());
		}

		@Test
		void case3() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6", "3");
			});
			assertEquals(Error.BONUS.getMessage(), exception.getMessage());
		}

		@Test
		void case4() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6", "4");
			});
			assertEquals(Error.BONUS.getMessage(), exception.getMessage());
		}

		@Test
		void case5() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6", "5");
			});
			assertEquals(Error.BONUS.getMessage(), exception.getMessage());
		}

		@Test
		void case6() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6", "6");
			});
			assertEquals(Error.BONUS.getMessage(), exception.getMessage());
		}
	}

	@DisplayName("입력값이 유효성 검사를 통과하면 getWinningNumbers와 getBonusNumbers로 다시 값을 확인할 수 있다.")
	@Nested
	class GetWinningNumbersTest {
		@Test
		void case1() {
			String testNumbers = "1,2,3,4,5,6";
			String testBonusNumber = "7";
			WinningNumbers winningNumbers = new WinningNumbers(testNumbers, testBonusNumber);

			assertEquals(winningNumbers.getWinningNumbers(), List.of(1, 2, 3, 4, 5, 6));
			assertEquals(winningNumbers.getBonusNumbers(), Integer.parseInt(testBonusNumber));
		}

		@Test
		void case2() {
			String testNumbers = "35,36,37,38,39,40";
			String testBonusNumber = "30";
			WinningNumbers winningNumbers = new WinningNumbers(testNumbers, testBonusNumber);

			assertEquals(winningNumbers.getWinningNumbers(), List.of(35, 36, 37, 38, 39, 40));
			assertEquals(winningNumbers.getBonusNumbers(), Integer.parseInt(testBonusNumber));
		}

		@Test
		void case3() {
			String testNumbers = "40,41,42,43,44,45";
			String testBonusNumber = "20";
			WinningNumbers winningNumbers = new WinningNumbers(testNumbers, testBonusNumber);

			assertEquals(winningNumbers.getWinningNumbers(), List.of(40, 41, 42, 43, 44, 45));
			assertEquals(winningNumbers.getBonusNumbers(), Integer.parseInt(testBonusNumber));
		}

	}

}
