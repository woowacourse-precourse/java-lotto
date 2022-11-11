package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

import static org.assertj.core.api.Assertions.assertThat;

public class LearningTest {

    @DisplayName("소수점 둘째 자리에서 반올림 테스트")
    @Test
    void roundTest() {
        double number = 11.12345D;
        double result = Math.round(number * 10);
        result /= 10;

        assertThat(result).isEqualTo(11.1D);
    }

    @DisplayName("소수점 둘째 자리에서 반올림 테스트2")
    @Test
    void roundTest2() {
        double number = 62.5D;
        double result = Math.round(number * 10);
        result /= 10;

        assertThat(result).isEqualTo(62.5D);
    }

    @DisplayName("돈 단위 출력 메시지에 ,이 알맞게 출력되는지 테스트")
    @Test
    void printMoney() {
        int money = 2000000000;
        DecimalFormat dc = new DecimalFormat("###,###,###,###");
        String ch = dc.format(money);
        assertThat(ch).isEqualTo("2,000,000,000");
    }
}
