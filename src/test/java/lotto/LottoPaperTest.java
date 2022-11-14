package lotto;

import static org.assertj.core.api.Assertions.*;
import lotto.domain.LottoPaper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;


class LottoPaperTest {
    LottoPaper lottoPaper = new LottoPaper();
    @DisplayName("LottoPaper 에 랜던 번호가 잘 들어가는지 확인 하는 test")
    @Test
    void setLottoPaper(){
        List<Integer> testNum = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        lottoPaper.setLottoNumber(testNum);
        assertThat(lottoPaper.lottoNumber).isEqualTo(testNum);
    }
    @DisplayName("당첨번호와 랜덤번호와 비교후 5등일 경우")
    @Test
    void getResultFifthWin() {
        lottoPaper.lottoNumber = new ArrayList<>(List.of(1, 2, 10, 3, 15, 20));
        List<Integer> winningLotto = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 45;
        assertThat(lottoPaper.getResult(winningLotto, bonus)).isEqualTo(3);
    }
    @DisplayName("당첨번호와 랜덤번호와 비교후 4등일 경우")
    @Test
    void getResultForthWin() {
        lottoPaper.lottoNumber = new ArrayList<>(List.of(1, 2, 10, 3, 4, 20));
        List<Integer> winningLotto = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 45;
        assertThat(lottoPaper.getResult(winningLotto, bonus)).isEqualTo(4);
    }
    @DisplayName("당첨번호와 랜덤번호와 비교후 3등일 경우")
    @Test
    void getResultThirdWin() {
        lottoPaper.lottoNumber = new ArrayList<>(List.of(1, 2, 10, 3, 4, 20));
        List<Integer> winningLotto = new ArrayList<>(List.of(1, 2, 3, 4, 20, 6));
        int bonus = 45;
        assertThat(lottoPaper.getResult(winningLotto, bonus)).isEqualTo(5);
    }
    @DisplayName("당첨번호와 랜덤번호와 비교후 2등일 경우")
    @Test
    void getResulSecondWin() {
        lottoPaper.lottoNumber = new ArrayList<>(List.of(1, 2, 45, 3, 4, 6));
        List<Integer> testLotto = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 45;
        assertThat(lottoPaper.getResult(testLotto, bonus)).isEqualTo(7);
    }
    @DisplayName("당첨번호와 랜덤번호와 비교후 1등일 경우")
    @Test
    void getResultVictoryWin() {
        lottoPaper.lottoNumber = new ArrayList<>(List.of(1, 2, 6, 3, 4, 5));
        List<Integer> testLotto = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 45;
        assertThat(lottoPaper.getResult(testLotto, bonus)).isEqualTo(6);
    }
}