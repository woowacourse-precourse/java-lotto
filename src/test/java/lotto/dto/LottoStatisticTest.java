package lotto.dto;

import java.math.BigDecimal;
import java.util.Map;
import lotto.type.LottoStandard;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoStatisticTest {

    @Test
    public void addLottoStandard() {
        //given
        LottoStatistic statistic = new LottoStatistic();
        LottoStandard first = LottoStandard.FIRST;
        LottoStandard second = LottoStandard.SECOND;
        LottoStandard third = LottoStandard.THIRD;
        LottoStandard fourth = LottoStandard.FOURTH;
        LottoStandard fifth = LottoStandard.FIFTH;
        LottoStandard nothing = LottoStandard.NOTHING;

        //when
        statistic.addLottoStandard(first);
        statistic.addLottoStandard(second);
        statistic.addLottoStandard(third);
        statistic.addLottoStandard(fourth);
        statistic.addLottoStandard(fifth);
        statistic.addLottoStandard(nothing);

        //then
        Map<LottoStandard, Integer> resultMap = statistic.getResultMap();
        for (LottoStandard standard : resultMap.keySet()) {
            Assertions.assertThat(resultMap.get(standard)).isEqualTo(1);
        }
    }

    @Test
    public void calculateYield() {
        //given
        LottoStatistic statistic1 = new LottoStatistic();
        long totalPrize1 = 9000L;
        long purchaseAmount1 = 3000L;
        LottoStatistic statistic2 = new LottoStatistic();
        long totalPrize2 = 8000L;
        long purchaseAmount2 = 5000L;

        //when
        statistic1.calculateYield(totalPrize1, purchaseAmount1);
        statistic2.calculateYield(totalPrize2, purchaseAmount2);

        //then
        Assertions.assertThat(statistic1.getYield()).isEqualTo(BigDecimal.valueOf(33.3));
        Assertions.assertThat(statistic2.getYield()).isEqualTo(BigDecimal.valueOf(62.5));
    }

}