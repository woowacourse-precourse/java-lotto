package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoController {
    public void start() {
        Money userInputMoney = new Money();
        userInputMoney.init();
        LottoGame lottoGame = new LottoGame();
        lottoGame.buy(userInputMoney);
        printLottos(lottoGame.getLottos());
    }

    public void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            String numbers = lotto.getNumbers().stream()
                    .map(lottoItem -> Integer.toString(lottoItem.get()))
                    .collect(Collectors.joining(", "));
            System.out.printf("[%s]" + System.lineSeparator(), numbers);
        }
        System.out.println();
    }
}
