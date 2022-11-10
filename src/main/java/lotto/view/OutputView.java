package lotto.view;

import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.LottoCount;
import lotto.model.Lottos;

public class OutputView {
    private static final String NEW_LINE = "\n";
    private static final String OPEN_BRACKET = "[";
    private static final String CLOSE_BRACKET = "]";
    private static final String COMMA = ", ";
    private static final String NUMBER_OF_PURCHASED_LOTTOS = "%d개를 구매했습니다.";

    public static void printLottoCount(LottoCount lottoCount) {
        System.out.print(NEW_LINE);
        System.out.printf(NUMBER_OF_PURCHASED_LOTTOS, lottoCount.getLottoCount());
        System.out.print(NEW_LINE);
    }

    public static void printPurchasedLottoNumbers(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            String lottoNumbers = OPEN_BRACKET
                    + lotto.get()
                    .stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(COMMA))
                    + CLOSE_BRACKET;
            System.out.println(lottoNumbers);
        }
        System.out.print(NEW_LINE);
    }
}
