package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    static boolean getMoneyInput(User user) {
        System.out.println("구입금액을 입력해 주세요.");
        String moneyInput = Console.readLine();

        return user.setMoney(moneyInput);
    }
    static boolean getWinningNumbersInput(User user) {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbersInput = Console.readLine();
        boolean exceptionCheck = user.setWinningNumbers(winningNumbersInput);
        System.out.println();

        return exceptionCheck;
    }
    static boolean getBonusNumberInput(User user) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumberInput = Console.readLine();
        boolean exceptionCheck = user.setBonusNumber(bonusNumberInput);
        System.out.println();

        return exceptionCheck;
    }
    static Game initializeGame(User user) {
        Game game = new Game(user.getMoney());
        game.informGameNumber();
        game.generateGame();
        game.informGames();

        return game;
    }
    static void terminateGame(Game game, User user) {
        game.calculateResult(user);
        user.calculateProfit();
        user.informResult();
        user.informProfit();
    }
    public static void main(String[] args) {
        User user = new User();

        if (getMoneyInput(user)) return;

        Game game = initializeGame(user);

        if (getWinningNumbersInput(user)) return;
        if (getBonusNumberInput(user)) return;

        terminateGame(game, user);
    }
}
