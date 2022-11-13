package lotto.domain;

import lotto.Model.Lotto;
import lotto.Model.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoCheckerTest {
    LottoChecker lottoChecker;

    @BeforeEach
    void setUp() {
        lottoChecker = new LottoChecker();
    }

    @Test
    void 수익률_테스트() {
        assertThat(lottoChecker.profitRate(8000, 5000)).isEqualTo(62.5);
    }

    @Test
    void 당첨_개수_비교() {
        Lotto userLotto = new Lotto(new ArrayList<>(List.of(1,2,3,4,5,6)));
        WinningLotto winningLotto = new WinningLotto(new Lotto(new ArrayList<>(List.of(3,4,5,6,7,8))), 10);
        assertThat(lottoChecker.lottoCompare(userLotto,winningLotto)).isEqualTo(4);
    }

}