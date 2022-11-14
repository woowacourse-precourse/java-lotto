package lotto;

import lotto.domain.Lotto;
import lotto.domain.Output;
import lotto.domain.Ranking;
import lotto.domain.UserInputScanner;

import java.util.List;
import java.util.Map;

public class Application {
    static UserInputScanner userScanner = new UserInputScanner();
    static Output output = new Output();
    static final Object ERROR = null;
    public static void main(String[] args) {
        final Integer PURCHASE_MONEY = userScanner.askPurchaseMoney();
        if (PURCHASE_MONEY == ERROR) return;

        List<Lotto> lottos = Lotto.buyLottosByPurchaseMoney( PURCHASE_MONEY );
        output.printLottos(lottos);

        List<Integer> winningLottoNumbers = userScanner.askWinningLottoNumber();
        if (winningLottoNumbers == ERROR) return;

        Map<Ranking,Integer> rankResult = Lotto.compareLottosWithLottoNumbers(lottos, winningLottoNumbers);
        output.printResults(PURCHASE_MONEY,rankResult);
    }
}
