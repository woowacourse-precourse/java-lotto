package lotto.controller;

import lotto.model.LottoNumberStorage;
import lotto.util.CalculateWinStatics;
import lotto.util.InputUtil;
import lotto.view.PrintView;

import java.util.List;

import static lotto.util.CheckUtil.checkIsDuplicatedNumbers;

public class GameSystem {
    private InputUtil inputUtil = new InputUtil();
    private PrintView printView = new PrintView();
    private LottoNumberStorage lottoNumberStorage = new LottoNumberStorage();
    private CalculateWinStatics calculateWinStatics = new CalculateWinStatics();
    public void gameStart(){
        int purchasePrice,bonusNumber;
        List<Integer> winningNumber;
        List<List<Integer>> lottos;

        purchasePrice = inputUtil.inputPurchasePrice();

        printView.printPurchased(purchasePrice);
        lottos = lottoNumberStorage.lottoNumbers(purchasePrice);
        printView.outputPurchaseQuantity(lottos);

        winningNumber = inputUtil.inputWinningNumber();
        bonusNumber = inputUtil.inputBonusNumber();
        checkIsDuplicatedNumbers(winningNumber,bonusNumber);

        calculateWinStatics.winningStatics(lottos,winningNumber,bonusNumber);
        printView.printStatics(purchasePrice);
    }

}
