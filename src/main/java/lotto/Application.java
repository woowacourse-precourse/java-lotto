package lotto;

import view.UI;

import java.util.ArrayList;
import java.util.List;

public class Application {
    UI ui = new UI();
    Util util = new Util();

    public void run() {
        List<Buyer> userLottos = new ArrayList<>();
        System.out.println("구매금액을 입력해 주세요.");
        int money = ui.inputCoin();
        int lottoCount = ui.lottoCount(money);
        ui.printLottoInfo(lottoCount, userLottos);

        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> lottoNums = ui.getWinningNumbers();

        System.out.println("보너스 번호를 입력해 주세요");
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
