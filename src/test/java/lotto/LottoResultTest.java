package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.PrizeType;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    @DisplayName("당첨 번호 개수 세기 테스트")
    @Test
    void countWinningNumber() {
        Money money = new Money(55000);
        Lotto lotto = new Lotto(List.of(5, 12, 41, 23, 6, 7));
        Lottos lottos = new Lottos(List.of(lotto));
        WinningLotto winningLotto = new WinningLotto(lotto, 8);
        LottoResult lottoResult = new LottoResult(lottos, winningLotto, money);
        assertThat(lottoResult.getResult().get(PrizeType.SIX)).isEqualTo(1);
    }

    @DisplayName("2등 한개 수익률 계산 테스트")
    @Test
    void calculateProfitPercent() {
        Money money = new Money(1000);
        Lotto lotto = new Lotto(List.of(5, 12, 41, 23, 6, 7));
        Lottos lottos = new Lottos(List.of(lotto));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(4, 12, 41, 23, 6, 7)), 5);
        LottoResult lottoResult = new LottoResult(lottos, winningLotto, money);
        assertThat(lottoResult.getProfitRate()).isEqualTo((double)3000000);
    }
}