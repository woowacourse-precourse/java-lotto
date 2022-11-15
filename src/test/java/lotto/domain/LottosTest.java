package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static lotto.domain.Ranking.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottosTest {
    @Test
    void 로또_목록과_당첨_번호를_비교한다() {
        WinningNumber winningNumber = new WinningNumber("1,2,3,5,6,7", 4);
        Lottos lottos = new Lottos(List.of(
                new Lotto("1,2,3,7,5,6"),
                new Lotto("1,2,3,4,5,6"),
                new Lotto("1,3,5,7,10,45"),
                new Lotto("1,8,9,10,11,12")
        ));

        Map<Ranking, Integer> result = lottos.compare(winningNumber);

        assertAll(
                () -> assertThat(result).containsEntry(FIRST, 1),
                () -> assertThat(result).containsEntry(SECOND, 1),
                () -> assertThat(result).containsEntry(FOURTH, 1),
                () -> assertThat(result).containsEntry(MISS, 1)
        );
    }

    @Test
    void 로또_목록의_개수를_반환한다() {
        Lottos lottos = new Lottos(List.of(
                new Lotto("1,2,3,4,5,6"),
                new Lotto("1,3,5,7,10,45")
        ));

        assertThat(lottos.count()).isEqualTo(2);
    }
}
