package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class JudgmentTest {

    private static final List<Integer> ANSWER = List.of(8, 21, 23, 41, 42, 43);

    @ParameterizedTest
    @CsvSource({"0, 8, true", "0, 4, false", "1, 21, true"})
    @DisplayName("특정 자리에 특정 숫자가 있는지 알 수 있다")
    void hasPlace(int index, int number, boolean expected) {
        boolean actual = Judgment.hasPlace(ANSWER, index, number);
        assertThat(actual).isEqualTo(expected);
    }
}