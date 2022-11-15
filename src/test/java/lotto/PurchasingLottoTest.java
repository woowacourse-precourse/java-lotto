package lotto;

import lotto.Domain.Lotto;
import lotto.Domain.PurchasingLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchasingLottoTest {
    @DisplayName("로또 구입 금액에 따라 로또의 개수를 리턴한다.")
    @Test
    void calculateNumberOfLottoTest() {
        // given
        int purchasing1 = 3000;
        PurchasingLotto purchasingLotto = new PurchasingLotto(purchasing1);

        // when
        int theNumberOfLotto = purchasingLotto.calculateNumberOfLotto(purchasing1);

        // then
        assertThat(theNumberOfLotto).isEqualTo(3);
    }

    @DisplayName("구입 금액이 1000원으로 나누어 떨어지지 않을 때 예외 처리한다.")
    @Test
    void devisionValidTest() {
        //given
        int purchase = 1400;
        PurchasingLotto purchasingLotto = new PurchasingLotto(purchase);

        // when, then
        assertThatThrownBy(() -> purchasingLotto.devisionValid(purchase))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");

    }
}
