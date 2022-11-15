package lotto.view;

import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.Lotto;

public class OutputView {
    private static final char ARRAY_BEGIN = '[';
    private static final char ARRAY_END = ']';
    private static final String ARRAY_SEPARATOR = ", ";

    public static void printPurchase(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
    }

    public static void printIssuedLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            printNumbers(lotto);
        }
        System.out.println();
    }

    private static void printNumbers(Lotto lotto) {
        String separatedNumbers = lotto.getNumbers()
                .stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(ARRAY_SEPARATOR));
        System.out.println(ARRAY_BEGIN + separatedNumbers + ARRAY_END);
    }
}
