package lotto;

import lotto.domain.Game;
import lotto.domain.Lotto;

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

    }
}
