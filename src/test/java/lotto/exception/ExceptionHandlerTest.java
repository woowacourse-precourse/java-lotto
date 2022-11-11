package lotto.exception;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import java.util.List;
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
    @DisplayName("슷지 리스트가 주어진 사이즈랑 다른 개수의 숫자를 포함하면 에러 메시지를 출력하고 예외가 발생한다.")
    void throwExceptionForNotCorrectSize() {
        assertThatThrownBy(() -> ExceptionHandler.isListCorrectSize(List.of(1,2,3,4), 6))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(output()).isEqualTo("[ERROR] 6개의 숫자를 입력해야 합니다.");
    }

    @Test
    @DisplayName("숫자 리스트에 중복되는 숫자가 있으면 에러 메시지를 출력하고 예외가 발생한다.")
    void throwExceptionForContainingDuplicate() {
        assertThatThrownBy(() -> ExceptionHandler.doesContainDuplicate(List.of(1,2,3,4,5,5)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(output()).isEqualTo("[ERROR] 중복되지 않는 숫자를 입력해야 합니다.");
    }
    
    @Test
    @DisplayName("숫자로만 이루어진 문자열을 입력하지 않으면 에러 메시지를 출력하고 예외가 발생한다.")
    void throwExceptionForNotNumericInput() {
        assertThatThrownBy(() -> ExceptionHandler.isStringNumeric("12331ab333333"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(output()).isEqualTo("[ERROR] 숫자를 입력해야 합니다.");
    }

    @Test
    @DisplayName("구매 금액이 1000으로 나누어 떨어지지 않으면 에러 메시지를 출력하고 예외가 발생한다.")
    void throwExceptionForNotMultipleOf1000() {
        assertThatThrownBy(() -> ExceptionHandler.isMultipleOf(1300, LottoStatistic.LOTTO_PRICE.getValue()))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(output()).isEqualTo("[ERROR] 구매 금액은 1000원으로 나누어 떨어져야 합니다.");
    }

    @Test
    @DisplayName("입력 숫자가 1~45 사이의 숫자가 아니면 에러 메시지를 출력하고 예외가 발생한다.")
    void throwExceptionForNotInRangeInput() {
        assertThatThrownBy(() -> ExceptionHandler.isWithinRange(52, 1, 45))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(output()).isEqualTo("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}
