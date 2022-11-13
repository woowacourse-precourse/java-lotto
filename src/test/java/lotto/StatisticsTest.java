package lotto;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class StatisticsTest {
    static Lotto winning;
    static int bonus;
    static Statistics st;

    @BeforeAll
    static void init_all(){
        winning = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        bonus = 7;
        st = new Statistics(winning, bonus);
    }

    @Test
    void 당첨_1등() {
        int prize = st.getPrize(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(prize).isEqualTo(1);
    }

    @Test
    void 당첨_2등() {
        int prize = st.getPrize(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
        assertThat(prize).isEqualTo(2);
    }

    @Test
    void 당첨_3등() {
        int prize = st.getPrize(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)));
        assertThat(prize).isEqualTo(3);
    }

    @Test
    void 당첨_4등() {
        int prize = st.getPrize(new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9)));
        assertThat(prize).isEqualTo(4);
    }

    @Test
    void 당첨_5등() {
        int prize = st.getPrize(new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10)));
        assertThat(prize).isEqualTo(5);
    }

    @Test
    void 당첨_실패() {
        int prize = st.getPrize(new Lotto(Arrays.asList(1, 2, 8, 9, 10, 11)));
        assertThat(prize).isEqualTo(-1);
    }
}
