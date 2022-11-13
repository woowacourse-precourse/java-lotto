package lotto.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottosTest {
    @Test
    void 구매한_복권들의_상금을_모두_더하는_기능() {
        WinningNumbers winningNumbers = new WinningNumbers(
                List.of(1, 2, 3, 4, 5, 6), 7
        );

        Lottos lottos = new Lottos(List.of(
                new Lotto(List.of(1,2,3,4,5,6))
                , new Lotto(List.of(1,3,7,4,5,6))
//                , new Lotto(List.of(1,2,3,13,5,6))
//                , new Lotto(List.of(1,28,13,4,5,6))
//                , new Lotto(List.of(21,2,3,4,7,12))
                , new Lotto(List.of(1,12,23,4,35,7))
        ));

        assertThat(lottos.getWinningAmount()).isEqualTo(2_030_000_000);
    }
}