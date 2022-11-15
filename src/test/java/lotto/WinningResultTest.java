package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Rank;
import lotto.domain.WinningResult;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningLotto;
import lotto.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinningResultTest {

    LottoService lottoService = new LottoService();

    @Nested
    class CreateWinningResult {

        @DisplayName("당첨 번호와 로또들을 비교했을 때")
        @Test
        void winningLottoMatchAll() {
            WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
            List<Lotto> lottos = new ArrayList<>();
            lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6))); // FIRST
            lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7))); // SECOND
            lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 8))); // THIRD
            lottos.add(new Lotto(List.of(1, 2, 3, 4, 7, 8))); // FOURTH with bonus number
            lottos.add(new Lotto(List.of(1, 2, 3, 4, 8, 9))); // FOURTH
            lottos.add(new Lotto(List.of(1, 2, 3, 8, 9, 10))); // FIFTH
            lottos.add(new Lotto(List.of(1, 2, 8, 9, 10, 11))); // MISS
            lottos.add(new Lotto(List.of(1, 8, 9, 10, 11, 12))); // MISS
            lottos.add(new Lotto(List.of(8, 9, 10, 11, 12, 13))); // MISS

            WinningResult winningResult = lottoService.makeWinningResult(winningLotto, lottos);
            assertEquals(winningResult.getRankCount().get(Rank.FIRST), 1);
            assertEquals(winningResult.getRankCount().get(Rank.SECOND), 1);
            assertEquals(winningResult.getRankCount().get(Rank.THIRD), 1);
            assertEquals(winningResult.getRankCount().get(Rank.FOURTH), 2);
            assertEquals(winningResult.getRankCount().get(Rank.FIFTH), 1);
            assertEquals(winningResult.getRankCount().get(Rank.MISS), 3);
            assertEquals(winningResult.getSpendMoney(), 9000);
            assertEquals(winningResult.getWinningMoney(), 2_031_605_000);
        }
    }
}
