package lotto;

import lotto.Model.LottoManager;
import lotto.View.LottoManagerView;

public class Application {
    private static final LottoManager manager = new LottoManager();
    private static final LottoManagerView view = new LottoManagerView();
    public static void main(String[] args) {
        getUserMoney();
        issueLotto();
        printIssuedLotto();
        getWinningNumbers();
        showWinningPrize();
        showEarningRate();
    }

    private static void showWinningPrize(){
        manager.compare();
        view.printWinningHistory(manager.getWinningRecords());
    }

    private static void getWinningNumbers(){
        String winnings = view.inputWinningNumbers();
        manager.getWinningNumbers(winnings);

        String bonus = view.inputBonusNumber();
        manager.getBonusNumber(bonus);
    }

    private static void issueLotto(){
        manager.issue();
    }
    private static void printIssuedLotto() {
        int ticketNumber = manager.getTicketNumber();
        view.printIssuedLotto(ticketNumber, manager.userLotto);
    }

    private static void getUserMoney(){
        String money = view.inputUserMoney();
        manager.getUserMoney(money);
    }

    private static void showEarningRate(){
        String rate = manager.getEarningRate();
        view.printEarningRate(rate);
    }
}
