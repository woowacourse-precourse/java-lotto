package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {

    @DisplayName("숫자가 아닌 당첨 번호 입력 시 예외가 발생한다.")
    @Test
    void createWinningNumberWithNotNumber() {
        assertThatThrownBy(() -> {

            String winningNumberInput = "a,b,1,2,3,4";

            InputStream in = new ByteArrayInputStream(winningNumberInput.getBytes());
            System.setIn(in);

            new WinningNumber().createWinningNumbers();

        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("6자리 숫자가 아닌 당첨 번호 입력 시 예외가 발생한다.")
    @Test
    void createWinningNumberWithTooShortLength() {
        assertThatThrownBy(() -> {

            String winningNumberInput = "1,2,3,4";

            InputStream in = new ByteArrayInputStream(winningNumberInput.getBytes());
            System.setIn(in);

            new WinningNumber().createWinningNumbers();

        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1 ~ 45 사이 숫자가 아닌 당첨 번호 입력 시 예외가 발생한다.")
    @Test
    void createWinningNumberWithWrongRange() {
        assertThatThrownBy(() -> {

            String winningNumberInput = "0,46,1,2,3,4";

            InputStream in = new ByteArrayInputStream(winningNumberInput.getBytes());
            System.setIn(in);

            new WinningNumber().createWinningNumbers();

        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 당첨 번호 입력 시 예외가 발생한다.")
    @Test
    void createWinningNumberWithDuplicatedNumber() {
        assertThatThrownBy(() -> {

            String winningNumberInput = "1,1,2,3,4,5";

            InputStream in = new ByteArrayInputStream(winningNumberInput.getBytes());
            System.setIn(in);

            new WinningNumber().createWinningNumbers();

        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 보너스 번호 입력 시 예외가 발생한다.")
    @Test
    void createBonusNumberWithNotNumber() {
        assertThatThrownBy(() -> {

            String winningNumberInput = "a";

            InputStream in = new ByteArrayInputStream(winningNumberInput.getBytes());
            System.setIn(in);

            new WinningNumber().createBonusNumber();

        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1자리 숫자가 아닌 보너스 번호 입력 시 예외가 발생한다.")
    @Test
    void createBonusNumberWithTooLongNumber() {
        assertThatThrownBy(() -> {

            String winningNumberInput = "1,2,3";

            InputStream in = new ByteArrayInputStream(winningNumberInput.getBytes());
            System.setIn(in);

            new WinningNumber().createBonusNumber();

        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1 ~ 45 사이 숫자가 아닌 보너스 번호 입력 시 예외가 발생한다.")
    @Test
    void createBonusNumberWithWrongRange() {
        assertThatThrownBy(() -> {

            String winningNumberInput = "46";

            InputStream in = new ByteArrayInputStream(winningNumberInput.getBytes());
            System.setIn(in);

            new WinningNumber().createBonusNumber();

        }).isInstanceOf(IllegalArgumentException.class);
    }
}
