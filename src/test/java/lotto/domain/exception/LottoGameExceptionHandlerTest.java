package lotto.domain.exception;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import lotto.exception.LottoGameExceptionHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("게임 운영 로직 관련 예외 처리 테스트")
public class LottoGameExceptionHandlerTest {

    @Test
    @DisplayName("구입금액 - 1000원 단위가 아닐 경우 예외가 발생한다.")
    void handleAmountNotThousandsExceptionTest() {
        int invalidAmount = 1230;
        int validAmount = 30000;

        LottoExceptionHandler notThousandsExceptionHandler = new LottoExceptionHandler() {
            @Override
            public void handleException(int number) {
                LottoGameExceptionHandler.handleAmountNotThousandsException(number);
            }
        };

        exceptionTest(notThousandsExceptionHandler, invalidAmount, validAmount);
    }

    @Test
    @DisplayName("로또,당첨,보너스 - 1~45 범위를 벗어나는 숫자가 있을 경우 예외가 발생한다.")
    void handleNumberOutOfRangeExceptionTest() {
        int invalidNumber = 87;
        int validNumber = 32;

        LottoExceptionHandler outOfRangeExceptionHandler = new LottoExceptionHandler() {
            @Override
            public void handleException(int number) {
                LottoGameExceptionHandler.handleNumberOutOfRangeException(number);
            }
        };

        exceptionTest(outOfRangeExceptionHandler, invalidNumber, validNumber);
    }

    @Test
    @DisplayName("로또,당첨 - 번호 개수가 6개가 아닐 경우 예외가 발생한다.")
    void handleNotSixNumbersExceptionTest() {
        List<Integer> invalidNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7));
        List<Integer> validNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));

        LottoExceptionHandler notSixNumbersExceptionHandler = new LottoExceptionHandler() {
            @Override
            public void handleException(List<Integer> numbers) {
                LottoGameExceptionHandler.handleNotSixNumbersException(numbers);
            }
        };
        exceptionTest(notSixNumbersExceptionHandler, invalidNumbers, validNumbers);
    }

    @Test
    @DisplayName("로또,당첨 - 중복되는 번호가 있을 경우 예외가 발생한다.")
    void handleDuplicatedNumbersExceptionTest() {
        List<Integer> invalidNumbers = new ArrayList<>(List.of(1, 1, 2, 3, 4, 5));
        List<Integer> validNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));

        LottoExceptionHandler duplicatedExceptionHandler = new LottoExceptionHandler() {
            @Override
            public void handleException(List<Integer> numbers) {
                LottoGameExceptionHandler.handleDuplicatedNumbersException(numbers);
            }
        };
        exceptionTest(duplicatedExceptionHandler, invalidNumbers, validNumbers);
    }

    @Test
    @DisplayName("로또 - 오름차순으로 정렬되어 있지 않으면 예외가 발생한다.")
    void handleNotAscendingOrderExceptionTest() {
        List<Integer> invalidNumbers = new ArrayList<>(List.of(1, 4, 3, 2, 5, 6));
        List<Integer> validNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));

        LottoExceptionHandler notOrderedExceptionHandler = new LottoExceptionHandler() {
            @Override
            public void handleException(List<Integer> numbers) {
                LottoGameExceptionHandler.handleNotAscendingOrderException(numbers);
            }
        };
        exceptionTest(notOrderedExceptionHandler, invalidNumbers, validNumbers);
    }

    void exceptionTest(LottoExceptionHandler lottoExceptionHandler, int invalid, int valid) {
        assertThatThrownBy(() -> {
            lottoExceptionHandler.handleException(invalid);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");

        assertThatCode(() -> {
            lottoExceptionHandler.handleException(valid);
        })
                .doesNotThrowAnyException();
    }

    void exceptionTest(LottoExceptionHandler lottoExceptionHandler, List<Integer> invalid,
            List<Integer> valid) {
        assertThatThrownBy(() -> {
            lottoExceptionHandler.handleException(invalid);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");

        assertThatCode(() -> {
            lottoExceptionHandler.handleException(valid);
        })
                .doesNotThrowAnyException();
    }
}
