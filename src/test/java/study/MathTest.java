package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MathTest {
    @Test
    @DisplayName("math round 테스트")
    public void mathRound1() {
        double round = Math.round(0.11111444423424 * 100 * 10) / 10.0;
        assertThat(round).isEqualTo(11.1);
    }

    @Test
    @DisplayName("System.out 테스트")
    public void soutTest() {
        double round = Math.round(0.11111444423424 * 100 * 10) / 10.0;
        System.out.println(round); // 이건 소수점 첫째자리까지 나온다.
        System.out.printf("%f\n", round); // 이건 소수점 여섯째자리까지 나온다.
        System.out.printf("%.1f\n", round); // 포맷 사용시에는 자릿수를 지정해주어야한다.
    }


}
