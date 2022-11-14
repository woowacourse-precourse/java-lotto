package lotto.view;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class OutputView {
    private static final String PURCHASE_COUNT_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String LOTTO_NUMBER_SEPARATOR = ", ";
    private static final String LOTTO_NUMBERS_PREFIX = "[";
    private static final String LOTTO_NUMBERS_SUFFIX = "]";

    public static void printPurchaseCount(int count) {
        System.out.printf(PURCHASE_COUNT_MESSAGE, count);
    }

    public static void printLottos(Lottos lottoNumbersGroup) {
        lottoNumbersGroup.getLottos()
                .forEach(OutputView::printLotto);
        System.out.println();
    }

    private static void printLotto(Lotto lottoNumbers) {
        StringJoiner result =
                new StringJoiner(LOTTO_NUMBER_SEPARATOR, LOTTO_NUMBERS_PREFIX, LOTTO_NUMBERS_SUFFIX);
        List<Integer> numbers = lottoNumbers.getNumbers().stream()
                .sorted()
                .collect(Collectors.toList());
        numbers.forEach(number -> result.add(String.valueOf(number)));
        System.out.println(result);
    }

}
