package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import lotto.service.LottoService;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoServiceTest {

    @Nested
    class BuyLottos {

        LottoService lottoService = new LottoService();

        @DisplayName("금액이 양수가 아니면 예외 발생")
        @Test
        void moneyNotPositiveNumber() {
            int notPositiveMoney = -1;
            assertThatThrownBy(() -> lottoService.buyLottos(notPositiveMoney))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("금액이 로또 가격으로 나누어 떨어지지 않으면 예외 발생")
        @Test
        void moneyNotDivideByLottoPrice() {
            int notDivideMoney = 999;
            assertThatThrownBy(() -> lottoService.buyLottos(notDivideMoney))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("지불한 금액에 맞는 로또 개수 발행")
        @Test
        void makeLottosByPaidMoney() {
            int money = 8000;
            assertEquals(lottoService.buyLottos(money).size(), 8);
        }
    }
}
