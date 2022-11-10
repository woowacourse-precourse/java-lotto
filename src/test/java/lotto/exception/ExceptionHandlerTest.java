package lotto.exception;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import lotto.constant.LottoStatistic;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExceptionHandlerTest {
    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    protected final void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    protected final void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());
    }

    protected final String output() {
        return captor.toString().trim();
    }

    @Test
    @DisplayName("구매 금액이 1000으로 나누어 떨어지지 않으면 에러 메시지를 출력하고 예외 처리 한다.")
    void throwExceptionForNotMultipleOf1000() {
        assertThatThrownBy(() -> ExceptionHandler.isMultipleOf(1300, LottoStatistic.LOTTO_PRICE.getValue()))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(output()).isEqualTo("[ERROR] 구매 금액은 1000원으로 나누어 떨어져야 합니다.");
    }
}
