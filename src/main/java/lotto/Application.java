package lotto;

import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Buyer.buyMessage();
        Buyer buyer = new Buyer(Console.readLine());
        buyer.lottoAmount(buyer.getPurchaseAmount());
        buyer.lottoAmountMessage();
        buyer.makeLotto(buyer.lottoAmount);
        buyer.outPutLottoNum(buyer.totalLotto);
        Buyer.winningMessage();
        buyer.inputWinningNum();
        buyer.getWinningNum(buyer.inputWinningNum);
        Buyer.bonusMessage();
        buyer.inputBonusNum();
        buyer.getBonusNum(buyer.bonusNum);
        buyer.checkWinNum();
        buyer.yieldCalculate(Integer.parseInt(buyer.inputPurchaseAmount));
        buyer.printResult();

    }
}
