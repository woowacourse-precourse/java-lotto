package lotto;

import lotto.model.Profit;
import lotto.model.enums.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProfitTest {
    @DisplayName("수익률 정상 출력 테스트")
    @Test
    void checkProfit() {
        int testPrice = 5000;
        List<Integer> testWinningResult = new ArrayList<>(List.of(0, 1, 2, 1, 0));
        double expectedProfitRate = 661000.0;
        assertThat(new Profit(testPrice, testWinningResult).profitRate)
                .isEqualTo(expectedProfitRate);
    }
}