package lotto;

import java.util.List;
import lotto.game.Game;
import lotto.ui.Input;
import lotto.ui.Print;

public class Application {

    public static void main(String[] args) {
        Print.inputPrice();
        int price = Input.price();
        Print.newLine();
        Game game = new Game(price);
        Print.newLine();
        Print.inputLottoNumbers();
        List<Integer> winningLottoNumbers = Input.lottoNumbers();
        game.setWinningLottoNumbers(winningLottoNumbers);
        Print.newLine();
        Print.inputBonusNumber();
        int bonusNumber = Input.bonusNumber();
        game.setBonusNumber(bonusNumber);
        Print.newLine();
        game.getGameResult();
    }
}
