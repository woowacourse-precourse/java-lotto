package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ResultTest {

    @Test
    void matchTest(){
        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lottos.add(lotto);
        Lotto winningLotto = new Lotto(List.of(4, 5, 6, 7, 8, 9));
        Result result = new Result(lottos, winningLotto, 1);

        result.calc();
        List<Integer> counts = result.getCounts();
        List<Integer> bonuses = result.getBonuses();

        assertThat(counts.get(0)).isEqualTo(3);
        assertThat(bonuses.get(0)).isEqualTo(1);
    }

}