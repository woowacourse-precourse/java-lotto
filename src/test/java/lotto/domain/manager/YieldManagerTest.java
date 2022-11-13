package lotto.domain.manager;

import lotto.domain.Award;
import lotto.util.Util;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class YieldManagerTest {

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    @DisplayName("makeYield 메소드 테스트")
    class MakeYield {
        @ParameterizedTest
        @MethodSource("parameterProvider")
        void AWARD_리스트에_따라_수익률을_잘_반환하는지_테스트한다(List<Award> awards, float expected) {
            assertThat(YieldManager.makeYield(awards)).isEqualTo(expected);
        }

        private Stream<Arguments> parameterProvider() {
            return Stream.of(
                    Arguments.of(List.of(Award.FIVE_BONUS), 30_000_00f),
                    Arguments.of(List.of(Award.THREE, Award.THREE), 500.0f),
                    Arguments.of(List.of(Award.ZERO, Award.ZERO, Award.ZERO), 0.0f)
            );
        }
    }
}