package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            LottoGame lottoGame = new LottoGame();
            List<Lotto> lottos = lottoGame.buyLotto();

            LottoSet lottoSet = new LottoSet(lottos);
            lottoGame.setWinningNumbers();
            lottoGame.setBonusNumbers();

            lottoGame.printResult(lottoSet);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("[ERROR] " + illegalArgumentException.getMessage());
        }
    }
}
