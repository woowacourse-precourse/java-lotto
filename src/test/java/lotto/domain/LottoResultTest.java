package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    LottoResult lottoResult;

    @DisplayName("당첨번호와 로또 번호가 매칭이되서 나온 등수 횟수가 저장된다.")
    @Test
    @BeforeEach
    void addMatchRankCount() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 10));
        Lotto lotto4 = new Lotto(List.of(1, 8, 13, 14, 15, 16));
        Lottos lottos = new Lottos(List.of(lotto1, lotto2, lotto3, lotto4));

        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 8;
        WinningNumbers winningNumbers = new WinningNumbers(winningLotto, bonusNumber);

        lottoResult = new LottoResult();
        lottoResult.addMatchRankCount(lottos, winningNumbers);

        assertThat(lottoResult.getLottoResult().get(Rank.FIRST)).isEqualTo(1);
        assertThat(lottoResult.getLottoResult().get(Rank.SECOND)).isEqualTo(1);
        assertThat(lottoResult.getLottoResult().get(Rank.THIRD)).isEqualTo(1);
        assertThat(lottoResult.getLottoResult().get(Rank.FOURTH)).isEqualTo(0);
        assertThat(lottoResult.getLottoResult().get(Rank.FIFTH)).isEqualTo(0);
        assertThat(lottoResult.getLottoResult().get(Rank.NONE)).isEqualTo(1);
    }

    @DisplayName("수익률을 계산한 결과가 소수점 두번째 자리에서 반올림 되어 나타난다.")
    @Test
    void getLottoYield() {
        assertThat(lottoResult.getLottoYield(new LottoPurchaseAmount(4270000)))
                .isEqualTo(47576.1);
    }
}