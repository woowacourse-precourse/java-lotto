package lotto.ui;

import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game game = new Game();




    @Test
    void 수익률_확인() {
        float bill = game.getRevenuePercent("1000",1255);
        assertTrue(bill ==125.5);
    }

    @Test
    void 천단위_확인() {
        assertThatThrownBy(() -> game.checkIfDivideWithThousand("5500"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}