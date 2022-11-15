package lotto;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import lotto.ui.Counter;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class InputTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("구입 금액에 문자가 포함되어 있으면 에러가 발생한다.")
    @Test
    void inputAmountContainsString() {
        String input = "1000a";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Counter counter = new Counter();
        try {
            counter.inputAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        assertThat(out.toString()).contains(ERROR_MESSAGE);
    }

    @DisplayName("구입 금액이 1,000원 단위로 나누어 떨어지지 않으면 에러가 발생한다.")
    @Test
    void inputAmount1000unit() {
        String input = "2500";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Counter counter = new Counter();
        try {
            counter.inputAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        assertThat(out.toString()).contains(ERROR_MESSAGE);
    }
}
