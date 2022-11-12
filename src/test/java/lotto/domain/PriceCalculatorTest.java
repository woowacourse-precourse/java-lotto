package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import lotto.domain.enumeration.Rank;
import org.junit.jupiter.api.Test;

public class PriceCalculatorTest {
    @Test
    void 수익률_계산_테스트() {
        //given
        Map<Rank, Integer> winStatus = Map.of(
                Rank.FIFTH, 3
        );
        int purchaseMoney = 10000;
        float realYield = 150.0f;

        //when
        float testYield = PriceCalculator.getyield(winStatus, purchaseMoney);

        //then
        assertThat(testYield).isEqualTo(realYield);
    }
}
