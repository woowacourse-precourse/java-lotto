package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.*;

public class Application {
    public static void main(String[] args) {
        purchaseInputController();
        winningInputController();
    }

    static void purchaseInputController() {
        System.out.println("구입 금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();

        Purchase purchase = new Purchase(purchaseAmount);

        System.out.printf("\n%d개를 구매했습니다.\n", purchase.getPurchaseQuantity());
        for (Lotto lotto : purchase.getLottos()) {
            lotto.printLotto();
        }
    }

    static void winningInputController() {
        Winning winning = new Winning();

        System.out.println("\n당첨 번호를 입력해 주세요.");
        String winningNumberInput = Console.readLine();
        winning.initWinningNumbers(winningNumberInput);

        System.out.println("\n보너스 번호를 입력해 주세요.");
        String bonusNumberInput = Console.readLine();
        winning.initBonusNumber(bonusNumberInput);
    }

}
