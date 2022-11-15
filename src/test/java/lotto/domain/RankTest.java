package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.Rank.*;
import static org.assertj.core.api.Assertions.*;

class RankTest {
    @DisplayName("로또 1등 당첨")
    @Test
    public void winFirst() {
        int win = 6;
        int bonus = 0;
        Rank rank = findByWinAndBonus(win, bonus);

        assertThat(rank).isEqualTo(FIRST);
    }

    @DisplayName("로또 2등 당첨")
    @Test
    public void winSecond() {
        int win = 5;
        int bonus = 1;
        Rank rank = findByWinAndBonus(win, bonus);

        assertThat(rank).isEqualTo(SECOND);
    }

    @DisplayName("로또 3등 당첨")
    @Test
    public void winThird() {
        int win = 5;
        int bonus = 0;
        Rank rank = findByWinAndBonus(win, bonus);

        assertThat(rank).isEqualTo(THIRD);
    }

    @DisplayName("로또 4등 당첨")
    @Test
    public void winFourth() {
        int win = 4;
        int bonus = 0;
        Rank rank = findByWinAndBonus(win, bonus);

        assertThat(rank).isEqualTo(FOURTH);
    }

    @DisplayName("로또 5등 당첨")
    @Test
    public void winFifth() {
        int win = 3;
        int bonus = 0;
        Rank rank = findByWinAndBonus(win, bonus);

        assertThat(rank).isEqualTo(FIFTH);
    }

    @DisplayName("로또에 당첨되지 않았다.")
    @Test
    public void notWin() {
        int win = 2;
        int bonus = 0;
        Rank rank = findByWinAndBonus(win, bonus);

        assertThat(rank).isEqualTo(ETC);
    }
}