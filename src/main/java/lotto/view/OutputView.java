package lotto.view;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.TotalLottos;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    static final String LOTTO_PURCHASE_MESSAGE = "개를 구매했습니다.";

    static final String LINE_BREAK = "\n";
    static final String COMMA_DELIMITER = ", ";
    static final String PREFIX_SQUARE_BRACKET = "[";
    static final String SUFFIX_SQUARE_BRACKET = "]";

    public static void printLottoPurchaseCount(long lottoCount) {
        System.out.printf(LINE_BREAK + "%d" + LOTTO_PURCHASE_MESSAGE + LINE_BREAK, lottoCount);
    }

    public static void printLottoWithSquareBrackets(List<Integer> lotto) {
        String printingLotto = lotto.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(COMMA_DELIMITER, PREFIX_SQUARE_BRACKET, SUFFIX_SQUARE_BRACKET));

        System.out.println(printingLotto);
    }

    public static void printTotalLottos(TotalLottos totalLottos) {
        List<Lotto> printingTotalLottos = totalLottos.getTotalLottos();

        printingTotalLottos.stream()
                .forEach(lotto ->
                        printLottoWithSquareBrackets(lotto.getNumbers())
                );
    }
}
