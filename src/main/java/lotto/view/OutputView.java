package lotto.view;

import lotto.domain.Lottos;

public class OutputView {
    private static final String BUY_LOTTOS_MESSAGE = "%d개를 구매했습니다.";

    public void printLottoNumbers(Lottos lottos) {
        System.out.println(String.format(BUY_LOTTOS_MESSAGE, lottos.getLottos().size()));
        lottos.getLottos()
                .forEach(lotto -> System.out.println(lotto.getNumbers()));
    }
}
