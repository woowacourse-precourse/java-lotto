package lotto;

import lotto.model.WinningNumber;
import lotto.view.OutputView;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumberTest {

    static OutputView outputView;
    static OutputStream outputStream;

    @BeforeAll
    static void setup() {

        outputView = new OutputView();
    }

    void initOutputStream() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createWinningNumberByOverSize() {
        initOutputStream();
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6,7");
        assertThat(outputStream.toString()).contains("[ERROR]");
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumberByDuplicatedNumber() {
        initOutputStream();
        WinningNumber winningNumber = new WinningNumber("1,1,2,3,4,5");
        assertThat(outputStream.toString()).contains("[ERROR]");
    }

    @DisplayName("당첨 번호의 개수가 6개보다 적으면 예외가 발생한다.")
    @Test
    void createWinningNumberByUnderSize() {
        initOutputStream();
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5");
        assertThat(outputStream.toString()).contains("[ERROR]");
    }

    @DisplayName("당첨 번호의 값이 45보다 큰 값이 있으면 예외가 발생한다.")
    @Test
    void createWinningNumberByOverLimit() {
        initOutputStream();
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,46");
        assertThat(outputStream.toString()).contains("[ERROR]");
    }

    @DisplayName("당첨 번호의 값이 1보다 작은 값이 있으면 예외가 발생한다.")
    @Test
    void createWinningNumberByUnderLimit() {
        initOutputStream();
        WinningNumber winningNumber = new WinningNumber("0,2,3,4,5,6");
        assertThat(outputStream.toString()).contains("[ERROR]");
    }

    @DisplayName("당첨 번호에 규격 이외의 값이 들어가면 예외가 발생한다.")
    @Test
    void createWinningNumberByInvalidValue() {
        initOutputStream();
        WinningNumber winningNumber = new WinningNumber("이상한값");
        assertThat(outputStream.toString()).contains("[ERROR]");
    }

}
