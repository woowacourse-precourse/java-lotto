package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoPaperTest {

    @Test
    void getResult() {
        LottoPaper lottoPaper = new LottoPaper();
        List<Integer> testLotto = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 10;
        assertThat(lottoPaper.getResult(testLotto, bonus)).isEqualTo(2);
    }
}