package lotto;

import view.UI;

import java.util.ArrayList;
import java.util.List;

import static view.Comment.*;

public class Application {
    UI ui = new UI();
    Util util = new Util();

    public void run() {
        List<Buyer> userLottos = new ArrayList<>();
        ui.printMessage(PRINT_INSERT_COIN);
        int money = ui.inputCoin();
        int lottoCount = ui.lottoCount(money);
        ui.printLottoInfo(lottoCount, userLottos);
        ui.printMessage(PRINT_INSERT_WINNING_NUMBER);
        Lotto lottoNums = ui.getWinningNumbers();
        ui.printMessage(PRINT_ENTER_BONUS_NUMBER);
        int bonusNumber = ui.getBonusNumber();
        util.ConfirmationOfTheWinner(userLottos, lottoNums, bonusNumber);
        ui.printWinningStats(money);
    }

    public static void main(String[] args) {
        Application app = new Application();
        // TODO: 프로그램 구현
        app.run();
    }
}
