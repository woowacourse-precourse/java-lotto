package lotto.domain.number.arguments;

import java.util.stream.Stream;
import lotto.domain.game.LottoRanking;
import org.junit.jupiter.params.provider.Arguments;

public final class LottoTestArgument {

    private LottoTestArgument() {
    }

    static Stream<Arguments> calculateLottoRankingArgument() {
        return Stream.of(
                Arguments.of("11,12,13,14,15,16", 1, LottoRanking.NOTHING),
                Arguments.of("1,2,3,11,12,13", 1, LottoRanking.FIFTH),
                Arguments.of("1,2,3,4,11,12", 1, LottoRanking.FOURTH),
                Arguments.of("1,2,3,4,5,12", 21, LottoRanking.THIRD),
                Arguments.of("1,2,3,4,5,12", 1, LottoRanking.SECOND),
                Arguments.of("1,2,3,4,5,6", 1, LottoRanking.FIRST)
        );
    }
}
