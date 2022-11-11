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
//    @Test
//    void calculateResultTest() {
//        User testUser = new User();
//        testUser.setMoney("4000");
//        Game testGame = new Game(testUser.getMoney());
//        testGame.generateGame();
//        testUser.setWinningNumbers("41,42,11,8,21,23");
//        testUser.setBonusNumber("43");
//        testGame.calculateResult(testUser);
//        int[] realResult = {0, 1, 0, 1, 0};
//        int idx = 0;
//        for (String rankI : testUser.result.keySet()) {
//            assertThat(testUser.result.get(rankI)).isEqualTo(realResult[idx]);
//            idx++;
//        }
//    }
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