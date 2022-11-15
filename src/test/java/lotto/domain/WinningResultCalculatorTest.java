package lotto.domain;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;


class WinningResultCalculatorTest {

    WinningResultCalculator winningResultCalculator = new WinningResultCalculator();
    WinningNumbers winningNumbers = new WinningNumbers();
    Map<Rank, Integer> winningStatus;
    Map<Rank, Integer> result;


    @DisplayName("당첨 집계 출력")
    @Test
    void return_winncreateWinningStatusingStatus() {
        assertThat(winningStatus).isEqualTo(result);
    }

    @DisplayName("당첨 금 출력")
    @Test
    void calculatePrizeMoney() {
        assertThat(winningResultCalculator.generateReturnRatio(4_000,winningStatus)).isEqualTo(5.225E7);
    }

    @BeforeEach
    void init() {
        List<Lotto> lottos = new LinkedList<>();
        lottos.add(Lotto.generateFromRawValues(List.of(1, 2, 3, 4, 5, 7)));
        lottos.add(Lotto.generateFromRawValues(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(Lotto.generateFromRawValues(List.of(1, 2, 3, 4, 5, 7)));
        lottos.add(Lotto.generateFromRawValues(List.of(1, 2, 3, 4, 5, 7)));

        winningStatus = winningResultCalculator.generateWinningStatus(lottos
                , winningNumbers.generateFromRawValues(List.of(1, 2, 3, 4, 5, 6), 7));

        result = new TreeMap<>();
        result.put(Rank.FIRST, 1);
        result.put(Rank.SECOND, 3);
        result.put(Rank.THIRD, 0);
        result.put(Rank.FOURTH, 0);
        result.put(Rank.FIFTH, 0);
        result.put(Rank.ZERO_MATCH, 0);

    }

}