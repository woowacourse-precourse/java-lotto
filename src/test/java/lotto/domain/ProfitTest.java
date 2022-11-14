package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class ProfitTest {

    @DisplayName("수익률을 정확하게 계산하는지, 소수점 둘째자리에서 반올림 하는지 확인")
    @Test
    void createProfit() {
        assertThat(new Profit(new Money(8000), 5000).getProfit())
                .isEqualTo(62.5);
    }

}