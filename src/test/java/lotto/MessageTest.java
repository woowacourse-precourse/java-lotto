package lotto;

import lotto.Domain.Statistic;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MessageTest {

    static ByteArrayOutputStream consoleOutput;

    @BeforeAll
    private static void initClasses() {
        consoleOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(consoleOutput));
    }


    @Test
    void 수익률_확인시_반올림과_print형변환() {
        Statistic statistic = new Statistic();

        consoleOutput.reset();
        double inputPercent = 62.512123511232123123;
        double expectedPercent = 62.5;

        statistic.printResult(inputPercent);
        String expectedString = "총 수익률은 " + String.valueOf(expectedPercent) + "%입니다.\n";

        assertThat(consoleOutput.toString()).isEqualTo(expectedString);

        consoleOutput.reset();
        inputPercent = 62.59999991;
        expectedPercent = 62.6;

        statistic.printResult(inputPercent);
        expectedString = "총 수익률은 " + String.valueOf(expectedPercent) + "%입니다.\n";

        assertThat(consoleOutput.toString()).isEqualTo(expectedString);
    }
}
