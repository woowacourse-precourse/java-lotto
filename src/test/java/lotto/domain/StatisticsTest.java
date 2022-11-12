package lotto.domain;

import lotto.exception.InputException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class StatisticsTest {

    @DisplayName("구입 금액을 로또 하나 금액으로 나눠 총 몇개를 발행할지 구한다.")
    @Test
    void getLottoPublishCount_함수_테스트() {
        String purchaseCount = "20000";

        Statistics statistics = new Statistics(purchaseCount);
        int lottoPublishCount = statistics.getLottoPublishCount();

        Assertions.assertThat(lottoPublishCount).isEqualTo(20);
    }

    @DisplayName("구입 금액 예외 처리 테스트")
    @Nested
    class Exception {

        @DisplayName("구입 금액이 숫자가 아닌 경우 예외를 터트린다.")
        @Test
        void hasDigitsOnly_함수_테스트() {
            String purchase = "3!@# A";
            System.setIn(generateUserInput(purchase));

            Assertions.assertThatThrownBy( () -> new Statistics(purchase))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(InputException.MONEY_NOT_DIGIT.message());
        }


        @DisplayName("구입 금액이 1000원 단위가 아닌 경우 예외를 터트린다.")
        @Test
        void isDividedByLottoAmount_함수_테스트() {
            String purchase = "11003";
            System.setIn(generateUserInput(purchase));

            Assertions.assertThatThrownBy( () -> new Statistics(purchase))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(InputException.MONEY_NOT_DIVIDE_BY_LOTTO_UNIT.message());
        }
    }

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
