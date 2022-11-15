package lottomanager;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoCheckerTest {

    private final LottoChecker lottoChecker = new LottoChecker();
    @DisplayName("로또 번호중 몇개가 같은 지 반환한다.")
    @Test
    void checkCompareLotto() {
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> payedLotto = List.of(1, 2, 3, 4, 5, 7);
        assertEquals(lottoChecker.compareLotto(winningLotto,payedLotto),5);
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void checkCompareBonus() {
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 5;
        assertEquals(lottoChecker.compareBonus(bonus, winningLotto),true);
    }
    @Test
    void checkGetRank(){
        List<List<Integer>> Lottoes = List.of(List.of(1, 2, 3, 4, 5, 6), List.of(3, 4, 5, 6, 7, 8));
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 7);
        assertEquals(lottoChecker.getRank(Lottoes, winningLotto, true), List.of(0, 1, 0, 1, 0));
    }

}
