package lotto.entity;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConsumerTest {

    @DisplayName("로또 결과를 확인한다.")
    @Test
    void confirmResult() {
        //given
        List<Lotto> lottos = new ArrayList<>(List.of(
            new Lotto(List.of(1, 2, 3, 4, 5, 6)),
            new Lotto(List.of(2, 3, 4, 5, 6, 7)),
            new Lotto(List.of(3, 4, 5, 6, 7, 8)),
            new Lotto(List.of(4, 5, 6, 7, 8, 9))
        ));
        Consumer consumer = new Consumer(lottos);
        Lotto winningNumberLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 7;

        //when
        Map<Rank, Integer> result = consumer.confirmResult(
            new WinningLotto(winningNumberLotto, bonus));

        //then
        assertThat(result.get(Rank.FIRST)).isEqualTo(1);
        assertThat(result.get(Rank.SECOND)).isEqualTo(1);
        assertThat(result.get(Rank.THIRD)).isEqualTo(0);
        assertThat(result.get(Rank.FOURTH)).isEqualTo(1);
        assertThat(result.get(Rank.FIFTH)).isEqualTo(1);
        assertThat(result.get(Rank.NONE)).isEqualTo(0);
    }

}