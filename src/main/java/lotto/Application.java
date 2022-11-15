package lotto;

import ui.UserInterface;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int lottoCount = UserInterface.enterPurchasePrice();

        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Lotto> lottos = lottoGenerator.createLottos(lottoCount);
        WinningLotto winningLotto = UserInterface.enterWinningLotto();
        UserInterface.printStatistics(lottos, winningLotto);
    }
}
