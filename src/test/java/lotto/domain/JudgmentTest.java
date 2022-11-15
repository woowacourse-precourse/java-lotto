package lotto.domain;

import lotto.domain.impl.JudgmentImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class JudgmentTest {

    private final Judgment judgment = new JudgmentImpl();

    private static final List<Integer> PRICE_NUMBERS = Arrays.asList(1, 2, 3, 4, 5, 6);
    private static final int BONUS_NUMBER = 7;

    @ParameterizedTest
    @DisplayName("사용자의 번호와 당첨 번호가 일치하는 번호의 갯수를 반환한다.")
    @CsvSource({"1,2,3,4,5,6,6", "1,2,3,4,5,36,5", "1,2,3,4,35,36,4", "1,2,3,34,35,36,3", "1,2,33,34,35,36,2", "1,32,33,34,35,36,1", "31,32,33,34,35,36,0"})
    void correctCount(int number1, int number2, int number3, int number4, int number5, int number6, int expected) {
        List<Integer> userNumbers = Arrays.asList(number1, number2, number3, number4, number5, number6);
        int actual = judgment.correctCount(userNumbers, PRICE_NUMBERS);

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("보너스 번호가 일치 여부를 참, 거짓으로 반환한다.")
    @CsvSource({"1,2,3,4,5,7,true", "1,2,3,4,5,6,false"})
    void hasBonusNumber(int number1, int number2, int number3, int number4, int number5, int number6, boolean expected) {
        List<Integer> userNumbers = Arrays.asList(number1, number2, number3, number4, number5, number6);

        boolean actual = judgment.hasBonusNumber(userNumbers, BONUS_NUMBER);

        assertThat(actual).isEqualTo(expected);
    }
}