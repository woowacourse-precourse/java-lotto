package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoPrinter {
    public static void printLotto(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());
        lottos.forEach(lotto -> {
            System.out.print("[");
            System.out.print(lotto.getNumbers().stream().map(String::valueOf)
                    .collect(Collectors.joining(", ")));
            System.out.println("]");
        });
    }
}
