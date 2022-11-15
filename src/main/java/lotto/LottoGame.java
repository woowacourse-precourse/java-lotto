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
    }

    private List<Lotto> getLottos() {
        int purchasePrice = lottoBuyer.getPurchasePrice();

        return lottoSeller.sellLottos(purchasePrice);
    }

    private void printLottos(List<Lotto> lottos) {
        lottoBuyer.setLottos(lottos);
        lottoBuyer.printAllLottos();
    }
}
