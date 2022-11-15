package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.insert(InputView.inputMoney());
        OutputView.printLottoCount(lottoMachine.getLottoCount());
        List<Lotto> lottos = lottoMachine.makeLottoTicket();
        for (Lotto lotto : lottos) {
            OutputView.printLotto(lotto.getNumbers().toString());
        }
        Player player = new Player();
        player.calculateRankStatistics(lottos, new WinningLotto(InputView.inputWinningLotto(), InputView.inputBonusNumber()));
        OutputView.printRankStatistics(player.getStatistics());
        OutputView.printEarningRatio(player.calculateEarningRatio(lottoMachine.getLottoCount()));
    }
}