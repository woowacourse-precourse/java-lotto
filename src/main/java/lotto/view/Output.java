package lotto.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lotto.model.PrizeType;

public class Output {
    public static void printYourStatistics(Map<String, Integer> PrizeSet, float stat) {

        // int PRIZE1, int PRIZE2, int PRIZE3, int PRIZE4, int PRIZE5;
        System.out.println("당첨 통계\n---");
        System.out.println(PrizeType.PRIZE5.getResultText(PrizeSet.get("PRIZE5")));
        System.out.println(PrizeType.PRIZE4.getResultText(PrizeSet.get("PRIZE4")));
        System.out.println(PrizeType.PRIZE3.getResultText(PrizeSet.get("PRIZE3")));
        System.out.println(PrizeType.PRIZE2.getResultText(PrizeSet.get("PRIZE2")));
        System.out.println(PrizeType.PRIZE1.getResultText(PrizeSet.get("PRIZE1")));
        System.out.println("총 수익률은 " + String.format("%,.1f", stat) + "%입니다.");
    }

    public static void printLotto(List<Integer> lottoNumbers) {
        lottoNumbers.stream().sorted().collect(Collectors.toList());
        System.out.println(lottoNumbers);
    }

    public static void printReceivedMoney(String receivedMoney) {
        System.out.println(Integer.parseInt(receivedMoney) / 1000 + "개를 구매했습니다.");
    }
}
