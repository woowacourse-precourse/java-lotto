package lotto;

import lotto.domain.LottoGameControler;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoSet;
import lotto.domain.WinningNumberInput;

import java.util.List;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        try {

            LottoGameControler lottoGame = new LottoGameControler();
            List<Lotto> lottos= lottoGame.buyLotto();

            LottoSet lottoSet = new LottoSet(lottos);
            lottoGame.setWinningNumbers();
            lottoGame.setBonusNumbers();

            lottoGame.printResult(lottoSet);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("[ERROR]" + illegalArgumentException.getMessage());
        }
        // TODO: 프로그램 구현
    }
}
