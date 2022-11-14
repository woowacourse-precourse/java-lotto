package lotto.domain.argument;

import java.util.List;
import java.util.stream.Stream;
import lotto.mvc.util.LottoRanking;
import org.junit.jupiter.params.provider.Arguments;

public final class PlayerTestArgument {

    private PlayerTestArgument() {
    }

    static Stream<Arguments> calculateLottoGradeArgument() {
        return Stream.of(
                Arguments.of(
                        List.of(LottoRanking.RANKING_FIFTH,
                                LottoRanking.RANKING_FOURTH,
                                LottoRanking.RANKING_THIRD), "3000"),
                Arguments.of(
                        List.of(LottoRanking.RANKING_FIFTH,
                                LottoRanking.RANKING_FIRST,
                                LottoRanking.RANKING_THIRD,
                                LottoRanking.RANKING_FIFTH,
                                LottoRanking.RANKING_SECOND), "5000"));
    }
}
