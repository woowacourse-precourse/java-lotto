package lotto.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoStatisticFormatTest {

    @Test
    void decimalFormatTest(){
        String result = LottoStatisticFormat.addWinningMoney(100000L);
        Assertions.assertThat(result).isEqualTo("(100,000원)");
    }
}