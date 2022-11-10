package lotto.view;

import lotto.domain.Lotto;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final int LOTTO_PRICE = 1000;
    private static final String PURCHASE_LOTTO = "\n%d개를 구매했습니다.\n";
    private static final String OPEN_BRACKET = "[";
    private static final String CLOSE_BRACKET = "]";
    private static final String SEPARATOR = ", ";

    public void printPurchaseLottoCount(int money) {
        System.out.printf(PURCHASE_LOTTO, money / LOTTO_PRICE);
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            printLotto(lotto);
        }
    }

    private void printLotto(Lotto lotto) {
        String lottoNumbers = lotto.getNumbers()
                .stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(SEPARATOR));
        System.out.println(OPEN_BRACKET + lottoNumbers + CLOSE_BRACKET);
    }
}
