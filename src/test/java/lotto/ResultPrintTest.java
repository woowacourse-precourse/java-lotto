package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultPrintTest {

    @DisplayName("2등 출력확인")
    @Test
    void printSecond() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        ResultPrint.printingResult(
                Map.of("FIRST", 0, "SECOND", 1, "THIRD", 0,
                "FOURTH", 0, "FIFTH", 0, "NOTHING", 7)
        );
        assertThat(out.toString()).contains("5개 일치, 보너스 볼 일치 (30,000,000원) - 1개");
    }
    @DisplayName("2등 2개 출력확인")
    @Test
    void printTwoSecond() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        ResultPrint.printingResult(
                Map.of("FIRST", 0, "SECOND", 2, "THIRD", 0,
                "FOURTH", 0, "FIFTH", 0, "NOTHING", 7)
        );
        assertThat(out.toString()).contains("5개 일치, 보너스 볼 일치 (30,000,000원) - 2개");
    }
    @DisplayName("1~5등 출력확인")
    @Test
    void printAll() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        ResultPrint.printingResult(
                Map.of("FIRST", 1, "SECOND", 2, "THIRD", 3,
                "FOURTH", 5, "FIFTH", 8, "NOTHING", 7)
        );
        assertThat(out.toString())
                .contains("3개 일치 (5,000원) - 8개")
                .contains("4개 일치 (50,000원) - 5개")
                .contains("5개 일치 (1,500,000원) - 3개")
                .contains("5개 일치, 보너스 볼 일치 (30,000,000원) - 2개")
                .contains("6개 일치 (2,000,000,000원) - 1개");
    }
}
