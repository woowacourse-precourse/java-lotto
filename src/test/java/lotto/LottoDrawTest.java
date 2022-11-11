package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;
import static org.junit.jupiter.api.Assertions.*;

class LottoDrawTest {

    @Test
    void init() {
        LottoDraw lottoDraw = new LottoDraw();

        assertThat(lottoDraw.getTotalPrizeMoney()).isEqualTo(0);
        assertThat(lottoDraw.getNumberOfWins())
                .hasSize(5)
                .contains(entry("1등", 0), entry("2등", 0), entry("3등", 0), entry("4등", 0), entry("5등", 0));
    }

    @Test
    void enterWinningNumber() {
        ByteArrayInputStream in = new ByteArrayInputStream("1,3,5,7,9,13".getBytes());
        System.setIn(in);


        LottoDraw lottoDraw = new LottoDraw();
        assertThat(lottoDraw.getWinningNumber()).isEqualTo(List.of(1, 3, 5, 7, 9, 13));
    }
}