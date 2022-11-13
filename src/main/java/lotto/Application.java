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
        int lottoCount = game.buyLotto(money);
        List<Lotto> lottoBought = game.createLotto(lottoCount);
        for (int i = 0; i < lottoBought.size(); i++) {
            System.out.println(lottoBought.get(i).getNumbers());
        }

        LottoWin lottoWin = new LottoWin();
        List<Integer> luckyNumbers = lottoWin.createLuckyNumber();
        int bonusNumber = lottoWin.createBonusNumber();

        System.out.println("당첨번호: "+luckyNumbers);
        System.out.println("보너스번호: "+bonusNumber);
    }
}
