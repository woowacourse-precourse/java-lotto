package lotto;

import lotto.Domain.PurchasingLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

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
}
