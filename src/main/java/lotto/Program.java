package lotto;

import java.util.List;

public class Program {
    View view = new View();
    int numOfLottos, bonus;
    ListOfLottos lottoList;
    List<Integer> winner;



    public void lottoSetup() {
        view.printMoneyInputMsg();
        numOfLottos = view.getMoneyInput();
        view.printNumberOfLottosMsg(numOfLottos);
        lottoList = new ListOfLottos(numOfLottos);
        lottoList.printAllLottos();
    }
    public void winSetup() {
        view.printWinnerInputMsg();
        winner = view.getWinnerInput();
        view.printBonusInputMsg();
        bonus = view.getBonusInput(winner);
    }
}
