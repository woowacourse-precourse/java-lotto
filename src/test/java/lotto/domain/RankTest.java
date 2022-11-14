package lotto.domain;

import lotto.standard.Place;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RankTest {

    private Rank rank = new Rank(List.of(1, 2, 3, 4, 5, 6));
    private int bonusNumber = 7;
    private List<List<Integer>> userLottoTickets = List.of(
            List.of(1, 2, 3, 4, 5, 6),  //1등
            List.of(1, 2, 3, 4, 5, 7),  //2등
            List.of(1, 2, 3, 4, 5, 8),  //3등
            List.of(1, 2, 3, 4, 7, 8),  //4등
            List.of(1, 2, 3, 7, 8, 9)); //5등


    @Test
    void countWinningRanksTest() {
        Map<Place, Integer> result = new HashMap<>();
        for (Place rank : Place.values()) {
            result.put(rank, 1);
        }

        rank.countWinningRanks(userLottoTickets, bonusNumber);

        Assertions.assertThat(Rank.winningRanks).isEqualTo(result);
    }

}
