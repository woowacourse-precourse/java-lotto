package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class LottoReaderTest {
    @Test
    void readTest() {
        Lotto drawnLotto = new Lotto(List.of(1,2,3,4,5,6));
        int bonusNumber = 7;
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));   // 1등
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));   // 2등
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 12))); // 3등
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 12, 13)));    // 4등
        lottos.add(new Lotto(List.of(1, 2, 3, 12, 13, 14)));   // 5등
        lottos.add(new Lotto(List.of(1, 2, 11, 12, 13, 14)));   // 꽝
        lottos.add(new Lotto(List.of(1, 15, 11, 12, 13, 14)));   // 꽝
        lottos.add(new Lotto(List.of(16, 15, 11, 12, 13, 14)));   // 꽝

        LottoReader lottoReader = new LottoReader();
        List<LottoRank> lottoRanks = lottoReader.rank(lottos, drawnLotto, bonusNumber);
        List<LottoRank> answer = new ArrayList<>(List.of(
                LottoRank.FIRST, LottoRank.SECOND, LottoRank.THIRD,
                LottoRank.FORTH, LottoRank.FIFTH, LottoRank.NOTHING,
                LottoRank.NOTHING, LottoRank.NOTHING));
        assertThat(lottoRanks).isEqualTo(answer);
    }
}