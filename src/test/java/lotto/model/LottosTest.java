package lotto.model;

import org.junit.jupiter.api.Test;
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

    @ParameterizedTest(name = "구매한 로또의 총 상금은 {1}원")
    @MethodSource("lottosAndWinningAmount")
    void 구매한_로또들의_총_상금을_구하는_기능(Lottos lottos, int expected) {
        assertThat(lottos.calculateWinningAmount(winningNumbers)).isEqualTo(expected);
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

    @Test
    void 로또들_당첨정보_만드는_기능() {
        Lottos lottos = new Lottos(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6))
                , new Lotto(List.of(1, 2, 3, 4, 5, 6))
                , new Lotto(List.of(1, 2, 3, 7, 5, 6))
                , new Lotto(List.of(11, 22, 3, 4, 5, 6))
                , new Lotto(List.of(11, 2, 3, 4, 45, 36))
                , new Lotto(List.of(1, 22, 33, 44, 5, 6))
                , new Lotto(List.of(10, 22, 33, 4, 5, 7))
        ));

        LottosResult expected = new LottosResult();
        expected.winLotto(LottoPrize.FIRST);
        expected.winLotto(LottoPrize.FIRST);
        expected.winLotto(LottoPrize.SECOND);
        expected.winLotto(LottoPrize.FOURTH);
        expected.winLotto(LottoPrize.FIFTH);
        expected.winLotto(LottoPrize.FIFTH);
        expected.winLotto(LottoPrize.LOSE);
        
        assertThat(lottos.getLottosResult(winningNumbers)).isEqualTo(expected);
    }
}