package lotto.domain;

import static lotto.domain.LottoStore.INVALID_VALUE_OF_MONEY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.winning.PurchasedLottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoStoreTest {

    private final LottoStore lottoStore = new LottoStore();

    @Nested
    class success {

        @ParameterizedTest(name = "지불 금액 정보를 전달 받고, 금액에 따라 로또를 여러개 발행한다.")
        @CsvSource({"12000,12", "1000,1", "120000,120"})
        void test(String money, String result) {
            PurchasedLottoTickets lottos = lottoStore.lottoTickets(money);
            assertThat(lottos.totalCounts()).isEqualTo(Integer.parseInt(result));
        }
    }

    @Nested
    class fail {

        @ParameterizedTest(name = "1,000원 단위로 나누어 떨어지지 않는 금액이 입력되면 예외를 던진다.")
        @ValueSource(strings = {"1100", "25555", "500"})
        void test(String money) {
            assertThatThrownBy(() -> lottoStore.lottoTickets(money))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(INVALID_VALUE_OF_MONEY);
        }

        @DisplayName("0원을 입력하면 예외를 던진다.")
        @Test
        void test2() {
            assertThatThrownBy(() -> lottoStore.lottoTickets("0"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(INVALID_VALUE_OF_MONEY);
        }
    }
}