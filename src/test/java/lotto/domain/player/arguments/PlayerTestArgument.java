package lotto.domain.player.arguments;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.game.LottoRanking;
import org.junit.jupiter.params.provider.Arguments;

public final class PlayerTestArgument {

    private PlayerTestArgument() {
    }

    static Stream<Arguments> calculateLottoRankingArgument() {
        return Stream.of(
                Arguments.of(
                        List.of(LottoRanking.FIFTH,
                                LottoRanking.FOURTH,
                                LottoRanking.THIRD), "3000"),
                Arguments.of(
                        List.of(LottoRanking.FIFTH,
                                LottoRanking.FIRST,
                                LottoRanking.THIRD,
                                LottoRanking.FIFTH,
                                LottoRanking.SECOND), "5000"));
    }
}
