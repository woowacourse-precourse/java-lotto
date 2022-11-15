package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserInputCheckTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStream() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
        output.reset();
    }

    @Test
    void 문자열의_입력값이_숫자_인지_체크() {
        UserInputCheck.purchaseAmountCheck("1200K");
        assertThat(output.toString()).contains("[ERROR] 숫자가 아닌 값이 포함되어 있습니다.");
    }

    @Test
    void 입력값이_천원보다_작은지_체크() {
        UserInputCheck.purchaseAmountCheck("123");
        assertThat(output.toString()).contains("[ERROR] 가격이 천원보다 작습니다.");
    }

    @Test
    void 입력값이_천원으로_나누어_떨어지는지_체크() {
        UserInputCheck.purchaseAmountCheck("1201");
        assertThat(output.toString()).contains("[ERROR] 천원으로 나누어 떨어지지 않습니다.");
    }

    @Test
    void 입력값의_길이가_6인지_체크() {
        UserInputCheck.winningNumberCheck("1,2,3,4,5");
        assertThat(output.toString()).contains("[ERROR] 길이가 6이 아닙니다.");
    }

    @Test
    void 리스트_자료형의_입력값이_숫자_인지_체크() {
        UserInputCheck.winningNumberCheck("1,2,3,4,5,#");
        assertThat(output.toString()).contains("[ERROR] 숫자가 아닌 값이 포함되어 있습니다.");
    }

    @Test
    void 입력값의_범위가_유효한지_체크() {
        UserInputCheck.winningNumberCheck("1,2,3,4,5,49");
        assertThat(output.toString()).contains("[ERROR] 유효한 범위가 아닙니다.");
    }
}