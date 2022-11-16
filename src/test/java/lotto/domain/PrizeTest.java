package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {
    static Stream<Arguments> generateTestData() {
        return Stream.of(
                Arguments.of(0, false, Prize.NOTHING),
                Arguments.of(1, false, Prize.NOTHING),
                Arguments.of(2, false, Prize.NOTHING),
                Arguments.of(3, false, Prize.FIFTH),
                Arguments.of(4, false, Prize.FOURTH),
                Arguments.of(5, false, Prize.THIRD),
                Arguments.of(5, true, Prize.SECOND),
                Arguments.of(6, false, Prize.FIRST)
        );
    }

    @DisplayName("당첨 번호와 일치하는 수의 개수, 보너스 번호 일치 여부로 등수를 알아낸다.")
    @ParameterizedTest(name = "일치하는 번호의 수 - {0}, 보너스 번호 일치 여부 - {1}")
    @MethodSource("generateTestData")
    void getPrize(int matchedCount, boolean bonusNumberMatched, Prize expected) {
        assertThat(Prize.getPrize(matchedCount, bonusNumberMatched)).isEqualTo(expected);
    }
}
