package lotto.application.service.yield;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class YieldCalculatorTest {

    @DisplayName("수익률 계산 로직 검증")
    @Test
    void 수익률_계산() {
        int purchaseMoney = 8000;
        int winningMoney = 5000;
        double yield = (double) winningMoney / (double) purchaseMoney * 100;

        assertThat(Math.round(yield * 10) / 10.0).isEqualTo(62.5);
    }

    @DisplayName("수익률이 100일때 출력형식 검증 : 100이 아니라, 100.0 이 출력되어야 한다.")
    @Test
    void 수익률이100일때_출력형식_검증() {

        int purchaseMoney = 5000;
        int winningMoney = 5000;
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        double yield = (double) winningMoney / (double) purchaseMoney * 100;
        System.out.printf("총 수익률은 %s%%입니다.", Math.round(yield * 10) / 10.0);

        Assertions.assertThat("총 수익률은 100.0%입니다.").isEqualTo(out.toString());
    }

    @DisplayName("수익률 소수점 둘째자리에서 반올림")
    @Test
    void 수익률_소수점_둘째자리에서_반올림() {
        int purchaseMoney = 9000;
        int winningMoney = 15000;
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        double yield = (double) winningMoney / (double) purchaseMoney * 100;
        System.out.printf("총 수익률은 %s%%입니다.", Math.round(yield * 10) / 10.0);

        Assertions.assertThat("총 수익률은 166.7%입니다.").isEqualTo(out.toString());
    }

    @DisplayName("수익률 출력 테스트")
    @Test
    void 수익률_출력_테스트() {
        int purchaseMoney = 8000;
        int winningMoney = 5000;
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        double yield = (double) winningMoney / (double) purchaseMoney * 100;
        System.out.printf("총 수익률은 %s%%입니다.", Math.round(yield * 10) / 10.0);

        Assertions.assertThat("총 수익률은 62.5%입니다.").isEqualTo(out.toString());
    }
}