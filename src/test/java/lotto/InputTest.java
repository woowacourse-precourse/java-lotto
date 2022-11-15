package lotto;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import lotto.ui.Input;

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
        try {
            Input.inputAmount();
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
        try {
            Input.inputAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        assertThat(out.toString()).contains(ERROR_MESSAGE);
    }

    @DisplayName("보너스 번호가 당첨 번호 중 하나와 중복 될 경우 에러가 발생한다.")
    @Test
    void inputBonusDuplicate() {
        String input = "6";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        try {
            Input.inputBonus(lotto);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        assertThat(out.toString()).contains(ERROR_MESSAGE);
    }

    @DisplayName("보너스 번호가 1이상 45이하가 아니면 에러가 발생한다.")
    @Test
    void inputBonusOutOfRange() {
        String input = "46";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        try {
            Input.inputBonus(lotto);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        assertThat(out.toString()).contains(ERROR_MESSAGE);
    }
}
