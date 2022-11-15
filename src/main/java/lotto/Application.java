package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        // TODO: 프로그램 구현

        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = Integer.parseInt(Console.readLine());
        Game game = new Game();
        game.play(isValidPurchaseAmount(purchaseAmount) / 1000);
    }

    static private int isValidPurchaseAmount(int inputValue) throws IllegalArgumentException {
        if (inputValue == 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 0보다 커야합니다.");
        }
        if (inputValue % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000단위로 입력해야 합니다.");
        }
        return inputValue;
    }
}
