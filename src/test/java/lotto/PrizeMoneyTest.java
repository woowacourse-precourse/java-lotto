package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeMoneyTest {

    @Test
    void 상금_출력_테스트() {
        assertThat(PrizeMoney.RANK1.getLabel()).isEqualTo("3개 일치 (5,000원)");
        assertThat(PrizeMoney.RANK2.getMoney()).isEqualTo(50000L);
    }
}