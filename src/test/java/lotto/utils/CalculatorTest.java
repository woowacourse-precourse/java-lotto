package lotto.utils;

import static lotto.model.Rank.SECOND_PLACE;
import static lotto.utils.Calculator.calculateLottoRank;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    @DisplayName("당첨 번호와 로또의 값에 따라 알맞은 순위를 반환한다.")
    void checkCalculateLottoRank() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 9);
        int bonusNumber = 6;

        //when
        Rank rank = calculateLottoRank(lotto, winningNumber, bonusNumber);

        //then
        assertThat(rank).isEqualTo(SECOND_PLACE);
    }
}
