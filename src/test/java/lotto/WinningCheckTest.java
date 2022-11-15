package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoAnswer;
import lotto.enums.Ranking;
import lotto.service.WinningCheck;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WinningCheckTest {
    @DisplayName("1등이 3개가 되는지 테스트")
    @Test
    void createWinningCheckTestRank1() {
        List<Lotto> userLottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        LottoAnswer lottoAnswer = new LottoAnswer(List.of(1, 2, 3, 4, 5, 6), "7");
        WinningCheck winningCheck = new WinningCheck(userLottos, lottoAnswer);
        AssertionsForClassTypes.assertThat(winningCheck.getLottoResult().get(Ranking.rank1)).isEqualTo(3);
    }

    @DisplayName("2등 테스트")
    @Test
    void createWinningCheckTestRank2() {
        List<Lotto> userLottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        LottoAnswer lottoAnswer = new LottoAnswer(List.of(1, 2, 3, 4, 5, 10), "6");
        WinningCheck winningCheck = new WinningCheck(userLottos, lottoAnswer);
        AssertionsForClassTypes.assertThat(winningCheck.getLottoResult().get(Ranking.rank2)).isEqualTo(3);
    }
}
