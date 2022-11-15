package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Money 클래스")
class MoneyTest {
	@Nested
	@DisplayName("validateNumberRange 메소드는")
	class Describe_validateInputLetter {
		@Nested
		@DisplayName("만약 구매금액에 알파벳이 포함된다면")
		class Context_money_include_alphabet {
			private final String inputMoney = "7000a";

			@Test
			@DisplayName("예외가 발생한다")
			void it_returns_illegal_argument_exception() {
				assertThatThrownBy(() -> new Money(inputMoney)).isInstanceOf(IllegalArgumentException.class);
			}
		}

		@Nested
		@DisplayName("만약 구매금액에 공백이 포함된다면")
		class Context_money_include_blank {
			private final String inputMoney = " 7000";

			@Test
			@DisplayName("예외가 발생한다")
			void it_returns_illegal_argument_exception() {
				assertThatThrownBy(() -> new Money(inputMoney)).isInstanceOf(IllegalArgumentException.class);
			}
		}
	}

	@Nested
	@DisplayName("validateFirstNumberZero 메소드는")
	class Describe_validateFirstNumberZero {
		@Nested
		@DisplayName("만약 두자리 이상의 구매금액에 첫번째 자리가 0이면")
		class Context_money_first_digit_zero {
			private final String inputMoney = "09000";

			@Test
			@DisplayName("예외가 발생한다")
			void it_returns_illegal_argument_exception() {
				assertThatThrownBy(() -> new Money(inputMoney)).isInstanceOf(IllegalArgumentException.class);
			}
		}
	}

	@Nested
	@DisplayName("validateMultipleOfThousand 메소드는")
	class Describe_validateMultipleOfThousand {
		@Nested
		@DisplayName("만약 구매금액이 1000의 배수가 아니면")
		class Context_money_not_multiple_of_thousand {
			private final String inputMoney = "09000";

			@Test
			@DisplayName("예외가 발생한다")
			void it_returns_illegal_argument_exception() {
				assertThatThrownBy(() -> new Money(inputMoney)).isInstanceOf(IllegalArgumentException.class);
			}
		}
	}

	@Nested
	@DisplayName("validateMoneyBoundary 메소드는")
	class Describe_validateMoneyBoundary {
		@Nested
		@DisplayName("만약 구매금액이 입력가능한 최소 구매금액(1,000)보다 작으면")
		class Context_money_under_min_number {
			private final String inputMoney = "0";

			@Test
			@DisplayName("예외가 발생한다")
			void it_returns_illegal_argument_exception() {
				assertThatThrownBy(() -> new Money(inputMoney)).isInstanceOf(IllegalArgumentException.class);
			}
		}

		@Nested
		@DisplayName("만약 구매금액이 입력가능한 최대 구매금액(2,000,000,000)보다 크면")
		class Context_money_over_max_number {
			private final String inputMoney = "0";

			@Test
			@DisplayName("예외가 발생한다")
			void it_returns_illegal_argument_exception() {
				assertThatThrownBy(() -> new Money(inputMoney)).isInstanceOf(IllegalArgumentException.class);
			}
		}
	}

	@Nested
	@DisplayName("getNumberOfPurchases 메소드는")
	class Describe_getNumberOfPurchases {
		@Nested
		@DisplayName("만약 구매금액이 주어진다면")
		class Context_money_not_multiple_of_thousand {
			private final String inputMoney = "9000";

			@Test
			@DisplayName("구매금액에서 기준단위를 나눈 구매개수를 리턴한다.")
			void it_returns_number_of_purchases() {
				long expectedAnswer = 9;
				Money money = new Money(inputMoney);

				assertThat(money.getNumberOfPurchases()).isEqualTo(expectedAnswer);
			}
		}
	}
}
