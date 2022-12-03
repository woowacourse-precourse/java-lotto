package lotto.domain.number.arguments;

import java.util.stream.Stream;
import lotto.domain.game.LottoRanking;
import org.junit.jupiter.params.provider.Arguments;

public final class LottoTestArgument {

    private LottoTestArgument() {
    }

    static Stream<Arguments> lottoRankingArgument() {
        return Stream.of(
                Arguments.of("11,12,13,14,15,16", 21, LottoRanking.NOTHING),
                Arguments.of("1,2,3,11,12,13", 15, LottoRanking.FIFTH),
                Arguments.of("1,2,3,4,11,12", 13, LottoRanking.FOURTH),
                Arguments.of("1,2,3,4,5,12", 14, LottoRanking.THIRD),
                Arguments.of("1,2,3,4,5,12", 6, LottoRanking.SECOND),
                Arguments.of("1,2,3,4,5,6", 16, LottoRanking.FIRST)
        );
    }

    static Stream<Arguments> lottoRankingInvalidBonusNumberArgument() {
        return Stream.of(
            Arguments.of("1,2,3,11,12,13", 1),
            Arguments.of("1,2,3,4,11,12", 1),
            Arguments.of("1,2,3,4,5,12", 1),
            Arguments.of("1,2,3,4,5,6", 1)
        );
    }
}
