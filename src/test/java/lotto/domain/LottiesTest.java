package lotto.domain;

import lotto.exception.InputException;
import lotto.view.InputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class LottiesTest {

    private Lotties lotties;

    @BeforeEach
    void init() {
        int purchaseCount = 2000;
        lotties = Lotties.create(purchaseCount);
    }

    @DisplayName("구입 금액을 로또 하나 금액으로 나눠 총 몇개를 발행할지 구한다.")
    @Test
    void getLottoPublishCount() {
        int lottoPublishCount = lotties.getLottoPublishCount();

        Assertions.assertThat(lottoPublishCount).isEqualTo(2);
    }

    @DisplayName("로또를 주어진 개수만큼 발행한다.")
    @Test
    void createLotties() {
        int lottoSize = lotties.getLotties().size();

        Assertions.assertThat(lottoSize).isEqualTo(2);
    }

    @DisplayName("구입 금액 숫자 예외 처리 테스트")
    @Nested
    class NumberException {

        @DisplayName("구입 금액이 1000원 단위가 아닌 경우 예외를 터트린다.")
        @Test
        void isDividedByLottoAmount() {
            int purchase = 11003;

            Assertions.assertThatThrownBy( () -> Lotties.create(purchase))
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

            Assertions.assertThatThrownBy(InputView::inputLottoPurchaseAmount)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(InputException.MONEY_NOT_DIGIT.message());
        }
    }

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
