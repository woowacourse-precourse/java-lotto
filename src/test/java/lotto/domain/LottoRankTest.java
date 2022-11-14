package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoRankTest {
    private static Stream<Arguments> provideLottoRankAndRankMoney() {
        return Stream.of(
                Arguments.of(LottoRank.ONE, 2000000000),
                Arguments.of(LottoRank.TWO, 30000000),
                Arguments.of(LottoRank.THREE, 1500000),
                Arguments.of(LottoRank.FOUR, 50000),
                Arguments.of(LottoRank.FIVE, 5000)
        );
    }

    private static Stream<Arguments> provideLottoRankAndCorrectCountAndBonusNumber() {
        return Stream.of(
                Arguments.of(LottoRank.ONE, 6, 6),
                Arguments.of(LottoRank.TWO, 5, 6),
                Arguments.of(LottoRank.THREE, 5, 7),
                Arguments.of(LottoRank.FOUR, 4, 6),
                Arguments.of(LottoRank.FIVE, 3, 6)
        );
    }

    @ParameterizedTest
    @MethodSource("provideLottoRankAndRankMoney")
    void amountPaidByLottoRank(LottoRank rank, int money) {
        assertThat(rank.getMoney()).isEqualTo(money);
    }

    @ParameterizedTest
    @MethodSource("provideLottoRankAndCorrectCountAndBonusNumber")
    void getLottoRankByCorrectCount(LottoRank rank, int correctCount, int bonusNumber) {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(rank).isEqualTo(LottoRank.getLottoRankByCorrectNumberCount(lotto, bonusNumber, correctCount));
    }
}