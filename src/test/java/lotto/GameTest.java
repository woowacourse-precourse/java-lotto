package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {
    @Test
    void generateGameTest() {
        Game testGame = new Game(10000);
        testGame.generateGame();
        for (Lotto lottoI : testGame.games) {
            assertThat(lottoI.getNumbers()).isEqualTo(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
    }
}