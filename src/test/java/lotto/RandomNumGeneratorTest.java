package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class RandomNumGeneratorTest {
    @ParameterizedTest
    @MethodSource("parameterProvider")
    void 랜덤값_잘_반환되는지_테스트(List<Integer> expected) {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    assertThat(RandomNumGenerator.makeUniqueRandomList(1, 45, 6)).isEqualTo(expected);
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    private Stream<Arguments> parameterProvider() {
        return Stream.of(
                Arguments.of(List.of(8, 21, 23, 41, 42, 43)),
                Arguments.of(List.of(3, 5, 11, 16, 32, 38)),
                Arguments.of(List.of(7, 11, 16, 35, 36, 44)),
                Arguments.of(List.of(1, 8, 11, 31, 41, 42)),
                Arguments.of(List.of(13, 14, 16, 38, 42, 45)),
                Arguments.of(List.of(7, 11, 30, 40, 42, 43)),
                Arguments.of(List.of(2, 13, 22, 32, 38, 45)),
                Arguments.of(List.of(1, 3, 5, 14, 22, 45))
        );
    }
}
