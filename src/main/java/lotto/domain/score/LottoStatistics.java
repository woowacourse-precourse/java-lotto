package lotto.domain.score;


import static lotto.domain.result.LottoResult.getLottoStatisticInfo;
import static lotto.domain.result.LottoResult.getRevenuePercentageInfo;

import java.util.HashMap;
import java.util.Map;
import lotto.constant.LottoRank;

public class LottoStatistics {

  Map<LottoRank, Integer> map = new HashMap<>();
  public static final String OUTPUT_MESSAGE_OF_LOTTO_RESULT = "당첨 통계";
  public static final String OUTPUT_MESSAGE_OF_DIVIDING_LINE = "---";

  public LottoStatistics() {
    init();
  }

  private void init(){
    map.put(LottoRank.NONE, 0);
    map.put(LottoRank.FIFTH, 0);
    map.put(LottoRank.FOURTH, 0);
    map.put(LottoRank.THIRD, 0);
    map.put(LottoRank.SECOND, 0);
    map.put(LottoRank.FIRST, 0);
  }

  public void set(LottoRank rank) {
    map.replace(rank, map.get(rank) + 1);
  }

  public void printLottoStatisticMessage(){
    System.out.println();
    System.out.println(OUTPUT_MESSAGE_OF_LOTTO_RESULT);
    System.out.println(OUTPUT_MESSAGE_OF_DIVIDING_LINE);
    System.out.print(getLottoStatisticInfo(map));
  }

  public void printRevenuePercentageResult(Double rate) {
    System.out.println(getRevenuePercentageInfo(rate));
  }
}
