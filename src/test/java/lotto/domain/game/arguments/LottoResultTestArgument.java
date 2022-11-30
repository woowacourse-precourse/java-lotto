package lotto.domain.game.arguments;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.game.LottoRanking;
import lotto.helper.utils.LottoRankingUtils;
import org.junit.jupiter.params.provider.Arguments;

public class LottoResultTestArgument {

    private LottoResultTestArgument() {
    }

    static Stream<Arguments> lottoResultConstructorTestArgument() {
        return Stream.of(
                Arguments.of(
                        List.of(LottoRanking.FIFTH),
                        LottoRankingUtils.createArgumentMap(List.of(0, 0, 0, 0, 1)), "50.0"),
                Arguments.of(
                        List.of(LottoRanking.FIRST, LottoRanking.FOURTH, LottoRanking.FIFTH),
                        LottoRankingUtils.createArgumentMap(List.of(1, 0, 0, 1, 1)), "20000550.0"));
    }
}
