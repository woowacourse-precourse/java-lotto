package lotto.domain;

import java.util.List;

public class Program {
    PrintMsg printMsg = new PrintMsg();
    View view = new View();
    LottoGenerator lottoGenerator = new LottoGenerator();
    int numOfLottos, bonus;
    List<Lotto> lottoList;
    List<Integer> winner;

    public void lottoSetup() {
        printMsg.printMoneyInputMsg();
        numOfLottos = view.getMoneyInput();
        printMsg.printNumberOfLottosMsg(numOfLottos);
        lottoList = lottoGenerator.generateLottos(numOfLottos);
        for (Lotto lotto : lottoList) {
            lotto.printLotto();
        }
    }
    public void winSetup() {
        printMsg.printWinnerInputMsg();
        winner = view.getWinnerInput();
        printMsg.printBonusInputMsg();
        bonus = view.getBonusInput(winner);
    }

}
