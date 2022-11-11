package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {

    private final static String LOTTO_SIZE_MESSAGE = "개를 구매했습니다.";
    private final static String LOTTO_PREFIX = "[";
    private final static String LOTTO_SUFFIX = "]";
    private final static String SEPARATOR = ", ";

    public static void printLottos(List<Lotto> lottos) {
        printLottoSize(lottos.size());
        lottos.stream().forEach(OutputView::printLotto);
    }

    private static void printLottoSize(int size) {
        System.out.print(size);
        System.out.println(LOTTO_SIZE_MESSAGE);
    }

    private static void printLotto(Lotto lotto) {
        StringBuilder lottoMessage = new StringBuilder(LOTTO_PREFIX);
        for (int number : lotto.getNumbers()) {
            lottoMessage.append(number).append(SEPARATOR);
        }
        lottoMessage = new StringBuilder(lottoMessage.substring(0, lottoMessage.length() - 2));
        lottoMessage.append(LOTTO_SUFFIX);
        System.out.println(lottoMessage);
    }
}
