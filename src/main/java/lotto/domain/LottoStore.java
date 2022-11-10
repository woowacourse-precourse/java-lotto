package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    public void sellLotto() {
        InputView.inputPurchasePrice();
        Money money = new Money(InputView.inputMoney);
        int numberOfLotto = money.purchase();

        List<LottoNumbersIssuance> myLottos = new ArrayList<>();
        makeLottos(numberOfLotto, myLottos);

        receiveWinningNumbers();
    }

    private void receiveWinningNumbers() {
        InputView.inputWinningNumbers();
    }

    private static void makeLottos(int numberOfLotto, List<LottoNumbersIssuance> myLottos) {
        for (int i = 0; i < numberOfLotto; i++) {
            myLottos.add(new LottoNumbersIssuance());
        }
    }
}
