package lotto;

import static util.input.lotto.BonusNumberInputUtil.getBonusNumber;
import static util.input.lotto.WinningNumbersInputUtil.getWinningNumbers;

import java.util.List;

public class LottoGame {
    private final LottoBuyer lottoBuyer;
    private final LottoSeller lottoSeller;
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public LottoGame() {
        this.lottoBuyer = new LottoBuyer();
        this.lottoSeller = new LottoSeller();
        this.winningNumbers = getWinningNumbers();
        this.bonusNumber = getBonusNumber(winningNumbers);
    }

    public void proceed() {
        List<Lotto> lottos = getLottos();

        printLottos(lottos);

        WinningLotto winningLotto = getWinningLotto();

        printStatistics(lottos, winningLotto);
    }

    private List<Lotto> getLottos() {
        int purchasePrice = lottoBuyer.getPurchasePrice();

        return lottoSeller.sellLottos(purchasePrice);
    }

    private void printLottos(List<Lotto> lottos) {
        lottoBuyer.setLottos(lottos);
        lottoBuyer.printAllLottos();
    }

    private WinningLotto getWinningLotto() {
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private void printStatistics(List<Lotto> lottos, WinningLotto winningLotto) {
        LottoStatistics lottoStatistics = new LottoStatistics(winningLotto, lottos);

        lottoStatistics.print();
    }
}
