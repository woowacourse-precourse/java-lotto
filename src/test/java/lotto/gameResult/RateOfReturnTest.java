package lotto.gameResult;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RateOfReturnTest {
    @DisplayName("로또구입 금액을 입력했을 때 수익률 생성 테스트")
    @Test
    void rateOfReturn() {
        WinningLotto.fifthClassNumber = 1;

        assertThat(RateOfReturn.returnRate("1000")).isEqualTo("500.0");
    }
}
