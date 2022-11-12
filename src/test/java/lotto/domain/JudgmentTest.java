package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class JudgmentTest {

    private static final int LOTTO_SIZE = 6;
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
    @MethodSource("providePlayers")
    void isEqualCorrectCount(List<Integer> player, int expected) {
        int actual = (int) IntStream.range(0, LOTTO_SIZE)
                .filter(index -> Judgment.hasPlace(ANSWER, index, player.get(index))).count();
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> providePlayers() {
        return Stream.of(
                Arguments.of(Arrays.asList(8, 21, 23, 41, 42, 43), Named.of("6개 번호 일치", 6)),
                Arguments.of(Arrays.asList(4, 21, 23, 41, 42, 43), Named.of("5개 번호 일치", 5)),
                Arguments.of(Arrays.asList(4, 1, 23, 41, 42, 43), Named.of("4개 번호 일치", 4)),
                Arguments.of(Arrays.asList(4, 1, 3, 41, 42, 43), Named.of("3개 번호 일치", 3)),
                Arguments.of(Arrays.asList(4, 1, 3, 18, 42, 43), Named.of("2개 번호 일치", 2)),
                Arguments.of(Arrays.asList(4, 1, 3, 18, 7, 43), Named.of("1개 번호 일치", 1)),
                Arguments.of(Arrays.asList(4, 1, 3, 18, 7, 39), Named.of("0개 번호 일치", 0))
        );
    }

}