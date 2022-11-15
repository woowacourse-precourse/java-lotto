package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("WinningNumber 클래스")
class WinningNumbersTest {
	@Nested
	@DisplayName("validateWinningNumbersFormat 메소드는")
	class Describe_validateWinningNumbersFormat {
		@Nested
		@DisplayName("만약 당첨번호를 6개 미만 입력한다면")
		class Context_winning_numbers_size_less_than_six {
			private final String inputWinnerNumber = "45,23,44,33,42";

			@Test
			@DisplayName("예외가 발생한다.")
			void it_returns_illegal_argument_exception() {
				assertThatThrownBy(() -> new WinningNumbers(inputWinnerNumber))
					.isInstanceOf(IllegalArgumentException.class);
			}
		}

		@Nested
		@DisplayName("만약 당첨번호를 6개 초과 입력한다면")
		class Context_winning_numbers_size_exceed_six {
			private final String inputWinnerNumber = "45,23,44,33,42,1,2";

			@Test
			@DisplayName("예외가 발생한다.")
			void it_returns_illegal_argument_exception() {
				assertThatThrownBy(() -> new WinningNumbers(inputWinnerNumber))
					.isInstanceOf(IllegalArgumentException.class);
			}
		}

		@Nested
		@DisplayName("만약 당첨번호 구분을 쉽표가 아닌 다른 문자로 한다면")
		class Context_winning_numbers_classification_other_character {
			String inputWinnerNumber = "45,23,44,33,42.31";

			@Test
			@DisplayName("예외가 발생한다.")
			void it_returns_illegal_argument_exception() {
				assertThatThrownBy(() -> new WinningNumbers(inputWinnerNumber))
					.isInstanceOf(IllegalArgumentException.class);
			}
		}

		@Nested
		@DisplayName("만약 마지막 당첨번호 뒤에 쉽표를 붙인다면")
		class Context_comma_after_last_winning_number_ {
			private final String inputWinnerNumber = "45,23,44,33,42,31,";

			@Test
			@DisplayName("예외가 발생한다.")
			void it_returns_illegal_argument_exception() {
				assertThatThrownBy(() -> new WinningNumbers(inputWinnerNumber))
					.isInstanceOf(IllegalArgumentException.class);
			}
		}

		@Nested
		@DisplayName("만약 쉼표 앞이나 뒤에 공백이 들어간다면")
		class Context_blank_before_or_after_comma {
			private final String inputWinnerNumber = "45, 23, 44, 33, 42, 31";

			@Test
			@DisplayName("예외가 발생한다.")
			void it_returns_illegal_argument_exception() {
				assertThatThrownBy(() -> new WinningNumbers(inputWinnerNumber))
					.isInstanceOf(IllegalArgumentException.class);
			}
		}

		@Nested
		@DisplayName("만약 당첨번호중 숫자가 아니라면")
		class Context_not_number_in_winning_numbers {
			private final String inputWinnerNumber = "45,23,44,33,a4,12";

			@Test
			@DisplayName("예외가 발생한다.")
			void it_returns_illegal_argument_exception() {
				assertThatThrownBy(() -> new WinningNumbers(inputWinnerNumber))
					.isInstanceOf(IllegalArgumentException.class);
			}
		}
	}

	@Nested
	@DisplayName("validateWinningNumberBoundary 메소드는")
	class Describe_validateWinningNumberBoundary {
		@Nested
		@DisplayName("만약 당첨번호중 제한범위의 최대값(45)을 벗어난다면")
		class Context_Winning_number_over_max_number {
			private final String inputWinnerNumber = "45,23,44,33,46,12";

			@Test
			@DisplayName("예외가 발생한다.")
			void it_returns_illegal_argument_exception() {
				assertThatThrownBy(() -> new WinningNumbers(inputWinnerNumber))
					.isInstanceOf(IllegalArgumentException.class);
			}
		}

		@Nested
		@DisplayName("만약 당첨번호중 두자리 숫자이며 첫번째 자리가 0이라면")
		class Context_double_digit_winning_number_first_digit_zero {
			private final String inputWinnerNumber = "45,23,44,33,06,12";

			@Test
			@DisplayName("예외가 발생한다.")
			void it_returns_illegal_argument_exception() {
				assertThatThrownBy(() -> new WinningNumbers(inputWinnerNumber))
					.isInstanceOf(IllegalArgumentException.class);
			}
		}
	}

	@Nested
	@DisplayName("validateWinningNumbersOverlap 메소드는")
	class Describe_validateWinningNumbersOverlap {
		@Nested
		@DisplayName("만약 당첨번호중 중복이 있다면")
		class Context_Winning_numbers_has_overlap_number {
			private final String inputWinnerNumber = "1,2,3,4,5,1";

			@Test
			@DisplayName("예외가 발생한다.")
			void it_returns_illegal_argument_exception() {
				assertThatThrownBy(() -> new WinningNumbers(inputWinnerNumber))
					.isInstanceOf(IllegalArgumentException.class);
			}
		}
	}
}
