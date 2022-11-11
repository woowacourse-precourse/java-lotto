package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoSellerTest {

    @Nested
    class buyLottos {

        @DisplayName("1000으로 나누어 떨어지지 않는 값을 입력할 때")
        @ParameterizedTest
        @CsvSource(value = {"100", "1001", "1100"})
        void caseError1(int money) {
            LottoSeller lottoSeller = new LottoSeller();
            assertThatThrownBy(() -> lottoSeller.buyLottos(money))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("로또 구앱 금액은 1,000원 단위로 입력해야 합니다.");
        }

        @DisplayName("0이나 음수의 값을 입력할 때")
        @ParameterizedTest
        @CsvSource(value = {"0", "-1000", "-10000", "-1234"})
        void caseError2(int money) {
            LottoSeller lottoSeller = new LottoSeller();
            assertThatThrownBy(() -> lottoSeller.buyLottos(money))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("로또 구매 금액은 0보다 커야 합니다.");
        }

        @DisplayName("1000으로 나누어지는 값을 입력할 때")
        @ParameterizedTest
        @CsvSource(value = {"1000, 1", "2000, 2", "10000, 10", "500000, 500"})
        void caseSuccess(int money, int cnt) {
            LottoSeller lottoSeller = new LottoSeller();
            List<Lotto> lottos = lottoSeller.buyLottos(money);

            assertThat(lottos.size()).isEqualTo(cnt);
        }
    }
}