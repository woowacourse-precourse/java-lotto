package lotto;

import java.util.List;

public class Application {
    static final int DIVIDE_NUMBER = 1000;

    public static void main(String[] args) {
        try {
            int purchaseAmount = Input.userInput();
            int purchaseQuantity = purchaseAmount / DIVIDE_NUMBER;
            List<Lotto> lottoBundle = Generator.creatLottoBundle(purchaseQuantity);
            Output.printLottoBundle(lottoBundle, purchaseQuantity);
            List<Integer> winningNumber = Generator.creatWinningNumber(Input.winningNumberInput());
            int bonusNumber = Input.bonusNumberInput();
            InputException.isValidBonusNumberOverlap(winningNumber, bonusNumber);
            winningNumber = Generator.addBonusNumber(winningNumber, bonusNumber);
            Compare.sliceBundle(lottoBundle, winningNumber);
            Output.printPreResult();
            Calculator.addPrize();
            Output.printResult();
            Output.printRate(Calculator.rateOfReturn(purchaseAmount));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
