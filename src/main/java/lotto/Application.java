package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoMachine lottoMachine = new LottoMachine();
        User user = new User();

        lottoMachine.requestWantBuyAmountInputMessage();

        int wantBuyAmountInput = 0;

        try {
            wantBuyAmountInput = user.wantBuyAmountInput();
        } catch (Exception e) {
            wantBuyAmountInput = user.wantBuyAmountInput();
        }


        int canBuyAmount = lottoMachine.canBuyAmount(wantBuyAmountInput);

        lottoMachine.canBuyAmountMessage(canBuyAmount);

        List<Lotto> lottoList = lottoMachine.lottoList(canBuyAmount);

        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }

        lottoMachine.requestWinningNumbersMessage();
        String winningNumbersInput = user.winningNumbersInput();
        List<Integer> winningNumberList = user.winningNumbersToList(winningNumbersInput);

        lottoMachine.requestBonusNumbersMessage();

        int bonusNumberInput = user.bonusNumberInput();
        user.validBonusNumberInputContainWinningNumbers(bonusNumberInput, winningNumberList);

        lottoMachine.scoreBoardMessage();

        List<Integer> correctCntList = lottoMachine.countCorrect(lottoList, winningNumberList);

        List<Boolean> containBonusNumberList = lottoMachine.isContainBonusNumberList(lottoList, bonusNumberInput);

        int[] scoreBoard = lottoMachine.makeScoreBoard(correctCntList, containBonusNumberList);

        lottoMachine.scoreBoardMessage(scoreBoard);

        int totalIncome = lottoMachine.totalIncome(correctCntList, containBonusNumberList);

        lottoMachine.makeYield(totalIncome, wantBuyAmountInput);


    }
}
