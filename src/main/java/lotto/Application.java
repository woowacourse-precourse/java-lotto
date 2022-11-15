package lotto;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> winGames;
        Game game = new Game();
        try {
            game.buy();
            game.setWinningNumbers();
            Lotto lotto = new Lotto(game.getWinningNumbers());
            lotto.validateBonus(game.getBonus());
            winGames = game.compareNumbers(lotto.returnNumbers());
            game.printResult(winGames, game.getMoney());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
