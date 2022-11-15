package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrizeStatisticsTest {
  @Test
  @DisplayName("")
  void calculatePrizeMoneyTest() {
    // given
    Lotto prizeLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    int bonusNumber = 7;
    PrizeStatistics prizeStatistics = new PrizeStatistics(prizeLotto, bonusNumber);

    Lotto lotto1 = new Lotto(List.of(1, 2, 3, 7, 8, 9)); // 5등
    Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 8, 9)); // 4등
    Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 9)); // 3등
    Lotto lotto4 = new Lotto(List.of(1, 2, 3, 4, 5, 7)); // 2등
    Lotto lotto5 = new Lotto(List.of(1, 2, 3, 4, 5, 6)); // 1등
    Lotto lotto6 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
    Lotto lotto7 = new Lotto(List.of(6, 7, 8, 9, 10, 11));
    Lotto lotto8 = new Lotto(List.of(5, 6, 7, 8, 9, 10));
    List<Lotto> lottoList1 = List.of(lotto1, lotto2, lotto7);
    List<Lotto> lottoList2 = List.of(lotto3, lotto6, lotto7);
    List<Lotto> lottoList3 = List.of(lotto4, lotto5, lotto8);

    // when
    prizeStatistics.setPrizeRankArrayByLottoList(lottoList1);
    int prizeMoney1 = prizeStatistics.calculatePrizeMoney();
    prizeStatistics.setPrizeRankArrayByLottoList(lottoList2);
    int prizeMoney2 = prizeStatistics.calculatePrizeMoney();
    prizeStatistics.setPrizeRankArrayByLottoList(lottoList3);
    int prizeMoney3 = prizeStatistics.calculatePrizeMoney();

    // then
    assertEquals(PrizeRank.RANK_5.getPrizeMoney() + PrizeRank.RANK_4.getPrizeMoney(), prizeMoney1);
    assertEquals(PrizeRank.RANK_3.getPrizeMoney(), prizeMoney2);
    assertEquals(PrizeRank.RANK_2.getPrizeMoney() + PrizeRank.RANK_1.getPrizeMoney(), prizeMoney3);
  }
}
