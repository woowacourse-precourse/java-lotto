package lotto.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    WinningNumbers winningNumbers = new WinningNumbers(
            List.of(1, 2, 3, 4, 5, 6), 7
    );

    @ParameterizedTest(name = "총 상금은 {1}원")
    @MethodSource("lottosAndWinningAmount")
    void 구매한_복권들의_상금을_모두_더하는_기능(Lottos lottos, int winningAmount) {
        assertThat(lottos.getWinningAmount(winningNumbers)).isEqualTo(winningAmount);
    }

    static Stream<Arguments> lottosAndWinningAmount() {
        return Stream.of(
                Arguments.of(new Lottos(List.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6))
                        , new Lotto(List.of(1, 3, 7, 4, 5, 6))
                        , new Lotto(List.of(1, 12, 23, 4, 35, 7))
                )), 2_030_000_000)
                , Arguments.of(new Lottos(List.of(
                        new Lotto(List.of(1, 2, 3, 13, 5, 6))
                        , new Lotto(List.of(1, 28, 13, 4, 5, 6))
                        , new Lotto(List.of(21, 2, 3, 4, 7, 12))
                )), 1_555_000)
        );
    }

    @ParameterizedTest(name = "{1} 등수 당첨 복권 갯수는 {2}")
    @MethodSource("lottosAndPrizeAndCount")
    void 복권들_중_n등_당첨된_복권_갯수_세는_기능(Lottos lottos, Prize prize, int count) {
        assertThat(lottos.countWinningLottos(prize, winningNumbers)).isEqualTo(count);
    }

    static Stream<Arguments> lottosAndPrizeAndCount() {
        return Stream.of(
                Arguments.of(new Lottos(List.of(
                        new Lotto(List.of(1, 2, 3, 7, 8, 9))
                        , new Lotto(List.of(11, 22, 7, 4, 5, 6))
                        , new Lotto(List.of(1, 12, 23, 4, 35, 7))
                )), Prize.FIFTH, 2)
                , Arguments.of(new Lottos(List.of(
                        new Lotto(List.of(1, 2, 3, 13, 5, 7))
                        , new Lotto(List.of(11, 2, 13, 4, 5, 6))
                        , new Lotto(List.of(21, 2, 3, 4, 7, 12))
                        , new Lotto(List.of(1, 2, 3, 4, 5, 7))
                        , new Lotto(List.of(1, 2, 3, 4, 5, 6))
                )), Prize.FOURTH, 2)
        );
    }
}