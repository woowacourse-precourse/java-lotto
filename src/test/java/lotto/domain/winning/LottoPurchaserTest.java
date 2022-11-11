package lotto.domain.winning;

import java.util.List;
import lotto.domain.lotto_numbers.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPurchaserTest {

    @DisplayName("8개를 구매하면, 구매한 총 가격인 8000을 반환한다.")
    @Test
    void returnTotalPricesOfPurchase1() {
        LottoPurchaser lottoPurchaser = new LottoPurchaser(
                List.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6))
                )
        );
        int actual = lottoPurchaser.totalPricesOfPurchase();
        int predict = 8_000;
        Assertions.assertThat(actual).isEqualTo(predict);
    }
}