package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ProfitTest {



    @DisplayName("")
    @Test
    void calculatePercentageOfProfit() {
        String percentageOfprofit = "62.5";

        Profit profit = new Profit(8000, 5000);
        assertThat(profit.getPercentageProfit()).isEqualTo(percentageOfprofit);
    }
}