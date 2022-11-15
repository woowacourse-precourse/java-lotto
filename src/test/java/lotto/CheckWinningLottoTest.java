package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CheckWinningLottoTest{
    @DisplayName("구매한 로또 중 3개 이상 당첨된 로또의 개수를 리스트 형태 (3개, 4개, 5개, 6개, 5개+보너스)로 보여준다")
    @Test
    void testWinningCount() {
        CheckWinningLotto check = new CheckWinningLotto();
        List<List<Integer>> comparedNumber = List.of(
                List.of(1, 2, 3, 4, 44, 45),
                List.of(1, 2, 3, 4, 43, 44),
                List.of(1, 2, 3, 7, 8, 9),
                List.of(1, 2, 3, 4, 10, 11),
                List.of(1, 2, 3, 12, 13, 14)
        );
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 44, 45);
        int bonusNumber = 43;
        List<Integer> result = List.of(2, 1, 0, 1, 1);
        assertThat((check.totalWinningCount(comparedNumber, winningNumber, bonusNumber))).isEqualTo(result);
    }
}