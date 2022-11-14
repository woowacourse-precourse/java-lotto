package lotto.view;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PrintViewTest {
    private final String LOTTOS = String.join(System.lineSeparator(),
            "[8, 21, 23, 41, 42, 43]", "[3, 5, 11, 16, 32, 38]", "[7, 11, 16, 35, 36, 44]", "[1, 8, 11, 31, 41, 42]\n");
    private PrintView printView = new PrintView();

    @Test
    void outputPurchaseQuantity() {
        List<Integer> lotto1 = List.of(8, 21, 23, 41, 42, 43);
        List<Integer> lotto2 = List.of(3, 5, 11, 16, 32, 38);
        List<Integer> lotto3 = List.of(7, 11, 16, 35, 36, 44);
        List<Integer> lotto4 = List.of(1, 8, 11, 31, 41, 42);

        List<List<Integer>> lottos = List.of(lotto1, lotto2, lotto3, lotto4);

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        printView.outputPurchaseQuantity(lottos);

        assertThat(LOTTOS).isEqualTo(out.toString());
    }
}