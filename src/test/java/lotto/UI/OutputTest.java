package lotto.UI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;
import java.util.function.BiConsumer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;

public class OutputTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @DisplayName("당첨 통계 출력 확인")
    @Test
    void printWinningStatisticsTest() {
        String resultPrintFormat = "3개 일치 (5,000원) - 1개\n"
                + "4개 일치 (50,000원) - 0개\n"
                + "5개 일치 (1,500,000원) - 0개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n"
                + "6개 일치 (2,000,000,000원) - 0개\n";

        float earningRate = 5000 / (float) 8000 * 100;

        BiConsumer<String, Float> c = Output::printWinningStatistics;
        c.accept(resultPrintFormat, earningRate);

        String expected = "당첨 통계\r\n"
                + "---\r\n"
                + resultPrintFormat
                + "총 수익률은 62.5%입니다.";

        assertEquals(expected, outputStreamCaptor.toString().trim());
    }

    @DisplayName("발행한 로또의 출력값을 확인")
    @Test
    void printLotteriesTest() {
        List<Lotto> lotteries = new ArrayList<Lotto>(
                Arrays.asList(new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45))));

        Consumer<List<Lotto>> c = Output::printLotteries;
        c.accept(lotteries);
        String expected = "8개를 구매했습니다.\r\n"
                + "[8, 21, 23, 41, 42, 43]\r\n"
                + "[3, 5, 11, 16, 32, 38]\r\n"
                + "[7, 11, 16, 35, 36, 44]\r\n"
                + "[1, 8, 11, 31, 41, 42]\r\n"
                + "[13, 14, 16, 38, 42, 45]\r\n"
                + "[7, 11, 30, 40, 42, 43]\r\n"
                + "[2, 13, 22, 32, 38, 45]\r\n"
                + "[1, 3, 5, 14, 22, 45]";

        assertEquals(expected , outputStreamCaptor.toString().trim());
    }

}
