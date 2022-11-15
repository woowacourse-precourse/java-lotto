package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private User user;

    public void play() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputAmount = Console.readLine();
        user = new User(validateAmount(inputAmount));
        user.buyLotto();
        user.printLottos();
    }

    private long validateAmount(String inputAmount) {
        try {
            return Integer.parseInt(inputAmount);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException();
        }
    }
}
