package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoPrizeTest {

    @DisplayName("번호와 보너스 번호에 따라 등수를 반환한다.")
    @ParameterizedTest(name = "번호를 {2}개 맞추고 보너스 넘버가 {1}일 때 {0}이다")
    @MethodSource("lottoTestArgs")
    void lottoPrize(LottoPrize lottoPrize, boolean isMatch, int count) {
        LottoPrize prize = LottoPrize.getPrize(count, isMatch);

        assertThat(prize).isEqualTo(lottoPrize);
    }

    private static Stream<Arguments> lottoTestArgs() {
        return Stream.of(
                Arguments.of(LottoPrize.FIRST, false, 6),
                Arguments.of(LottoPrize.SECOND, true, 5),
                Arguments.of(LottoPrize.THIRD, false, 5),
                Arguments.of(LottoPrize.FOURTH, false, 4),
                Arguments.of(LottoPrize.FIFTH, false, 3),
                Arguments.of(LottoPrize.NONE, false, 0)
        );
    }
}