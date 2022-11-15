package lotto;

import lotto.domain.Winning;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningTest {
    @Test
    void 전부_맞은_경우() {
        Winning winning = new Winning(List.of(1, 2, 3, 4, 5, 6), 8);
        assertThat(winning.checkWinning(List.of(1, 2, 3, 4, 5, 6))).isEqualTo(1);
    }

    @Test
    void 보너스_번호_맞은_경우_2등() {
        Winning winning = new Winning(List.of(1, 2, 3, 4, 5, 6), 8);
        assertThat(winning.checkWinning(List.of(1, 2, 3, 4, 5, 8))).isEqualTo(2);
    }

    @Test
    void 일부만_맞은_경우_3등() {
        Winning winning = new Winning(List.of(1, 2, 3, 4, 5, 6), 8);
        assertThat(winning.checkWinning(List.of(1, 2, 3, 4, 5, 7))).isEqualTo(3);
    }

    @Test
    void 일부만_맞은_경우_4등() {
        Winning winning = new Winning(List.of(1, 2, 3, 4, 5, 6), 8);
        assertThat(winning.checkWinning(List.of(1, 2, 3, 4, 9, 11))).isEqualTo(4);
    }

    @Test
    void 일부만_맞은_경우_5등() {
        Winning winning = new Winning(List.of(1, 2, 3, 4, 5, 6), 8);
        assertThat(winning.checkWinning(List.of(1, 2, 3, 7, 9, 11))).isEqualTo(5);
    }

    @Test
    void 낙첨() {
        Winning winning = new Winning(List.of(1, 2, 3, 4, 5, 6), 8);
        assertThat(winning.checkWinning(List.of(9, 10, 13, 14, 15, 18))).isEqualTo(0);
    }
}
