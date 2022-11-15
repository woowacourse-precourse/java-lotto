package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import lotto.util.InputUtility;
import lotto.util.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AmountTest {
    void writeConsole(String input) {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
    @Test
    void amountIsNotDigit(){
        writeConsole("D");
        assertThatThrownBy(() -> InputUtility.readLine(Type.AMOUNT.getValue()))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("amount 입력확인-0이하의 숫자입력시 오류 발생")
    @Test
    void amountIsUnderZero(){
        writeConsole("0");
        assertThatThrownBy(() -> InputUtility.readLine(Type.AMOUNT.getValue()))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("amount 입력확인-1000의 배수가 아닐경우 오류 발생")
    @Test
    void amountIsNotMultipleOfThousand(){
        writeConsole("1200");
        assertThatThrownBy(() -> InputUtility.readLine(Type.AMOUNT.getValue()))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
