package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {
    @BeforeEach
    void clearRankCount(){
        Rank.clearCount();
    }

    @DisplayName("당첨번호에 포함된 번호를 보너스 넘버로 입력")
    @Test
    void generateWinningNumbersByDuplicateBonusNumber() {
        //given
        ArrayList<Integer> winning = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));

        //when
        //then
        Assertions.assertThatThrownBy(() -> new WinningNumbers(winning, 2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("범위를 벗어난 보너스 번호")
    @Test
    void generateWinningNumbersByOverRangeBonusNumber() {
        //given
        ArrayList<Integer> winning = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));

        //when
        //then
        Assertions.assertThatThrownBy(() -> new WinningNumbers(winning, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또를 입력받고, 당첨번호와 일치하는 Rank 에 plusCount1")
    @Test
    void compareLotto1() {
        //given
        ArrayList<Integer> winning = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(winning, 7);
        ArrayList<Integer> lottoNumbers1 = new ArrayList<>(List.of(2, 3, 4, 5, 6, 7));
        Lotto lotto1 = new Lotto(lottoNumbers1);
        ArrayList<Integer> lottoNumbers2 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(lottoNumbers2);

        //when
        winningNumbers.checkLottoWinning(lotto1);
        winningNumbers.checkLottoWinning(lotto2);

        //then
        Assertions.assertThat(Rank.FIRST_PLACE.getCount())
                .isEqualTo(1);
        Assertions.assertThat(Rank.SECOND_PLACE.getCount())
                .isEqualTo(1);
    }

    @DisplayName("로또를 입력받고, 당첨번호와 일치하는 Rank 에 plusCount2")
    @Test
    public void compareLotto2() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1,2,3,4,5,6), 7);
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        winningNumbers.checkLottoWinning(lotto);
        Assertions.assertThat(Rank.FIRST_PLACE.getCount()).isEqualTo(1);
    }
}