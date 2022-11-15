package lotto.Controller;

import lotto.Domain.BonusNumber;
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
    LottoPublisher lottoPublisher;

    List<List<Integer>> userInputLottoNumberList = new ArrayList<>();
    int bonusNumber;

    public void gameStart() {
        purchaseLotto();
        inputLottoNumberAndBonus();
    }

    public void purchaseLotto() {
        String purchasing = inputView.inputPurchasing();
        int purchasingAmount = translateStringToInteger(purchasing);
        outputView.printEmptyLine();
        new PurchasingLotto(purchasingAmount);
        outputView.printTheNumberOfLotto(purchasingLotto.getAmountOfLotto());
        for (int i = 0; i < purchasingLotto.getAmountOfLotto(); i++) {
            userInputLottoNumberList.add(lottoPublisher.makeRandomLottoNumber());
        }
        outputView.printLottoNumber(userInputLottoNumberList);
    }

    public void inputLottoNumberAndBonus() {
        String lottoNumberUserInput = inputView.inputWinningNumber();
        List<Integer> lottoNumber = translateStringToIntegerList(lottoNumberUserInput);
        new Lotto(lottoNumber);
        outputView.printEmptyLine();
        String bonusNumberUserInput = inputView.inputBonusNumber();
        int bonusNumber = translateStringToInteger(bonusNumberUserInput);
        new BonusNumber(bonusNumber);
    }

    private List<Integer> translateStringToIntegerList(String text) {
        List<Integer> integerList = new ArrayList<>();
        String[] lottoNumberArray = text.split(",");

        for (String indexString : lottoNumberArray) {
            integerList.add(translateStringToInteger(indexString));
        }

        return integerList;
    }

    private int translateStringToInteger(String text) {
        int integerNumber = Integer.parseInt(text);

        return integerNumber;
    }
}
