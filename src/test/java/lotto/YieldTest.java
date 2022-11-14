package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class YieldTest extends NsTest {
    @DisplayName("수익률 계산 결과를 반환한다.")
    @Test
    void resultForYieldCalculation() {
        int netIncome = 5000;
        int purchaseAmount = 8000;
        new Yield(netIncome, purchaseAmount);
        assertThat(output()).contains(
                "총 수익률은 62.5%입니다."
        );
    }

    @Override
    protected void runMain() {

    }
}
