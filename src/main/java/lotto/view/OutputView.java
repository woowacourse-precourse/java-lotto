package lotto.view;

import lotto.Lotto;
import lotto.Rank;

import java.util.*;

public class OutputView {
    private static final String RESULT_OUTPUT_MESSAGE = "당첨 통계\n---";

    public static List<Integer> order(List<Integer> number) {
        List<Integer> sortNumber = new ArrayList<Integer>(number);
        Collections.sort(sortNumber);
        return sortNumber;
    }

    public static void ticket(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
        lottos.stream().forEach(e -> System.out.println(order(e.getNumbers())));
        System.out.println();
    }

    public static Map<Rank, Integer> convertMap(List<Rank> result) {
        LinkedHashMap<Rank, Integer> gather = new LinkedHashMap<>();
        Arrays.stream(Rank.values()).
                forEach(e -> gather.put(e, 0));
        result.stream().forEach(e -> gather.put(e, gather.get(e) + 1));
        return gather;
    }

    public static void result(List<Rank> result, int money) {
        System.out.println(RESULT_OUTPUT_MESSAGE);
        int reward = 0;
        for (Map.Entry<Rank, Integer> entry : convertMap(result).entrySet()) {
            if (entry.getKey() == Rank.FAIL) {
                continue;
            }
            if (entry.getValue() > 0) {
                reward += entry.getKey().getPrize();
            }
            System.out.printf("%s%d개%n", entry.getKey().getText(), entry.getValue());
        }
        String formatReward =  String.format("%.1f", (reward / (double) money * 100));
        System.out.println("총 수익률은 " + formatReward + "%입니다.");
    }
}
