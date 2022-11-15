package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoGameTest {
    private static Stream<Arguments> testLotto() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(LottoNumber.lottoNumber(1),
                        LottoNumber.lottoNumber(2), LottoNumber.lottoNumber(3),
                        LottoNumber.lottoNumber(4), LottoNumber.lottoNumber(5),
                        LottoNumber.lottoNumber(6)))));
    }

    private static Stream<Arguments> testWinningNumber() {
        return Stream.of(
                Arguments.of(new WinningLotto(List.of(LottoNumber.lottoNumber(1),
                        LottoNumber.lottoNumber(2), LottoNumber.lottoNumber(3),
                        LottoNumber.lottoNumber(4), LottoNumber.lottoNumber(5),
                        LottoNumber.lottoNumber(6)), LottoNumber.lottoNumber(7))));
    }

    @ParameterizedTest
    @MethodSource("testLotto")
    @DisplayName("로또의 산 갯수와 로또 전략을 받으면 lottery를 생성한다.")
    void lotteryResult(Lotto lotto) {
        LottoGame lottoGame = new LottoGame();
        ConstantCreateStrategy lottoCreateStrategy = new ConstantCreateStrategy();

        lottoGame.createLottery(new Money(2000), lottoCreateStrategy);
        LottoResult expectedResult = new LottoResult(List.of(lotto, lotto));

        assertThat(lottoGame.lotteryResult()).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @MethodSource("testWinningNumber")
    void rankResult(WinningLotto winningLotto) {
        LottoGame lottoGame = new LottoGame();
        ConstantCreateStrategy lottoCreateStrategy = new ConstantCreateStrategy();
        lottoGame.createLottery(new Money(2000), lottoCreateStrategy);

        Map<Rank, Integer> expectedMap = new EnumMap<>(Rank.class);
        expectedMap.put(Rank.FIRST, 2);
        expectedMap.put(Rank.SECOND, 0);
        expectedMap.put(Rank.THIRD, 0);
        expectedMap.put(Rank.FOURTH, 0);
        expectedMap.put(Rank.FIFTH, 0);
        expectedMap.put(Rank.NONE, 0);

        RankResult rankResult = lottoGame.rankResult(winningLotto);

        assertEquals(rankResult.getRankResult(), expectedMap);
    }
}