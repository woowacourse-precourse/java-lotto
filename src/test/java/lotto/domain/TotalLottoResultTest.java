package lotto.domain;

import lotto.domain.constants.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class TotalLottoResultTest {
    private final Map<LottoRank, Integer> totalCountOfRankings = new HashMap<>(Map.of(
            LottoRank.RANK_1, 0, LottoRank.RANK_2, 0,
            LottoRank.RANK_3, 0, LottoRank.RANK_4, 0,
            LottoRank.RANK_5, 2, LottoRank.RANK_LOSE, 4)
            );
    private final TotalLottoResult result = new TotalLottoResult(totalCountOfRankings);
}