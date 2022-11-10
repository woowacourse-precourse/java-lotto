package lotto.domain.winning;

import static org.assertj.core.data.Offset.offset;

import java.util.List;
import java.util.Map;
import lotto.domain.lotto_numbers.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaserTest {

    @DisplayName("8개를 구매하고, 5000원짜리 한개가 당첨되면 수익률은 62.5이다.")
    @Test
    void rateOfReturn1() {
        Purchaser purchaser = new Purchaser(
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

        LottoResults lottoResults = new LottoResults(
                Map.of(
                        LottoRanking.FIFTH, 1,
                        LottoRanking.FORTH, 0,
                        LottoRanking.THIRD, 0,
                        LottoRanking.SECOND, 0,
                        LottoRanking.FIRST, 0
                )
        );

        double rateOfReturn = purchaser.rateOfReturn(lottoResults);
        Assertions.assertThat(rateOfReturn).isCloseTo(62.5, offset(0.1));
    }

    @DisplayName("한 개도 당첨되지 않으면 수익률은 0이다.")
    @Test
    void rateOfReturn2() {
        Purchaser purchaser = new Purchaser(
                List.of(
                        new Lotto(List.of(30, 32, 33, 34, 35, 40))
                )
        );

        LottoResults lottoResults = new LottoResults(
                Map.of(
                        LottoRanking.FIFTH, 0,
                        LottoRanking.FORTH, 0,
                        LottoRanking.THIRD, 0,
                        LottoRanking.SECOND, 0,
                        LottoRanking.FIRST, 0
                )
        );

        double rateOfReturn = purchaser.rateOfReturn(lottoResults);
        Assertions.assertThat(rateOfReturn).isCloseTo(0.0, offset(0.1));
    }
}