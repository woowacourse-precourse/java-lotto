package lotto;

import OutputView.PrintMsg;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        PrintMsg.purchasedMsg();
        String purchaseAmount = Console.readLine();
        Game game = new Game();
        game.play(isValidPurchaseAmount(purchaseAmount) / 1000);
    }

    static private int isValidPurchaseAmount(String inputValue) throws IllegalArgumentException {
        if (!isNumeric(inputValue)) {
            throw new IllegalArgumentException("[ERROR]");
        }
        int inputNumber = Integer.parseInt(inputValue);

        if (inputNumber == 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 0보다 커야합니다.");
        }
        if (inputNumber % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000단위로 입력해야 합니다.");
        }
        return inputNumber;
    }

    private static boolean isNumeric(String inputValue) {
        try {
            Integer.parseInt(inputValue);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
