package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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

    @ParameterizedTest
    @MethodSource("provideLottoRankAndRankMoney")
    void amountPaidByLottoRank(LottoRank rank, int money) {
        assertThat(rank.getMoney()).isEqualTo(money);
    }
}