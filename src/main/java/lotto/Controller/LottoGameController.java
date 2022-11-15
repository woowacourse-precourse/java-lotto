package lotto.Controller;

import lotto.Domain.Lotto;
import lotto.Domain.LottoPublisher;
import lotto.Domain.PurchasingLotto;
import lotto.View.InputView;
import lotto.View.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGameController {

    InputView inputView;
    OutputView outputView;
    PurchasingLotto purchasingLotto;

    List<Lotto> userInputLottoNumberList = new ArrayList<>();
    int bonusNumber;

    public void gameStart() {
        purchaseLotto();
    }

    public void purchaseLotto() {
        int purchasing = inputView.inputPurchasing();
        outputView.printEmptyLine();
        new PurchasingLotto(purchasing);
        outputView.printTheNumberOfLotto(purchasingLotto.getAmountOfLotto());
        outputView.printLottoNumber(purchasingLotto.getPurchase());
    }

    private List<Integer> translateStringToIntegerList(String text) {
        List<Integer> integerList = new ArrayList<>();

        for (int i = 0; i < text.length(); i++) {
            int indexChar = text.charAt(i);
            integerList.add(indexChar - '0');
        }

        return integerList;
    }

    private int translateStringToInteger(String text) {
        int integerNumber = Integer.parseInt(text);

        return integerNumber;
    }
}
