package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Application {
    public static void getMoneyInput(User user) {
        System.out.println("구입금액을 입력해 주세요.");
        String moneyInput = Console.readLine();
        user.setMoney(moneyInput);
    }
    public static Game initializeGame(User user) {
        Game game = new Game(user.getMoney());
        game.informGameNumber();
        game.generateGame();
        game.informGames();
        return game;
    }
    public static void getWinningNumbersInput(User user) {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbersInput = Console.readLine();
        user.setWinningNumbers(winningNumbersInput);
        System.out.println();
    }
    public static void getBonusNumberInput(User user) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumberInput = Console.readLine();
        user.setBonusNumber(bonusNumberInput);
        System.out.println();
    }
    public static void terminateGame(Game game, User user) {
        game.calculateResult(user);
        user.calculateProfit();
        user.informResult();
        user.informProfit();
    }
    public static void main(String[] args) {
        User user = new User();
        String moneyInput = Console.readLine();
        getMoneyInput(user);
        Game game = initializeGame(user);
        getWinningNumbersInput(user);
        getBonusNumberInput(user);
        terminateGame(game, user);
    }
}
