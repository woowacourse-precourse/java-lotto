package lotto.domain;

import lotto.Lotto;
import lotto.Rank;
import lotto.domain.impl.LottoServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static lotto.Rank.*;
import static org.assertj.core.api.Assertions.*;

class LottoServiceTest {

    private final LottoService lottoService = new LottoServiceImpl();
    private static final Lotto PRIZE_LOTTO = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    private static final int BONUS_NUMBER = 7;

    @Test
    @DisplayName("6개 번호가 일치하면 1등이다.")
    void lottoFirst() {
        List<Lotto> userLottos = new ArrayList<>();
        userLottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));

        Map<Rank, Integer> results = lottoService.compare(userLottos, PRIZE_LOTTO, BONUS_NUMBER);

        assertThat(results.getOrDefault(FIRST, 0)).isEqualTo(1);
    }

    @Test
    @DisplayName("5개 번호와 보너스 번호가 일치하면 2등이다.")
    void lottoSecond() {
        List<Lotto> userLottos = new ArrayList<>();
        userLottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));

        Map<Rank, Integer> results = lottoService.compare(userLottos, PRIZE_LOTTO, BONUS_NUMBER);

        assertThat(results.getOrDefault(SECOND, 0)).isEqualTo(1);
    }

    @Test
    @DisplayName("5개 번호가 일치하면 3등이다.")
    void lottoThird() {
        List<Lotto> userLottos = new ArrayList<>();
        userLottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)));

        Map<Rank, Integer> results = lottoService.compare(userLottos, PRIZE_LOTTO, BONUS_NUMBER);

        assertThat(results.getOrDefault(THIRD, 0)).isEqualTo(1);
    }

    @Test
    @DisplayName("4개 번호가 일치하면 4등이다.")
    void lottoFourth() {
        List<Lotto> userLottos = new ArrayList<>();
        userLottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8)));

        Map<Rank, Integer> results = lottoService.compare(userLottos, PRIZE_LOTTO, BONUS_NUMBER);

        assertThat(results.getOrDefault(FOURTH, 0)).isEqualTo(1);
    }

    @Test
    @DisplayName("3개 번호가 일치하면 5등이다.")
    void lottoFifth() {
        List<Lotto> userLottos = new ArrayList<>();
        userLottos.add(new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)));

        Map<Rank, Integer> results = lottoService.compare(userLottos, PRIZE_LOTTO, BONUS_NUMBER);

        assertThat(results.getOrDefault(FIFTH, 0)).isEqualTo(1);
    }

    @Test
    @DisplayName("구입 금액이 8000원이고 로또 하나가 5등이라면 수익률은 62.5%이다.")
    void calculateRate() {
        Map<Rank, Integer> results = new HashMap<>() {
            {
                put(FIFTH, 1);
            }
        };

        double rate = lottoService.calculateRate(results, 8000);

        assertThat(rate).isEqualTo(62.5);
    }
}