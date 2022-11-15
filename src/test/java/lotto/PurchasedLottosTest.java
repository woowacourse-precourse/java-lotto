package lotto;

import lotto.domain.PurchasedLottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PurchasedLottosTest {
    @DisplayName("구입 금액에 따른 로또의 개수가 맞는지 확인한다.")
    @Test
    void purchasedLottosTest(){
        assertThat(new PurchasedLottos(4000).getLottos().size())
                .isEqualTo(4);
    }
}
