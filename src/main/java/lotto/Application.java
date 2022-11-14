package lotto;

import lotto.domain.Game;
import lotto.domain.Lotto;
import lotto.domain.LottoWin;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game();
        int money = game.insertMoney();
        System.out.println();

        List<Lotto> lottoBought = game.createLotto(money);
        game.printLottoBought(lottoBought);
        System.out.println();

        LottoWin lottoWin = new LottoWin();
        List<Integer> luckyNumbers = lottoWin.createLuckyNumber();
        System.out.println();

        int bonusNumber = lottoWin.createBonusNumber(luckyNumbers);
        System.out.println();

        game.compareLotto(lottoBought, luckyNumbers, bonusNumber);
        game.printResult(money);
    }

}
