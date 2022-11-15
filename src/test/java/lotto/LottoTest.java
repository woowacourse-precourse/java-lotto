package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 위에 테스트케이스는 혹시 몰라서 안건드렸습니다.
    private static final String EXCEPTION_MESSAGE_NO_SIX_NUMBER = "[ERROR] 복권번호는 %d자리 숫자입니다.";
    private static final String EXCEPTION_MESSAGE_OVER_NUMBER_RANGE = "[ERROR] 로또 번호는 %d부터 %d 사이의 숫자여야 합니다.";
    private static final int LOTTO_LOWER_NUMBER = 1;
    private static final int LOTTO_UPPER_NUMBER = 45;
    private static final int LOTTO_DIGIT = 6;
    @DisplayName("정상적으로 로또 번호가 생성된다")
    @ParameterizedTest
    @CsvSource({"1, 17, 9, 23, 6, 43", "44, 43, 10, 20, 30, 45"})
    void createLotto(int number1, int number2, int number3, int number4, int number5, int number6) {
        boolean result = true;
        try {
            new Lotto(List.of(number1, number2, number3, number4, number5, number6));
        } catch (IllegalArgumentException e) {
            result = false;
        }
        assertThat(true).isEqualTo(result);
    }

    @DisplayName("로또 번호의 개수가 6개가 아니면 예외가 발생한다")
    @Test
    void createLottoBySmallSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(EXCEPTION_MESSAGE_NO_SIX_NUMBER, LOTTO_DIGIT));
    }

    @DisplayName("로또 번호에 잘못된 범위의 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"1, 2, 3, 46, 5, 6", "1, 2, 3, 0, 5, 6"})
    void createLottoByOverRangeNumber(int number1, int number2, int number3, int number4, int number5, int number6) {
        assertThatThrownBy(() -> new Lotto(List.of(number1, number2, number3, number4, number5, number6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(EXCEPTION_MESSAGE_OVER_NUMBER_RANGE,
                        LOTTO_LOWER_NUMBER, LOTTO_UPPER_NUMBER));
    }

    @DisplayName("containNumber 함수가 정상적으로 작동한다")
    @ParameterizedTest
    @CsvSource({"1, 17, 9, 23, 6, 43, 2, false", "44, 43, 10, 20, 30, 45, 10, true"})
    void runContainNumber(int number1, int number2, int number3,
                          int number4, int number5, int number6,
                          int compareNumber, boolean result) {
        Lotto lotto = new Lotto(List.of(number1, number2, number3, number4, number5, number6));
        boolean hasNumber = lotto.containNumber(compareNumber);
        assertThat(result).isEqualTo(hasNumber);
    }

    @DisplayName("countMatchingNumber 함수가 정상적으로 작동한다")
    @ParameterizedTest
    @CsvSource({"1, 2, 3, 4, 5, 6, 11, 10, 9, 8, 7, 1, 1",
            "1, 2, 3, 4, 5, 6, 11, 2, 9, 8, 7, 1, 2",
            "1, 2, 3, 4, 5, 6, 11, 2, 9, 3, 7, 1, 3",
            "1, 2, 3, 4, 5, 6, 4, 2, 9, 3, 7, 1, 4",
            "1, 2, 3, 4, 5, 6, 4, 2, 9, 3, 5, 1, 5",
            "1, 2, 3, 4, 5, 6, 4, 2, 6, 3, 5, 1, 6"})
    void runCountMatchingNumber(int number1, int number2, int number3,
                                int number4, int number5, int number6,
                                int compareNumber1, int compareNumber2, int compareNumber3,
                                int compareNumber4, int compareNumber5, int compareNumber6,
                                int result) {
        Lotto lotto = new Lotto(List.of(number1, number2, number3, number4, number5, number6));
        int countNumber = lotto.countMatchingNumber(new Lotto(List.of(compareNumber1, compareNumber2, compareNumber3,
                compareNumber4, compareNumber5, compareNumber6)));
        assertThat(result).isEqualTo(countNumber);
    }
}
