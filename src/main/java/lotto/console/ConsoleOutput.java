package lotto.console;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoPrize;

public class ConsoleOutput {

  private final StringBuilder stringBuilder = new StringBuilder();

  public void printLotto(List<Lotto> lottos) {
    stringBuilder.append(lottos.size()).append("개를 구매했습니다.\n");
    for (Lotto lotto : lottos) {
      List<Integer> numbers = lotto.getNumbers();
      List<Integer> sorted = numbers.stream().sorted().collect(Collectors.toList());
      formattingNumbers(sorted);
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
    System.out.println(ConsoleMessage.OUTPUT_RESULT_MESSAGE.getMesage());

    Map<LottoPrize, Integer> eachPrizeCount = calculateEachPrizeCount(prizes);
    getPrintedMessage(eachPrizeCount);

    stringBuilder.append("총 수익률은 ").append(profitRate).append("%입니다.");
    System.out.println(stringBuilder);

    stringBuilder.setLength(0);
  }

  private void getPrintedMessage(Map<LottoPrize, Integer> eachPrizeCount) {
    stringBuilder.append(ConsoleMessage.OUTPUT_FIFTH_MESSAGE.getMesage())
        .append(eachPrizeCount.get(LottoPrize.FIFTH))
        .append("개\n");
    stringBuilder.append(ConsoleMessage.OUTPUT_FOURTH_MESSAGE.getMesage())
        .append(eachPrizeCount.get(LottoPrize.FOURTH))
        .append("개\n");
    stringBuilder.append(ConsoleMessage.OUTPUT_THIRD_MESSAGE.getMesage())
        .append(eachPrizeCount.get(LottoPrize.THIRD))
        .append("개\n");
    stringBuilder.append(ConsoleMessage.OUTPUT_SECOND_MESSAGE.getMesage())
        .append(eachPrizeCount.get(LottoPrize.SECOND))
        .append("개\n");
    stringBuilder.append(ConsoleMessage.OUTPUT_FIRST_MESSAGE.getMesage())
        .append(eachPrizeCount.get(LottoPrize.FIRST))
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
