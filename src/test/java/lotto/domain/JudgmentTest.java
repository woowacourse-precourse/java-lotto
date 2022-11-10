package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;

class JudgmentTest {

    private static final List<Integer> ANSWER = List.of(8, 21, 23, 41, 42, 43);

    @DisplayName("특정 자리에 특정 숫자가 있는지 알 수 있다")
    @ParameterizedTest
    @CsvSource({"0, 8, true", "0, 4, false", "1, 21, true"})
    void isEqualPlace(int index, int number, boolean expected) {
        boolean actual = Judgment.hasPlace(ANSWER, index, number);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("컴퓨터의 수와 플레이어의 수를 비교해서 몇 개의 숫자가 일치하는 지 알 수 있다")
    @ParameterizedTest
    @CsvSource({"4, 21, 23, 41, 42, 43, 5", "4, 5, 23, 41, 42, 43, 4", "4, 5, 1, 41, 42, 43, 3",
            "4, 5, 1, 27, 42, 43, 2", "4, 5, 1, 27, 34, 43, 1", "4, 5, 1, 27, 34, 22, 0"})
    void isEqualCorrectCount(int number1, int number2, int number3, int number4, int number5,
            int number6, int expected) {
        int actual = (int) IntStream.range(0, 6)
                .filter(index -> Judgment.hasPlace(ANSWER, index,
                        Arrays.asList(number1, number2, number3, number4, number5, number6)
                                .get(index))).count();
        assertThat(actual).isEqualTo(expected);
    }

}