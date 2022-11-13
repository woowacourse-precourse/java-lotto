package lotto.domain;

import static lotto.domain.match.Reward.FIFTH;
import static lotto.domain.match.Reward.FIRST;
import static lotto.domain.match.Reward.FOURTH;
import static lotto.domain.match.Reward.SECOND;
import static lotto.domain.match.Reward.THIRD;

import java.util.List;
import lotto.domain.match.MatchResults;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class YieldCalculatorTest {

    @DisplayName("올바른 경우")
    @Test
    void getYield() {
        MatchResults results = new MatchResults(List.of(FIRST, SECOND, THIRD, FOURTH, FIFTH));
        int buyMoney = 8000;

        long totalPrice = results.getTotalPrice();
        float expect = (float) totalPrice / buyMoney;

        Assertions.assertThat(YieldCalculator.getYield(results, buyMoney)).isEqualTo(expect);
    }
}