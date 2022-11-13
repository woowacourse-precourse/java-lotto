package lotto.utils;

import static lotto.model.Rank.FIFTH_PLACE;
import static lotto.model.Rank.FIRST_PLACE;
import static lotto.model.Rank.FOURTH_PLACE;
import static lotto.model.Rank.SECOND_PLACE;
import static lotto.model.Rank.THIRD_PLACE;
import static lotto.utils.Calculator.calculateCountsByRanks;
import static lotto.utils.Calculator.calculateLottoRank;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import java.util.Map;
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

    @Test
    @DisplayName("로또별 등수를 이용하여 등수별 개수를 이용하여 고객의 당첨 현황을 반환한다.")
    void checkCalculateCountsByRanks() {
        //given
        List<Rank> customerRanks = List.of(FIRST_PLACE, SECOND_PLACE, THIRD_PLACE);

        //when
        Map<Rank, Integer> result = calculateCountsByRanks(customerRanks);

        //then
        assertThat(result).isEqualTo(
                Map.of(
                        FIRST_PLACE, 1,
                        SECOND_PLACE, 1,
                        THIRD_PLACE, 1,
                        FOURTH_PLACE, 0,
                        FIFTH_PLACE, 0
                )
        );
    }
}
