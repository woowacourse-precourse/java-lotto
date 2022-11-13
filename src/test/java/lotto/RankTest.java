package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @DisplayName("5등인지 확인한다.")
    @Test
    void is5th(){
        // given
        List<List<Integer>> winningNumbers = List.of(
                List.of(1, 3, 5, 14, 22, 45)
        );
        List<Integer> userNumber = List.of(1,2,3,4,5,6);
        int bonusNumber = 7;
        int expect = 1;

        // when
        new LottoGame().confirmWinningCount(winningNumbers, userNumber, bonusNumber);

        // then
        assertThat(Winning.THREE.getCount()).isEqualTo(expect);
    }

    @DisplayName("4등인지 확인한다.")
    @Test
    void is4th(){
        // given
        List<List<Integer>> winningNumbers = List.of(
                List.of(1, 3, 5, 14, 22, 45)
        );
        List<Integer> userNumber = List.of(1,2,3,4,5,22);
        int bonusNumber = 7;
        int expect = 1;

        // when
        new LottoGame().confirmWinningCount(winningNumbers, userNumber, bonusNumber);

        // then
        assertThat(Winning.FOUR.getCount()).isEqualTo(expect);
    }

    @DisplayName("3등인지 확인한다.")
    @Test
    void is3th(){
        // given
        List<List<Integer>> winningNumbers = List.of(
                List.of(1, 3, 5, 14, 22, 45)
        );
        List<Integer> userNumber = List.of(1,45,3,4,5,22);
        int bonusNumber = 7;
        int expect = 1;

        // when
        new LottoGame().confirmWinningCount(winningNumbers, userNumber, bonusNumber);

        // then
        assertThat(Winning.FIVE.getCount()).isEqualTo(expect);
    }

    @DisplayName("2등인지 확인한다.")
    @Test
    void is2th(){
        // given
        List<List<Integer>> winningNumbers = List.of(
                List.of(1, 3, 5, 14, 22, 45)
        );
        List<Integer> userNumber = List.of(1,45,3,4,5,22);
        int bonusNumber = 45;
        int expect = 1;

        // when
        new LottoGame().confirmWinningCount(winningNumbers, userNumber, bonusNumber);

        // then
        assertThat(Winning.FIVE_AND_BONUS.getCount()).isEqualTo(expect);
    }

    @DisplayName("1등인지 확인한다.")
    @Test
    void is1thAndBonus(){
        // given
        List<List<Integer>> winningNumbers = List.of(
                List.of(1, 3, 5, 14, 22, 45)
        );
        List<Integer> userNumber = List.of(1,45,3,45,5,22);
        int bonusNumber = 2;
        int expect = 1;

        // when
        new LottoGame().confirmWinningCount(winningNumbers, userNumber, bonusNumber);

        // then
        assertThat(Winning.FIVE_AND_BONUS.getCount()).isEqualTo(expect);
    }
}
