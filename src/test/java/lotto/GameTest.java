package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.Constants.LOTTO_COUNT;
import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    @DisplayName("당첨 번호 찾기")
    @Test
    void givenWinningNumberAndLottoNumbers_whenFindNthPlace_thenReturnTotalCount() {
        //Given
        // 당첨 번호
        List<Integer> winningNumber = List.of(14, 17, 22, 25, 26, 45);
        int bonusNumber = 7;
        // 로또 번호
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(List.of(1, 2, 3, 4, 5, 6));         // 0개 맞음
        lottoNumbers.add(List.of(14, 1, 2, 3, 4, 5));        // 1개 맞음
        lottoNumbers.add(List.of(14, 17, 2, 3, 4, 5));       // 2개 맞음
        lottoNumbers.add(List.of(14, 17, 22, 3, 4, 5));      // 3개 맞음
        lottoNumbers.add(List.of(14, 17, 22, 25, 4, 5));     // 4개 맞음
        lottoNumbers.add(List.of(14, 17, 22, 25, 26, 5));    // 5개 맞음
        lottoNumbers.add(List.of(14, 17, 22, 25, 26, 7));    // 5개 맞음 + 보너스 번호
        lottoNumbers.add(List.of(14, 17, 22, 25, 26, 45));   // 6개 맞음

        //When
        int result[] = findNthPlace(lottoNumbers, winningNumber, bonusNumber);
        int expectedAnswer[] = {3, 1, 1, 1, 1, 1};
        //Then
        assertThat(result).isEqualTo(expectedAnswer);
    }

    @DisplayName("당첨 번호 찾기 - 1등 1개, 2등 2개, 3등 3개")
    @Test
    void givenWinningNumberAndLottoNumbers_whenFindNthPlace_thenReturnTotalCount2() {
        //Given
        // 당첨 번호
        List<Integer> winningNumber = List.of(14, 17, 22, 25, 26, 45);
        int bonusNumber = 7;
        // 로또 번호
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(List.of(17, 25, 26, 45, 22, 1));    // 5개 맞음
        lottoNumbers.add(List.of(14, 22, 25, 26, 45, 1));    // 5개 맞음
        lottoNumbers.add(List.of(14, 17, 22, 25, 26, 1));    // 5개 맞음
        lottoNumbers.add(List.of(17, 25, 26, 45, 22, 7));    // 5개 맞음 + 보너스 번호
        lottoNumbers.add(List.of(14, 17, 22, 25, 26, 7));    // 5개 맞음 + 보너스 번호
        lottoNumbers.add(List.of(14, 17, 22, 25, 26, 45));   // 6개 맞음

        //When
        int result[] = findNthPlace(lottoNumbers, winningNumber, bonusNumber);
        int expectedAnswer[] = {0, 1, 2, 3, 0, 0};
        //Then
        assertThat(result).isEqualTo(expectedAnswer);
    }

    private int[] findNthPlace(List<List<Integer>> lottoNumbers, List winningNumber, int bonusNumber) {
        int result[] = new int[6];

        for (int i = 0; i < lottoNumbers.size(); i++) {
            int index = checkRank(lottoNumbers.get(i), winningNumber, bonusNumber);
            result[index]++;
        }
        return result;
    }


    private int checkRank(List<Integer> lotto, List<Integer> winningNumber, int bonusNumber) {
        int count = countNumberInLotto(lotto, winningNumber);

        if (count == Ranking.FifthPlace.HIT_COUNT_NUMBER)
            return 5;
        if (count == Ranking.FourthPlace.HIT_COUNT_NUMBER)
            return 4;
        if (count == Ranking.SecondPlace.HIT_COUNT_NUMBER && lotto.contains(bonusNumber))
            return 2;
        if (count == Ranking.ThirdPlace.HIT_COUNT_NUMBER)
            return 3;
        if (count == Ranking.FirstPlace.HIT_COUNT_NUMBER)
            return 1;
        return 0;
    }

    private int countNumberInLotto(List<Integer> lotto, List<Integer> winningNumber) {
        int count = 0;
        for (int i = 0; i < LOTTO_COUNT; i++) {
            if (lotto.contains(winningNumber.get(i))) {
                count++;
            }
        }
        return count;
    }

}