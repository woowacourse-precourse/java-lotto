package lotto.Controller;

import lotto.Domain.*;
import lotto.View.InputView;
import lotto.View.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGameController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    PurchasingLotto purchasingLotto;
    LottoPublisher lottoPublisher;
    Lotto lotto;
    BonusNumber bonusNumber;
    CompareLotto compareLotto;
    MatchWinning matchWinning;

    List<List<Integer>> publishedLottoNumberList = new ArrayList<>();

    public void gameStart() {
        purchaseLotto();
        inputLottoNumberAndBonus();
        printLottoResult();
    }

    public void purchaseLotto() {
        System.out.println("hi");
        String purchasing = inputView.inputPurchasing();
        int purchasingAmount = translateStringToInteger(purchasing);
        outputView.printEmptyLine();
        new PurchasingLotto(purchasingAmount);
        outputView.printTheNumberOfLotto(purchasingLotto.getAmountOfLotto());
        for (int i = 0; i < purchasingLotto.getAmountOfLotto(); i++) {
            publishedLottoNumberList.add(lottoPublisher.makeRandomLottoNumber());
        }
        outputView.printLottoNumber(publishedLottoNumberList);
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

    public void printLottoResult() {
        int profit = 0;
        for (int i = 0; i < publishedLottoNumberList.size(); i++) {
            new CompareLotto(publishedLottoNumberList.get(i), lotto.getNumbers(), bonusNumber.getBonusNumber());
            int theNumberOfWins = compareLotto.getTheNumberOfWins();
            int winningBonus = compareLotto.getWinningBonus();
            matchWinning.matchThePrice(theNumberOfWins, winningBonus);
        }
        outputView.printResultOfLotto();
        outputView.printProfit();
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

    public List<List<Integer>> getUserInputLottoNumberList() {
        return this.getUserInputLottoNumberList();
    }
}
