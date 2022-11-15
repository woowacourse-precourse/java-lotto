package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("BonusNumber 클래스")
class BonusNumberTest {
	private final List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

	@Nested
	@DisplayName("validateInputLetter 메소드는")
	class Describe_validateInputLetter {

		@Nested
		@DisplayName("만약 보너스 번호에 알파벳이 포함되어 있다면")
		class Context_bonus_number_includes_alphabet {
			private final String inputBonusNumber = "45a";

			@Test
			@DisplayName("예외를 발생시킨다.")
			void it_returns_illegal_argument_exception() {
				assertThatThrownBy(() -> new BonusNumber(inputBonusNumber, winningNumbers))
					.isInstanceOf(IllegalArgumentException.class);
			}
		}

		@Nested
		@DisplayName("만약 보너스 번호에 공백이 포함되어 있다면")
		class Context_bonus_number_includes_blank {
			private final String inputBonusNumber = " 45";

			@Test
			@DisplayName("예외를 발생시킨다.")
			void it_returns_illegal_argument_exception() {
				assertThatThrownBy(() -> new BonusNumber(inputBonusNumber, winningNumbers))
					.isInstanceOf(IllegalArgumentException.class);
			}
		}
	}

	@Nested
	@DisplayName("validateNumberBoundary 메소드는")
	class Describe_validateNumberBoundary {

		@Nested
		@DisplayName("만약 보너스 번호가 제한된 범위의 최대값(45)보다 크다면")
		class Context_bonus_number_bigger_than_max_number {
			private final String inputBonusNumber = "47";

			@Test
			@DisplayName("예외를 발생시킨다.")
			void it_returns_illegal_argument_exception() {
				assertThatThrownBy(() -> new BonusNumber(inputBonusNumber, winningNumbers))
					.isInstanceOf(IllegalArgumentException.class);
			}
		}

		@Nested
		@DisplayName("만약 보너스 번호가 제한된 범위의 최소값(1)보다 작다면")
		class Context_bonus_number_less_than_min_number {
			private final String inputBonusNumber = "0";

			@Test
			@DisplayName("예외를 발생시킨다.")
			void it_returns_illegal_argument_exception() {
				assertThatThrownBy(() -> new BonusNumber(inputBonusNumber, winningNumbers))
					.isInstanceOf(IllegalArgumentException.class);
			}
		}
	}

	@Nested
	@DisplayName("validateFirstNumberZero 메소드는")
	class Describe_validateFirstNumberZero {

		@Nested
		@DisplayName("만약 보너스 번호가 두자리이며 첫째자리 수가 0이면")
		class Context_bonus_number_double_digit_and_first_digit_zero {
			private final String inputBonusNumber = "07";

			@Test
			@DisplayName("예외를 발생시킨다.")
			void it_returns_illegal_argument_exception() {
				assertThatThrownBy(() -> new BonusNumber(inputBonusNumber, winningNumbers))
					.isInstanceOf(IllegalArgumentException.class);
			}
		}
	}

	@Nested
	@DisplayName("validateNumberOverlap 메소드는")
	class Describe_validateNumberOverlap {

		@Nested
		@DisplayName("만약 보너스 번호가 당첨번호 숫자들과 중복이면")
		class Context_winning_numbers_include_bonus_number {
			private final String inputBonusNumber = "1";

			@Test
			@DisplayName("예외를 발생시킨다.")
			void it_returns_illegal_argument_exception() {
				assertThatThrownBy(() -> new BonusNumber(inputBonusNumber, winningNumbers))
					.isInstanceOf(IllegalArgumentException.class);
			}
		}
	}
}
