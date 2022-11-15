package lotto.lotto;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BuyTest {
    Buy buy = new Buy();

    @Nested
    class BuyLottoTest {
        @DisplayName("로또 구매 금액 1000단위로 나눈 값을 반환")
        @Test
        void lottoQuantityTest() {
            // given
            int amount = 5_000;
            int result = 5;

            // when
            int lottoQuantity = buy.lottoQuantity(amount);

            // then
            Assertions.assertThat(lottoQuantity)
                    .isEqualTo(result);
        }
    }

}