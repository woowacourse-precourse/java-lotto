package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class WinningNumberTest {

    @DisplayName("로또 번호 입력시 6자리가 아닐 경우")
    @Test
    void notSixLengthNumber() {
        WinningNumber winningNumber = new WinningNumber();
        InputStream inputStream = System.in;

        ByteArrayInputStream input1 = new ByteArrayInputStream("1,2,3,4,5,6,7".getBytes());
        System.setIn(input1);
        Assertions.assertThatThrownBy(() -> {
            winningNumber.readWinningNumbers();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 입력시 숫자가 아닐 경우")
    @Test
    void notNumeric() {
        WinningNumber winningNumber = new WinningNumber();
        InputStream inputStream = System.in;

        ByteArrayInputStream input1 = new ByteArrayInputStream("s,2,3,4,5,6".getBytes());
        System.setIn(input1);
        Assertions.assertThatThrownBy(() -> {
            winningNumber.readWinningNumbers();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 입력시 1 ~ 45 숫자가 아닐 경우")
    @Test
    void notInRangeNumber() {
        WinningNumber winningNumber = new WinningNumber();
        InputStream inputStream = System.in;

        ByteArrayInputStream input1 = new ByteArrayInputStream("1,2,3,4,5,46".getBytes());
        System.setIn(input1);
        Assertions.assertThatThrownBy(() -> {
            winningNumber.readWinningNumbers();
        }).isInstanceOf(IllegalArgumentException.class);
    }


}
