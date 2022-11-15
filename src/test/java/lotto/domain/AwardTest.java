package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class AwardTest {

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    @DisplayName("getReward 메소드 테스트")
    class GetReward {
        @ParameterizedTest(name = "{0}가 입력으로 들어왔을 때")
        @MethodSource("parameterProvider")
        void 상금을_잘_반환하는지_테스트(Award target, int expected) {
            assertThat(target.getReward()).isEqualTo(expected);
        }

        private Stream<Arguments> parameterProvider() {
            return Stream.of(
                    Arguments.of(Award.ONE, 0),
                    Arguments.of(Award.TWO, 0),
                    Arguments.of(Award.THREE, 5_000),
                    Arguments.of(Award.FOUR, 50_000),
                    Arguments.of(Award.FIVE, 1_500_000),
                    Arguments.of(Award.FIVE_BONUS, 30_000_000),
                    Arguments.of(Award.SIX, 2_000_000_000)
            );
        }
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    @DisplayName("getByOrdinal 메소드 테스트")
    class GetByOrdinal {
        @ParameterizedTest(name = "{0}가 입력으로 들어왔을 때")
        @MethodSource("parameterProvider")
        void ordinal_값에_따라_Award객체를_잘_반환하는지_테스트(int target, Award expected) {
            assertThat(Award.getByOrdinal(target)).isEqualTo(expected);
        }

        private Stream<Arguments> parameterProvider() {
            return Stream.of(
                    Arguments.of(1, Award.ONE),
                    Arguments.of(2, Award.TWO),
                    Arguments.of(3, Award.THREE),
                    Arguments.of(4, Award.FOUR),
                    Arguments.of(5, Award.FIVE),
                    Arguments.of(6, Award.SIX)
            );
        }
    }
}