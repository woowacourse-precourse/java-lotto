package lotto.model;

import lotto.enums.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RankingTest {
    @DisplayName("생성된 로또와 당첨 번호 비교해서 랭킹 계산")
    @Test
    void setRankingTest() {
        Money money = new Money("6000");

        List<Lotto> lottoList = List.of(
                new Lotto(List.of(1, 3, 5, 7, 9, 11)),
                new Lotto(List.of(1, 5, 7, 9, 11, 30)),
                new Lotto(List.of(3, 5, 6, 7, 9, 11)),
                new Lotto(List.of(5, 7, 9, 11, 15, 45)),
                new Lotto(List.of(1, 2, 3, 4, 5, 27)),
                new Lotto(List.of(13, 14, 15, 16, 17, 18)));
        WinningNumbers winningNumbers = new WinningNumbers("1,3,5,7,9,11", "30");

        Ranking ranking = new Ranking(lottoList, winningNumbers);

        Map<Rank, Integer> ranks = Map.ofEntries(
                Map.entry(Rank.FIRST, 1),
                Map.entry(Rank.SECOND, 1),
                Map.entry(Rank.THIRD, 1),
                Map.entry(Rank.FOURTH, 1),
                Map.entry(Rank.FIFTH, 1),
                Map.entry(Rank.DEFAULT, 1)
        );
        assertEquals(ranking.getRanking(), ranks);
    }
}