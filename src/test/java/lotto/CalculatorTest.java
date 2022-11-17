package lotto;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    void 정답_계산() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Calculator calc = new Calculator(1000L);
        Calculator.calculateLottos(4, true);
        Calculator.calculateLottos(5,true);
        Calculator.calculateLottos(5,false);
        calc.printResult();
        assertThat(out.toString()).contains("3개 일치 (5,000원) - 0개")
                .contains("4개 일치 (50,000원) - 1개")
                .contains("5개 일치 (1,500,000원) - 1개")
                .contains("5개 일치, 보너스 볼 일치 (30,000,000원) - 1개");
    }

    @Test
    void 수익률_계산() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Calculator calc = new Calculator(1000L);
        Calculator.calculateLottos(3,false);
        calc.printResult();
        assertThat(out.toString()).contains("총 수익률은 500.0%입니다.");
    }

    @Test
    void 당첨이_없음() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Calculator calc = new Calculator(1000L);
        Calculator.calculateLottos(2, false);
        calc.printResult();
        assertThat(out.toString()).contains("총 수익률은 0.0%입니다.");
    }
}
