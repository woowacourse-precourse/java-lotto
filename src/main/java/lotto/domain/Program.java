package lotto.domain;

import java.util.List;

public class Program {
    PrintMsg printMsg = new PrintMsg();
    View view = new View();
    int numOfLottos, bonus;
    ListOfLottos lottoList;
    List<Integer> winner;

    public void lottoSetup() {
        printMsg.printMoneyInputMsg();
        numOfLottos = view.getMoneyInput();
        printMsg.printNumberOfLottosMsg(numOfLottos);
        lottoList = new ListOfLottos(numOfLottos);
        lottoList.printAllLottos();
    }
    public void winSetup() {
        printMsg.printWinnerInputMsg();
        winner = view.getWinnerInput();
        printMsg.printBonusInputMsg();
        bonus = view.getBonusInput(winner);
    }

}
