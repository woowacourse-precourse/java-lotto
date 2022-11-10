package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    @Test
    @DisplayName("각 로또 당 몇 등인지 구하기")
    void parseRanks() {
        Lotto secondLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto thirdLotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Lottos lottos = new Lottos(List.of(LottoTest.FROM_ONE_TO_SIX, secondLotto, thirdLotto));
        
        final WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(LottoTest.FROM_ONE_TO_SIX, 7);
        final List<LottoRank> expectedRanks = List.of(LottoRank.FIRST, LottoRank.SECOND, LottoRank.THIRD);
        
        assertThat(lottos.parseRanks(winningLottoNumbers)).isEqualTo(expectedRanks);
    }
}
