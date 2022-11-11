package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import lotto.util.RandomNumGenerator;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RandomNumGeneratorTest {
    @ParameterizedTest(name = "makeUniqueRandomList 테스트")
    @MethodSource("parameterProvider")
    void 랜덤값_잘_반환되는지_테스트(List<Integer> expected1, List<Integer> expected2, List<Integer> expected3) {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    assertThat(RandomNumGenerator.makeUniqueRandomList()).isEqualTo(expected1);
                    assertThat(RandomNumGenerator.makeUniqueRandomList()).isEqualTo(expected2);
                    assertThat(RandomNumGenerator.makeUniqueRandomList()).isEqualTo(expected3);
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44)
        );
    }

    private Stream<Arguments> parameterProvider() {
        return Stream.of(
                Arguments.of(List.of(8, 21, 23, 41, 42, 43),
                        List.of(3, 5, 11, 16, 32, 38),
                        List.of(7, 11, 16, 35, 36, 44))
        );
    }
}
