package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankedLottoCounterTest {
    RankedLottoCounter calculator;
    List<Lotto> lottos;

    @BeforeEach
    void init() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        int bonus = 7;
        WinningLotto winningLotto = new WinningLotto(lotto, bonus);
        calculator = new RankedLottoCounter(winningLotto);


        Lotto lotto1 = new Lotto(List.of(8, 21, 23, 41, 42, 43));
        Lotto lotto2 = new Lotto(List.of(3, 5, 11, 16, 32, 38));
        Lotto lotto3 = new Lotto(List.of(7, 11, 16, 35, 36, 44));
        Lotto lotto4 = new Lotto(List.of(1, 8, 11, 31, 41, 42));
        Lotto lotto5 = new Lotto(List.of(13, 14, 16, 38, 42, 45));
        Lotto lotto6 = new Lotto(List.of(7, 11, 30, 40, 42, 43));
        Lotto lotto7 = new Lotto(List.of(2, 13, 22, 32, 38, 45));
        Lotto lotto8 = new Lotto(List.of(1, 3, 5, 14, 22, 45));
        lottos = new ArrayList<>(List.of(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6, lotto7, lotto8));
    }

    @DisplayName("순위에 따라 로또 세기")
    @Test
    void countRankedLottoTest() {
        Map<Ranking, Integer> result = calculator.countRankedLottos(lottos);

        assertThat(result.keySet()).contains(Ranking.FIRST_PLACE)
                .contains(Ranking.SECOND_PLACE)
                .contains(Ranking.THIRD_PLACE)
                .contains(Ranking.FOURTH_PLACE)
                .contains(Ranking.FIFTH_PLACE)
                .contains(Ranking.NOT_RANKED)
                .hasSize(6);

        assertThat(result.get(Ranking.FIFTH_PLACE)).isEqualTo(1);
        assertThat(result.get(Ranking.FOURTH_PLACE)).isEqualTo(0);
        assertThat(result.get(Ranking.THIRD_PLACE)).isEqualTo(0);
        assertThat(result.get(Ranking.SECOND_PLACE)).isEqualTo(0);
        assertThat(result.get(Ranking.FIRST_PLACE)).isEqualTo(0);

    }

}