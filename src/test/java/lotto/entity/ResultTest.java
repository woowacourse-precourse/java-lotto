package lotto.entity;

import static lotto.LottoApplication.PRICE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

    @DisplayName("로또 결과에 따른 수익률을 계산한다.")
    @Test
    void calculateRateOfReturn() {
        //given
        int count = 2;
        int purchase = PRICE * count * 2;
        Map<Rank, Integer> rankMap = new HashMap<>();
        rankMap.put(Rank.FIRST, count);
        rankMap.put(Rank.SECOND, count);
        Result result = new Result(rankMap);
        double total = Rank.FIRST.getPrize() * count + Rank.SECOND.getPrize() * count;

        //when
        double value = result.calculateRateOfReturn();

        //then
        assertThat(value).isEqualTo(total / purchase * 100);
    }

}