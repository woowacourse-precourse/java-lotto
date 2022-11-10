package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    void calculateResultTest() {
        User testUser = new User();
        testUser.setMoney("8000");
        Game testGame = new Game(testUser.getMoney());
        testGame.generateGame();
        testUser.setWinningNumbers("1,2,3,4,5,6");
        testUser.setBonusNumber("7");
        testGame.calculateResult(testUser);
        assertThat(testGame.result).isEqualTo(new int[]{0, 0, 0, 0, 1});
    }


    @Test
    void compareNumbers() {
        User testUser = new User();
        testUser.setMoney("8000");
        testUser.setWinningNumbers("1,2,3,4,5,9");
        testUser.setBonusNumber("7");
        Game testGame = new Game(testUser.getMoney());
        assertThat(testGame.compareNumbers(List.of(1, 2, 3, 4, 5, 7), testUser)).isEqualTo("SECOND");
    }
}