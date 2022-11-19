package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BuyLottoTest {
    BuyLotto buyLotto;

    @DisplayName("금액에 맞는 개수의 로또를 구입했는지 체크")
    @Nested
    class CountFromPrice {
        @ParameterizedTest(name = "{0}원은 {1}개")
        @CsvSource(value = {"8000, 8", "4000, 4", "0, 0"})
        void countTest(int price, int count) {
            buyLotto = new BuyLotto(price);
            assertThat(buyLotto.getCount()).isEqualTo(count);
        }
    }

    @DisplayName("예외 : 금액이 1,000원 단위가 아닐 때")
    @Nested
    class Exceptions {
        @ParameterizedTest(name = "{0}원은 1,000원 단위가 아니다.")
        @ValueSource(ints = {1230, 7452, 15001})
        void exceptionCases(int price) {
            assertThatThrownBy(() -> new BuyLotto(price))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}