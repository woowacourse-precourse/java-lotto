package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningNumber;
import lotto.util.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class LottosTest {
    @DisplayName("로또 개수가 0개 이하면 예외가 발생한다")
    @Test
    void generateLottosByNoLotto() {
        assertThatThrownBy(() -> new Lottos(List.of()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 개수가 1개 이상이면 예외가 발생하지 않는다")
    @Test
    void generateLottos() {
        assertThatNoException()
                .isThrownBy(() -> new Lottos(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)))));
    }

    @DisplayName("로또 개수를 가져온다")
    @Test
    void getLottoCount() {
        Lottos lottos = new Lottos(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
        int result = 1;

        assertThat(lottos.getLottoCount()).isEqualTo(result);
    }

    @DisplayName("로또를 생성하면 로또 번호가 들어간다")
    @Test
    void getLottoNumbers() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lottos lottos = new Lottos(List.of(lotto));

        assertThat(lotto).isIn(lottos.getLottos());
    }

    @DisplayName("상금을 입력하면 구매한 로또 가격에 대한 비율을 반환한다")
    @Test
    void getRateOfReturn() {
        Lottos lottos = new Lottos(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
        double result = 500.0;

        double rateOfReturn = lottos.getRateOfReturn(5000);

        assertThat(rateOfReturn).isEqualTo(result);
    }

    @DisplayName("각 등수 횟수 맵을 입력하면 당첨된 등수의 상금들을 총합하여 반환한다")
    @Test
    void getTotalPrizeMoney() {
        Lottos lottos = new Lottos(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
        Map<LottoRank, Integer> rankCount = Map.of(LottoRank.THIRD_PLACE, 3, LottoRank.FOURTH_PLACE, 1);
        int result = 4_550_000;

        long totalPrizeMoney = lottos.getTotalPrizeMoney(rankCount);

        assertThat(totalPrizeMoney).isEqualTo(result);
    }

    @DisplayName("당첨 번호를 입력하면 해당 로또들에 대한 등수들을 가져온다")
    @Test
    void getRankCounts() {
        Lottos lottos = new Lottos(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(1, 2, 3, 4, 40, 45))));
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 8), 6);
        Map<LottoRank, Integer> result = Map.of(LottoRank.SECOND_PLACE, 1, LottoRank.FOURTH_PLACE, 1);

        Map<LottoRank, Integer> rankCounts = lottos.getRankCounts(winningNumber);

        assertThat(rankCounts).isEqualTo(result);
    }
}
