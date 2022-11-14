package lotto.domain;


import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoMachineTest {

    @DisplayName("번호를 비교하여 등수를 반환한다")
    @ParameterizedTest(name = "번호를 비교하여 {1}을 반환한다")
    @MethodSource("lottoTestArgs")
    void matchPrizeTest(List<Integer> numbers, LottoPrize lottoPrize) {
        LottoMachine lottoMachine = new LottoMachine(new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7));
        LottoPrize result = lottoMachine.compareWinningLotto(new Lotto(numbers));

        assertThat(result).isEqualTo(lottoPrize);
    }

    private static Stream<Arguments> lottoTestArgs() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), LottoPrize.FIRST),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), LottoPrize.SECOND),
                Arguments.of(List.of(1, 2, 3, 4, 5, 45), LottoPrize.THIRD),
                Arguments.of(List.of(1, 2, 3, 4, 44, 45), LottoPrize.FOURTH),
                Arguments.of(List.of(1, 2, 3, 43, 44, 45), LottoPrize.FIFTH),
                Arguments.of(List.of(1, 2, 42, 43, 44, 45), LottoPrize.NONE)
        );
    }
}