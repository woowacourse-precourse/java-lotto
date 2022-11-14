package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static lotto.domain.Statistic.*;

class StatisticTest {

    @ParameterizedTest
    @DisplayName("수익 테스트")
    @CsvSource(value = {
            "3:5000",
            "4:50000",
            "5:1500000",
            "6:30000000",
            "7:2000000000"
    }, delimiter = ':')
    void revenueTest(int idx, int revenue) {
        assert (getRevenue(idx) == revenue);
    }

}