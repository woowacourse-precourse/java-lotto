package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    @Test
    @DisplayName("상금 합계 구하기")
    public void calculate() {
        List<LottoRank> lottoNumbersList = new ArrayList<>();
        lottoNumbersList.add(LottoRank.FIFTH);
        lottoNumbersList.add(LottoRank.FIFTH);
        lottoNumbersList.add(LottoRank.FOURTH);

        int expect = (LottoRank.FIFTH.getPrice() << 1) + LottoRank.FOURTH.getPrice();
        LottoResult lottoResult = new LottoResult(lottoNumbersList);
        assertThat(lottoResult.calPriceSum()).isEqualTo(expect);
    }

}