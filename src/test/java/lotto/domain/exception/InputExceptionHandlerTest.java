package lotto.domain.exception;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.InputExceptionHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("사용자 입력 관련 예외 처리 테스트")
public class InputExceptionHandlerTest {

    @Test
    @DisplayName("공통예외 - 입력이 비어있는 경우, 예외가 발생한다.")
    void handleEmptyInputExceptionTest() {
        String invalidInput = "";
        String validInput = "abc";

        LottoExceptionHandler emptyInputExceptionHandler = new LottoExceptionHandler() {
            @Override
            public void handleException(String input) {
                InputExceptionHandler.handleEmptyInputException(input);
            }
        };
        exceptionTest(emptyInputExceptionHandler, invalidInput, validInput);
    }

    @Test
    @DisplayName("공통예외 - 입력에 숫자와 쉼표 외 다른 문자가 포함되는 경우, 예외가 발생한다.")
    void handleNotNumberOrCommaExceptionTest() {
        String invalidInput = "1.23dfe";
        String validInput = "1,2,";

        LottoExceptionHandler notNumberOrCommaExceptionHandler = new LottoExceptionHandler() {
            @Override
            public void handleException(String input) {
                InputExceptionHandler.handleNotNumberOrCommaException(input);
            }
        };
        exceptionTest(notNumberOrCommaExceptionHandler, invalidInput, validInput);
    }

    @Test
    @DisplayName("당첨번호 - 쉼표로 구분되는 형식을 지키지 않으면 예외가 발생한다.")
    void handleWinningNumbersInputFormatException() {
        String invalidInput = "1234";
        String validInput = "1,2,3";

        LottoExceptionHandler winNumbersFormatExceptionHandler = new LottoExceptionHandler() {
            @Override
            public void handleException(String input) {
                InputExceptionHandler.handleWinningNumbersInputFormatException(input);
            }
        };
        exceptionTest(winNumbersFormatExceptionHandler, invalidInput, validInput);
    }

    @Test
    @DisplayName("구입금액 및 보너스 번호 - 하나의 숫자 외 다른 문자열로 입력되는 경우 예외가 발생한다.")
    void handleNotOneNumberException() {
        String invalidInput = "12 23";
        String validInput = "33";

        LottoExceptionHandler notOneNumberExceptionHandler = new LottoExceptionHandler() {
            @Override
            public void handleException(String input) {
                InputExceptionHandler.handleNotOneNumberException(input);
            }
        };
        exceptionTest(notOneNumberExceptionHandler, invalidInput, validInput);
    }

    void exceptionTest(LottoExceptionHandler inputException, String invalid, String valid) {
        assertThatThrownBy(() -> {
            inputException.handleException(invalid);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");

        assertThatCode(() -> {
            inputException.handleException(valid);
        })
                .doesNotThrowAnyException();
    }
}
