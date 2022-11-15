package lotto.domain.argument;

import java.util.stream.Stream;
import lotto.mvc.util.LottoRanking;
import org.junit.jupiter.params.provider.Arguments;

public final class LottoTestArgument {

    private LottoTestArgument() {
    }

    static Stream<Arguments> calculateLottoGradeArgument() {
        return Stream.of(
                Arguments.of("11,12,13,14,15,16", 1, LottoRanking.RANKING_NOTHING),
                Arguments.of("1,2,3,11,12,13", 1, LottoRanking.RANKING_FIFTH),
                Arguments.of("1,2,3,4,11,12", 1, LottoRanking.RANKING_FOURTH),
                Arguments.of("1,2,3,4,5,12", 21, LottoRanking.RANKING_THIRD),
                Arguments.of("1,2,3,4,5,12", 1, LottoRanking.RANKING_SECOND),
                Arguments.of("1,2,3,4,5,6", 1, LottoRanking.RANKING_FIRST)
        );
    }
}
