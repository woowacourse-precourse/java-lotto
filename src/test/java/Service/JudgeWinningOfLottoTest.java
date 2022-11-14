package Service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class JudgeWinningOfLottoTest {

    @DisplayName("로또 숫자 3개 일치")
    @Test
    void compareMatchThreeNumber() {
        JudgeWinningOfLotto judgeWinningOfLotto = new JudgeWinningOfLotto();

        int match = judgeWinningOfLotto.compareMatchNumbers(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 44, 35, 26));
        int result = 3;

        Assertions.assertThat(match).isEqualTo(result);
    }

    @DisplayName("로또 숫자 0개 일치")
    @Test
    void comparenotMatch() {
        JudgeWinningOfLotto judgeWinningOfLotto = new JudgeWinningOfLotto();

        int match = judgeWinningOfLotto.compareMatchNumbers(List.of(1, 2, 3, 4, 5, 6), List.of(11, 12, 13, 14, 15, 16));
        int result = 0;

        Assertions.assertThat(match).isEqualTo(result);

    }
    @DisplayName("보너스 번호 포함")
    @Test
    void containBounsNumber(){
        JudgeWinningOfLotto judgeWinningOfLotto = new JudgeWinningOfLotto();

        boolean bonusStatus = judgeWinningOfLotto.isContainBounsNumber(List.of(1, 2, 3, 4, 5, 6), 6);
        boolean result = true;

        Assertions.assertThat(bonusStatus).isEqualTo(result);
    }

    @DisplayName("보너스 번호 미포함")
    @Test
    void notContainBounsNumber(){
        JudgeWinningOfLotto judgeWinningOfLotto = new JudgeWinningOfLotto();

        boolean bonusStatus = judgeWinningOfLotto.isContainBounsNumber(List.of(1, 2, 3, 4, 5, 6), 10);
        boolean result = false;

        Assertions.assertThat(bonusStatus).isEqualTo(result);
    }
}