package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class JudgementTest {
    private static final List<Integer> NUMBERS = Arrays.asList(1, 2, 3, 4, 5, 6);
    private Judgement judgement;

    @BeforeEach
    void setUp() {
        judgement = new Judgement();
    }

    @ParameterizedTest
    @CsvSource({"1, 2, 3, 4, 5, 6, 6", "11, 2, 3, 4, 5, 6, 5", "11, 12, 3, 4, 5, 6, 4", "11, 12, 13, 4, 5, 6, 3",
            "11, 12, 13, 14, 5, 6, 2", "11, 12, 13, 14, 15, 6, 1", "11, 12, 13, 14, 15, 16, 0"})
    void 같은_숫자_세기_테스트(int number1, int number2, int number3, int number4, int number5, int number6, int expected) {
        int input = judgement.correctCount(Arrays.asList(number1, number2, number3, number4, number5, number6),
                NUMBERS);
        assertThat(input).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"10, false", "1, true"})
    void 보너스_숫자_포함_테스트(int bonusNumber, boolean include) {
        assertThat(judgement.hasBonusNumbers(bonusNumber, NUMBERS)).isEqualTo(include);
    }
}