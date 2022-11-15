package lotto.Controller;

import lotto.Domain.*;
import lotto.View.InputView;
import lotto.View.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGameController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    LottoPublisher lottoPublisher = new LottoPublisher();
    BonusNumber bonusNumber;
    CompareLotto compareLotto;
    MatchWinning matchWinning;

    private List<Integer> userInputLottoNumberList;
    List<List<Integer>> publishedLottoNumberList = new ArrayList<>();

    private final String ERROR_NOT_NUMBER = "[ERROR] 숫자로만 이루어져 있어야 합니다.";

    public void gameStart() {
        purchaseLotto();
        inputLottoNumberAndBonus();
        printLottoResult();
    }

    public void purchaseLotto() {
        String purchasing = inputView.inputPurchasing();
        int purchasingAmount = translateStringToInteger(purchasing);
        outputView.printEmptyLine();
        PurchasingLotto purchasingLotto = new PurchasingLotto(purchasingAmount);
        new PurchasingLotto(purchasingAmount);
        outputView.printTheNumberOfLotto(purchasingLotto.getAmountOfLotto());
        for (int i = 0; i < purchasingLotto.getAmountOfLotto(); i++) {
            publishedLottoNumberList.add(lottoPublisher.makeRandomLottoNumber());
        }
        outputView.printLottoNumber(publishedLottoNumberList);
        outputView.printEmptyLine();
    }

    public void inputLottoNumberAndBonus() {
        String lottoNumberUserInput = inputView.inputWinningNumber();
        List<Integer> lottoNumber = translateStringToIntegerList(lottoNumberUserInput);
        Lotto lotto = new Lotto(lottoNumber);
        userInputLottoNumberList = lotto.getNumbers();
        outputView.printEmptyLine();

        String bonusNumberUserInput = inputView.inputBonusNumber();
        int bonusNumber = translateStringToInteger(bonusNumberUserInput);
        new BonusNumber(bonusNumber);
    }

    public void printLottoResult() {
        int profit = 0;
        for (int i = 0; i < publishedLottoNumberList.size(); i++) {
            System.out.println(publishedLottoNumberList.get(i));
            System.out.println(userInputLottoNumberList);
            // new CompareLotto(publishedLottoNumberList.get(i), lotto.getNumbers(), bonusNumber.getBonusNumber());
            compareLotto.addTheNumberOfWins(publishedLottoNumberList.get(i), userInputLottoNumberList);
            compareLotto.addWinningBonus(userInputLottoNumberList, bonusNumber.getBonusNumber());
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
        notNumberValidate(text);
        int integerNumber = Integer.parseInt(text);

        return integerNumber;
    }

    public List<List<Integer>> getUserInputLottoNumberList() {
        return this.getUserInputLottoNumberList();
    }

    private void notNumberValidate(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) < 48 || text.charAt(i) > 57) {
                throw new IllegalArgumentException(ERROR_NOT_NUMBER);
            }
        }
    }
}
