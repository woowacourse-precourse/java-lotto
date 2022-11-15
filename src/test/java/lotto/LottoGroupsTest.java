package lotto;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import type.Rank;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGroupsTest {
    private LottoGroups lottoGroups;

    @BeforeEach
    void setUp() {
        lottoGroups = new LottoGroups(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(1, 2, 3, 4, 5, 7))));
    }

    @DisplayName("모든 Lotto의 Rank를 반환한다.")
    @Test
    void getRanks() {
        assertThat(lottoGroups.getRanks(List.of(1,2,3,4,7,9),8)).contains(Rank.FOURTH, Rank.THIRD);
    }

    @DisplayName("등수별 개수를 구한다.")
    @Test
    void getNumbersOfRanks() {
        Map<Rank, Integer> numbersOfRanks = lottoGroups.numbersOfRanks(List.of(1, 2, 3, 7, 12, 13), 9);

        assertThat(numbersOfRanks.get(Rank.FIFTH)).isEqualTo(1);
        assertThat(numbersOfRanks.get(Rank.FOURTH)).isEqualTo(1);
    }
}
