package lotto.UI;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ViewTest {

    @DisplayName(".1f 했을 때 반올림이 잘 되는지 테스트")
    @Test
    public void printProfitRateTest() {
        View view = new View();
        view.printProfitRate(66.66666);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        assertThat(out).toString().contains("66.7%");
    }
}