package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static lotto.domain.LottoWin.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoWinTest {
    @ParameterizedTest(name = "[{index}] sameNumberCount = {0}, sameBonusNumberCount = {1}, LottoWin = {2}")
    @MethodSource("whenFindLottoWinThenSuccessDummy")
    @DisplayName("로또 당첨 순위를 맞힌 번호 숫자와 보너스 숫자를 이용한 검색 성공")
    void whenFindLottoWinThenSuccessTest(int sameNumberCount, int sameBonusNumberCount, LottoWin lottoWin) {
        LottoWin findLottoWin = LottoWin.of(sameNumberCount, sameBonusNumberCount);
        assertThat(findLottoWin).isEqualTo(lottoWin);
    }

    @ParameterizedTest(name = "[{index}] LottoWin = {0}, prize = {1}")
    @MethodSource("whenFindLottoWinPrizeThenSuccessDummy")
    @DisplayName("로또 당첨 순위별 상금 매치 성공")
    void whenFindLottoWinPrizeThenSuccessTest(LottoWin lottoWin, int prize) {
        assertThat(lottoWin.getPrize()).isEqualTo(prize);
    }

    static Stream<Arguments> whenFindLottoWinThenSuccessDummy() {
        return Stream.of(
                Arguments.arguments(0, 0, LOSER),
                Arguments.arguments(0, 1, LOSER),
                Arguments.arguments(1, 0, LOSER),
                Arguments.arguments(2, 0, LOSER),
                Arguments.arguments(1, 1, LOSER),
                Arguments.arguments(2, 1, LOSER),
                Arguments.arguments(3, 0, FIFTH_PRICE_WINNER),
                Arguments.arguments(4, 0, FOURTH_PRICE_WINNER),
                Arguments.arguments(5, 0, THIRD_PRICE_WINNER),
                Arguments.arguments(5, 1, SECOND_PRICE_WINNER),
                Arguments.arguments(6, 0, FIRST_PRICE_WINNER)
        );
    }

    static Stream<Arguments> whenFindLottoWinPrizeThenSuccessDummy() {
        return Stream.of(
                Arguments.arguments(LOSER, 0),
                Arguments.arguments(FIFTH_PRICE_WINNER, 5_000),
                Arguments.arguments(FOURTH_PRICE_WINNER, 50_000),
                Arguments.arguments(THIRD_PRICE_WINNER, 1_500_000),
                Arguments.arguments(SECOND_PRICE_WINNER, 30_000_000),
                Arguments.arguments(FIRST_PRICE_WINNER, 2_000_000_000)
        );
    }
}