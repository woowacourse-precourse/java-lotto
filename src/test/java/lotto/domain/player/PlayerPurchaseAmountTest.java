package lotto.domain.player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;
import java.math.BigInteger;
import lotto.utils.message.ExceptionMessageUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerPurchaseAmountTest {

    @Nested
    @DisplayName("String amountInput를 매개변수로 받는 메소드는")
    class DescribeStringConstructorTest {

        @Nested
        @DisplayName("만약 1000원 이상이며 1000원 단위인 유효한 값을 전달하면")
        class ContextWithAmountTest {

            @ParameterizedTest
            @ValueSource(strings = {"1000", "15000", "250000"})
            @DisplayName("PlayerPurchaseAmount를 생성한다")
            void it_returns_PlayerPurchaseAmount(String input) {
                assertThatCode(() -> new PlayerPurchaseAmount(new BigDecimal(input))).doesNotThrowAnyException();
            }
        }

        @Nested
        @DisplayName("만약 1000원 단위가 아닌 값을 전달하면")
        class ContextWithInvalidUnitAmountTest {

            @ParameterizedTest
            @ValueSource(strings = {"10001", "10010", "10100"})
            @DisplayName("IllegalArgumentException 예외가 발생한다")
            void it_throws_exception(String invalidInput) {
                assertThatThrownBy(() -> new PlayerPurchaseAmount(new BigDecimal(invalidInput)))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ExceptionMessageUtil.WRONG_PURCHASE_AMOUNT_UNIT.findFullMessage());
            }
        }

        @Nested
        @DisplayName("만약 1000원 이하의 값을 전달하면")
        class ContextWithInvalidMinAmountTest {

            @ParameterizedTest
            @ValueSource(strings = {"900", "80", "1", "-1000"})
            @DisplayName("IllegalArgumentException 예외가 발생한다")
            void it_throws_exception(String invalidInput) {
                assertThatThrownBy(() -> new PlayerPurchaseAmount(new BigDecimal(invalidInput)))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ExceptionMessageUtil.WRONG_PURCHASE_AMOUNT_VALUE.findFullMessage());
            }
        }
    }

    @Nested
    @DisplayName("calculatePurchaseLottoAmount 메소드는")
    class DescribeCalculatePurchaseLottoAmountMethodTest {

        @Nested
        @DisplayName("만약 호출하면")
        class ContextWithoutParameter {

            @ParameterizedTest
            @CsvSource(
                    value = {
                        "1000:1",
                        "5000:5",
                        "10000:10",
                    },
                    delimiter = ':'
            )
            @DisplayName("로또 구매 장수를 반환한다")
            void it_returns_purchaseAmount(String playerInput, long amountCount) {
                PlayerPurchaseAmount lottoPurchaseAmount = new PlayerPurchaseAmount(new BigDecimal(playerInput));

                BigInteger result = lottoPurchaseAmount.calculatePurchaseLottoAmount();

                assertThat(result).isEqualTo(BigInteger.valueOf(amountCount));
            }
        }
    }

    @Nested
    @DisplayName("calculateRevenuePercent 메소드는")
    class DescribeCalculateRevenuePercentMethodTest {

        @Nested
        @DisplayName("만약 총 당첨 상금이 주어지면")
        class ContextWithTotalRewardTest {

            @ParameterizedTest
            @CsvSource(
                    value = {
                        "1000:500.0",
                        "2000:250.0",
                        "3000:166.7",
                        "4000:125.0",
                        "5000:100.0"
                    },
                    delimiter = ':'
            )
            @DisplayName("수익률을 반환한다")
            void it_returns_revenuePercent(String input, String expected) {
                PlayerPurchaseAmount lottoPurchaseAmount = new PlayerPurchaseAmount(new BigDecimal(input));

                BigDecimal actualRevenue = lottoPurchaseAmount.calculateRevenuePercent(BigDecimal.valueOf(5000L));

                assertThat(actualRevenue.toString()).isEqualTo(expected);
            }
        }
    }
}