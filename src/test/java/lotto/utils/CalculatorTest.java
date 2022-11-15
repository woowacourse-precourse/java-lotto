package lotto.utils;

import lotto.domains.Place;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class CalculatorTest {
    @Nested
    @DisplayName("calculateNumberOfLotto 메서드는")
    class Describe_calculateNumberOfLotto {
        @Nested
        @DisplayName("money가 주어지면")
        class Context_when_gives_money {
            private static final int money = 8000;
            private static final int result = 8;

            @Test
            @DisplayName("구매한 로또의 갯수를 반환한다.")
            void It_returns_number_of_lotto() {
                int amountOfLotto = Calculator.calculateNumberOfLotto(money);
                assertThat(amountOfLotto).isEqualTo(result);
            }
        }
    }

    @Nested
    @DisplayName("calculatePrize 메서드는")
    class Describe_calculatePrize {
        @Nested
        @DisplayName("당첨번호와, 당첨번호와 겹치는 사용자 번호, 보너스 번호가 주어진다면")
        class Context_when_gives_intersection_numbers {
            private final List<Integer> userLottoNumbers = List.of(4, 5, 6, 7, 8, 9);
            private final List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
            private static final int bonusNumber = 7;

            @Test
            @DisplayName("당첨된 등수를 반환한다.")
            void It_returns_reward_place() {
                Place place = Calculator.calculatePrize(userLottoNumbers, winningNumbers, bonusNumber);
                assertThat(place.getCorrection()).isEqualTo(3);
                assertThat(place.getPrize()).isEqualTo(5000);
            }
        }

        @Nested
        @DisplayName("맞는 번호가 하나도 없다면")
        class Context_when_gives_zero_intersection_numbers {
            private final List<Integer> userLottoNumbers = List.of(11, 12, 13, 14, 15, 15);
            private final List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
            private static final int bonusNumber = 7;

            @Test
            @DisplayName("당첨된 등수를 반환한다.")
            void It_returns_reward_place() {
                Place place = Calculator.calculatePrize(userLottoNumbers, winningNumbers, bonusNumber);
                assertThat(place.getCorrection()).isEqualTo(0);
                assertThat(place.getPrize()).isEqualTo(0);
            }
        }
    }

    @Nested
    @DisplayName("calculateMoney 메서드는")
    class Describe_calculateMoney {
        @Nested
        @DisplayName("entry가 주어지면")
        class Context_when_gives_entry {

            private Map.Entry<Place, Integer> prizeMap = new AbstractMap.SimpleEntry<>(Place.FIFTH, 3);

            @Test
            @DisplayName("당첨금 총액을 받환한다.")
            void It_returns_reward_value() {
                int result = Calculator.calculateMoney(prizeMap);
                assertThat(result).isEqualTo(15000);
            }
        }
    }

    @Nested
    @DisplayName("calculateProfit 메서드는")
    class Describe_calculateProfit {
        @Nested
        @DisplayName("올바른 구매 금액과 당첨금이 주어지면")
        class Context_when_gives_valid_purchase_amount_and_profit {
            private static final int VALID_PURCHASE_AMOUNT = 8000;
            private static final int PROFIT = 5000;

            @Test
            @DisplayName("이익률을 반환한다.")
            void It_returns_profit_percentage() {
                double result = Calculator.calculateProfit(VALID_PURCHASE_AMOUNT, PROFIT);
                assertThat(result).isEqualTo(62.5);
            }
        }

        @Nested
        @DisplayName("올바르지 않은 구매 금액과 당첨금이 주어지면")
        class Context_when_gives_invalid_purchase_amount_and_profit {
            private static final int INVALID_PURCHASE_AMOUNT = 0;
            private static final int PROFIT = 0;

            @Test
            @DisplayName("에러를 발생한다.")
            void It_throws_error() {
                assertThatThrownBy(() -> Calculator.calculateProfit(INVALID_PURCHASE_AMOUNT, PROFIT))
                        .hasMessageContaining("[ERROR] 숫자를 0으로 나눌 수 없습니다.")
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }

    }
}
