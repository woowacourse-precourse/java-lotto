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
        ResultPrint resultPrint = new ResultPrint(
                Map.of("FIRST", 0, "SECOND", 1, "THIRD", 0,
                        "FOURTH", 0, "FIFTH", 0, "NOTHING", 7)
        );
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        resultPrint.printingResult();
        assertThat(out.toString()).contains("5개 일치, 보너스 볼 일치 (30,000,000원) - 1개");
    }
}
