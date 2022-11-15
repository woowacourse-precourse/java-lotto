package lotto.domain.rank;

import lotto.domain.user.Purchase;
import lotto.exception.InputException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class PurchaseTest {

    private Purchase purchase;

    @BeforeEach
    void init() {
        String purchaseCount = "2000";
        purchase = Purchase.create(purchaseCount);
    }

    @DisplayName("구입 금액을 로또 하나 금액으로 나눠 총 몇개를 발행할지 구한다.")
    @Test
    void getLottoPublishCount() {
        int lottoPublishCount = purchase.getLottoPublishCount();

        assertThat(lottoPublishCount).isEqualTo(2);
    }

    @DisplayName("당첨 금액에 대한 총 수익률을 구한다.")
    @Test
    void getLottoYield() {
        int winAmount = 30010000;
        double lottoYield = purchase.findLottoYield(winAmount);
        assertThat(lottoYield).isEqualTo(3001000.0);
    }

    @DisplayName("구입 금액 숫자 예외 처리 테스트")
    @Nested
    class NumberException {

        @DisplayName("구입 금액이 1000원 단위가 아닌 경우 예외를 터트린다.")
        @Test
        void isDividedByLottoAmount() {
            String purchase = "11003";

            Assertions.assertThatThrownBy(() -> Purchase.create(purchase))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(InputException.MONEY_NOT_DIVIDE_BY_LOTTO_UNIT.message());
        }
    }

    @DisplayName("구입 금액 문자열 예외 처리 테스트")
    @Nested
    class StringException {

        @DisplayName("구입 금액이 숫자가 아닌 경우 예외를 터트린다.")
        @Test
        void hasDigitsOnly() {
            String purchase = "3!@# A";
            System.setIn(generateUserInput(purchase));

            Assertions.assertThatThrownBy(() -> Purchase.create(purchase))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(InputException.MONEY_NOT_DIGIT.message());
        }
    }

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
