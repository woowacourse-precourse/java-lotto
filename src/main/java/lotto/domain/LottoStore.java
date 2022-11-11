package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    public void sellLotto() {
        InputView.inputPurchasePrice();
        Money money = new Money(InputView.inputMoney);
        int numberOfLotto = money.purchase();

        List<LottoNumbersIssuance> purchasedLottos = new ArrayList<>();
        MyLottos myLottos = new MyLottos(makeLottos(numberOfLotto, purchasedLottos));

        receiveWinningNumbers();
        Person person = new Person(myLottos, makeWinningNumbers());
        person.buyLotto();
    }

    private Lotto makeWinningNumbers() {
        Lotto winningLotto = new Lotto(InputView.winningNumbers);
        return winningLotto;
    }

    private void receiveWinningNumbers() {
        InputView.inputWinningNumbers();
    }

    private static List<LottoNumbersIssuance> makeLottos(int numberOfLotto, List<LottoNumbersIssuance> purchasedLottos) {
        for (int i = 0; i < numberOfLotto; i++) {
            purchasedLottos.add(new LottoNumbersIssuance());
        }
        return purchasedLottos;
    }
}
