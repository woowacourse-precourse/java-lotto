package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Lotto 클래스")
class LottoTest {
	@Nested
	@DisplayName("validateNumberSize 메소드는")
	class Describe_validateNumbersSize {
		@Nested
		@DisplayName("만약 로또번호가 6개가 아니라면")
		class Context_lotto_numbers_size_not_six {
			private final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

			@Test
			@DisplayName("예외가 발생한다.")
			void it_returns_illegal_argument_exception() {
				assertThatThrownBy(() -> new Lotto(numbers))
					.isInstanceOf(IllegalArgumentException.class);
			}
		}
	}

	@Nested
	@DisplayName("validateNumbersOverlap 메소드는")
	class Describe_validateNumbersOverlap {
		@Nested
		@DisplayName("만약 로또번호중 중복이 있다면")
		class Context_lotto_numbers_have_overlap_number {
			private final List<Integer> numbers = Arrays.asList(1, 2, 3, 6, 5, 6);

			@Test
			@DisplayName("예외가 발생한다.")
			void it_returns_illegal_argument_exception() {
				assertThatThrownBy(() -> new Lotto(numbers))
					.isInstanceOf(IllegalArgumentException.class);
			}
		}
	}

	@Nested
	@DisplayName("validateNumbersBoundary 메소드는")
	class Describe_validateNumbersBoundary {
		@Nested
		@DisplayName("만약 로또번호중 제한범위의 최소값(1)보다 작은 수가 있다면")
		class Context_lotto_numbers_have_under_min_number {
			private final List<Integer> numbers = Arrays.asList(0, 2, 3, 6, 5, 6);

			@Test
			@DisplayName("예외가 발생한다.")
			void it_returns_illegal_argument_exception() {
				assertThatThrownBy(() -> new Lotto(numbers))
					.isInstanceOf(IllegalArgumentException.class);
			}
		}

		@Nested
		@DisplayName("만약 로또번호중 제한범위의 최대값(45)보다 큰 수가 있다면 ")
		class Context_lotto_numbers_have_over_max_number {
			private final List<Integer> numbers = Arrays.asList(46, 2, 3, 6, 5, 6);

			@Test
			@DisplayName("예외가 발생한다.")
			void it_returns_illegal_argument_exception() {
				assertThatThrownBy(() -> new Lotto(numbers))
					.isInstanceOf(IllegalArgumentException.class);
			}
		}
	}
}
