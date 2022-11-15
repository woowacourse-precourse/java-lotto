package lotto.console;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoPrize;

public class ConsoleOutput {

  private final StringBuilder stringBuilder = new StringBuilder();
  private final String RESULT_MESSAGE = "당첨 통계\n---";

  public void printLotto(List<Lotto> lottos) {
    for (Lotto lotto : lottos) {
      List<Integer> numbers = lotto.getNumbers();
      Collections.sort(numbers);
      formattingNumbers(numbers);
    }
    System.out.print(stringBuilder.toString());
    stringBuilder.setLength(0);
  }

  private void formattingNumbers(List<Integer> integers) {
    stringBuilder.append("[");
    for (int i = 0; i < integers.size(); i++) {
      if (i == integers.size() - 1) {
        stringBuilder.append(integers.get(i)).append("]");
        break;
      }
      stringBuilder.append(integers.get(i)).append(", ");
    }
    stringBuilder.append("\n");
  }


  public void printResult(List<LottoPrize> prizes, double profitRate) {
    System.out.println(RESULT_MESSAGE);
    Map<LottoPrize, Integer> eachPrizeCount = calculateEachPrizeCount(prizes);
    getPrintedMessage(eachPrizeCount);
    stringBuilder.append("총 수익률은 ").append(profitRate).append("%입니다.");
    System.out.println(stringBuilder);
    stringBuilder.setLength(0);
  }

  private void getPrintedMessage(Map<LottoPrize, Integer> eachPrizeCount) {
    stringBuilder.append("3개 일치 (5,000원) - ").append(eachPrizeCount.get(LottoPrize.FIFTH))
        .append("개\n");
    stringBuilder.append("4개 일치 (50,000원) - ").append(eachPrizeCount.get(LottoPrize.FOURTH))
        .append("개\n");
    stringBuilder.append("5개 일치 (1,500,000원) - ").append(eachPrizeCount.get(LottoPrize.THIRD))
        .append("개\n");
    stringBuilder.append("5개 일치, 보너스 볼 일치 (30,000,000원) - ")
        .append(eachPrizeCount.get(LottoPrize.SECOND)).append("개\n");
    stringBuilder.append("6개 일치 (2,000,000,000원) - ").append(eachPrizeCount.get(LottoPrize.FIRST))
        .append("개\n");
  }


  private Map<LottoPrize, Integer> calculateEachPrizeCount(List<LottoPrize> prizes) {
    Map<LottoPrize, Integer> eachPrizeCount = new HashMap<>();
    Arrays.stream(LottoPrize.values()).forEach(prize -> eachPrizeCount.put(prize, 0));

    prizes.forEach(prize -> {
      if (eachPrizeCount.containsKey(prize)) {
        int value = eachPrizeCount.get(prize);
        eachPrizeCount.put(prize, value + 1);
      }
    });
    return eachPrizeCount;
  }
}
