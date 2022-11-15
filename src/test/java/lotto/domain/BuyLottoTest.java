package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BuyLottoTest {

    BuyLotto buyLotto;

    @DisplayName("금액에 맞는 개수의 로또를 구입했는지 체크")
    @Nested
    class CountFromPrice {
        @DisplayName("8000원은 8개")
        @Test
        void case1() {
            buyLotto = new BuyLotto(8000);
            assertThat(buyLotto.getCount()).isEqualTo(8);
        }

        @DisplayName("4000원은 4개")
        @Test
        void case2() {
            buyLotto = new BuyLotto(4000);
            assertThat(buyLotto.getCount()).isEqualTo(4);
        }

        @DisplayName("0원은 0개")
        @Test
        void case3() {
            buyLotto = new BuyLotto(0);
            assertThat(buyLotto.getCount()).isEqualTo(0);
        }
    }

    @DisplayName("예외 : 금액이 1,000원 단위가 아닐 때")
    @Nested
    class Exceptions {
        @DisplayName("1230원")
        @Test
        void case1() {
            assertThatThrownBy(() -> new BuyLotto(1230))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("7452원")
        @Test
        void case2() {
            assertThatThrownBy(() -> new BuyLotto(7452))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("15001원")
        @Test
        void case3() {
            assertThatThrownBy(() -> new BuyLotto(15001))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }


}