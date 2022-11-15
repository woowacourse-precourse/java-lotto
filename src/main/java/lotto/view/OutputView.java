package lotto.view;

import lotto.Lotto;
import lotto.Rank;

import java.util.*;

public class OutputView {
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
}
