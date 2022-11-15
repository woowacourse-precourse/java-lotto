package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.WinningLotto;
import lotto.ui.UserInterface;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int price = UserInterface.enterPurchasePrice();
        LottoGenerator lottoGenerator = new LottoGenerator(price);
        List<Lotto> lottos = lottoGenerator.createLottos();
        WinningLotto winningLotto = UserInterface.enterWinningLotto();
        UserInterface.printStatistics(lottos, winningLotto);
    }
}
