package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;

public class OutputView {
    private static OutputView instance = new OutputView();

    private OutputView() {
    }

    public void printLottoNumbers(List<Lotto> lottos) {
        System.out.printf((OutputMessage.PURCHASE.message()), lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers().stream().sorted().collect(Collectors.toList()));
        }
    }

    public static OutputView getInstance() {
        return instance;
    }
}
