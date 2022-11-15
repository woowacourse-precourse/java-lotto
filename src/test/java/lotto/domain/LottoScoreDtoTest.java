package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoScoreDtoTest {
    private static Stream<Map<LottoPrize, Integer>> generateResults() {
        return Stream.of(
                Map.of(),
                Map.of(LottoPrize.FIRST_PRIZE, 1),
                Map.of(LottoPrize.FIRST_PRIZE, 1, LottoPrize.SECOND_PRIZE, 2),
                Map.of(LottoPrize.FIRST_PRIZE, 1, LottoPrize.SECOND_PRIZE, 2, LottoPrize.THIRD_PRIZE, 3),
                Map.of(LottoPrize.FIRST_PRIZE, 1, LottoPrize.SECOND_PRIZE, 2,
                        LottoPrize.THIRD_PRIZE, 3, LottoPrize.FOURTH_PRIZE, 4)
        );
    }

    @DisplayName("LottoScoreDto 는 생성시에 결과에 빈 값이 들어오면 예외가 발생한다 ")
    @ParameterizedTest
    @NullSource
    @MethodSource("generateResults")
    void LottoScoreDto_생성자_null_예외(Map<LottoPrize, Integer> prizeCount) {
        assertThrows(IllegalArgumentException.class, () -> new LottoScoreDto(prizeCount, 3.0));
    }
}
