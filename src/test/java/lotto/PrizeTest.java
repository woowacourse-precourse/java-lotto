package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PrizeTest {
    Prize prize;

    @BeforeEach
    void beforeEach() {
    }

    @Test
    void valueOf_1등() {
        prize = Prize.valueOf(6, false);
        Prize want = Prize.PRIZE1;
        assertThat(prize).isEqualTo(want);
    }

    @Test
    void valueOf_2등() {
        prize = Prize.valueOf(5, true);
        Prize want = Prize.PRIZE2;
        assertThat(prize).isEqualTo(want);
    }

    @Test
    void valueOf_3등() {
        prize = Prize.valueOf(5, false);
        Prize want = Prize.PRIZE3;
        assertThat(prize).isEqualTo(want);
    }

    @Test
    void valueOf_4등() {
        prize = Prize.valueOf(4, false);
        Prize want = Prize.PRIZE4;
        assertThat(prize).isEqualTo(want);
    }

    @Test
    void valueOf_5등() {
        prize = Prize.valueOf(3, false);
        Prize want = Prize.PRIZE5;
        assertThat(prize).isEqualTo(want);
    }

    @Test
    void valueOf_낙첨() {
        prize = Prize.valueOf(2, false);
        Prize want = null;
        assertThat(prize).isEqualTo(want);
    }

    @Test
    void valueOf_낙첨2() {
        prize = Prize.valueOf(1, false);
        Prize want = null;
        assertThat(prize).isEqualTo(want);
    }

    @Test
    void valueOf_낙첨3() {
        prize = Prize.valueOf(1, true);
        Prize want = null;
        assertThat(prize).isEqualTo(want);
    }

}