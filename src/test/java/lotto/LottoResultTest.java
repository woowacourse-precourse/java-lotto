package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {
    LottoResult result;
    @BeforeEach
    void beforeEach() {
        result = new LottoResult();
    }

    @Test
    void 당첨안됨() {
        long total = result.getTotalMoney();
        assertThat(total).isEqualTo(0);
    }

    @Test
    void 당첨1() {
        result.addPrize(Prize.PRIZE1);
        long total = result.getTotalMoney();
        assertThat(total).isEqualTo(2000000000);
    }

    @Test
    void 당첨2() {
        result.addPrize(Prize.PRIZE2);
        long total = result.getTotalMoney();
        assertThat(total).isEqualTo(30000000);
    }

    @Test
    void 당첨3() {
        result.addPrize(Prize.PRIZE3);
        long total = result.getTotalMoney();
        assertThat(total).isEqualTo(1500000);
    }

    @Test
    void 당첨4() {
        result.addPrize(Prize.PRIZE4);
        long total = result.getTotalMoney();
        assertThat(total).isEqualTo(50000);
    }

    @Test
    void 당첨5() {
        result.addPrize(Prize.PRIZE5);
        long total = result.getTotalMoney();
        assertThat(total).isEqualTo(5000);
    }

    @Test
    void 당첨5_2개ㅓ() {
        result.addPrize(Prize.PRIZE5);
        result.addPrize(Prize.PRIZE5);
        long total = result.getTotalMoney();
        assertThat(total).isEqualTo(10000);
    }
    @Test
    void 당첨5_4_3() {
        result.addPrize(Prize.PRIZE5);
        result.addPrize(Prize.PRIZE4);
        result.addPrize(Prize.PRIZE3);
        long total = result.getTotalMoney();
        assertThat(total).isEqualTo(1555000);
    }
}