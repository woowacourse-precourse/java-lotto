package lotto.domain.lotto.lottocompany;

import java.util.List;
import java.util.Map;
import lotto.domain.lotto.lotto.PublishedLotto;
import lotto.domain.lotto.lotto.Lotto;

public class LottoCompanyImpl implements LottoCompany {

    private final LottoMachine lottoMachine;
    private final PublishedLotto publishedLotto;
    private final WinResult winResult;

    public LottoCompanyImpl(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
        this.publishedLotto = new PublishedLotto();
        this.winResult = new WinResult();
    }

    @Override
    public List<Lotto> publishNLotto(int publishLottoCount) {
        for (int i = 0; i < publishLottoCount; i++) {
            publishedLotto.addPublishedLotto(lottoMachine.createLotto());
        }

        return publishedLotto.getPublishedLotto();
    }

    @Override
    public Map<Win, Integer> makeWinResult(List<Lotto> publishedNLotto, List<String> winningNumbers, int bonusNumber) {
        for (Lotto publishedLotto : publishedNLotto) {
            List<Integer> lottoNumbers = publishedLotto.getLottoNumbers();
            int winNumberCount = countWinNumber(lottoNumbers, winningNumbers);

            addWinResult(lottoNumbers, winNumberCount, bonusNumber);
        }
        return winResult.getWinResult();
    }

    @Override
    public int getTotalPrize() {
        return winResult.getTotalPrizeMoney();
    }


    private int countWinNumber(List<Integer> lottoNumbers, List<String> winningNumbers) {
        int winNumberCount = 0;
        for (Integer lottoNumber : lottoNumbers) {
            if (winningNumbers.contains(String.valueOf(lottoNumber))) {
                winNumberCount++;
            }
        }
        return winNumberCount;
    }

    private void addWinResult(List<Integer> lottoNumbers, int winNumberCount, int bonusNumber) {
        if (winNumberCount == Win.first.getWinCondition()) {
            winResult.addWin(Win.first);
        }
        if (winNumberCount == Win.second.getWinCondition()) {
            if (isSecondPrize(lottoNumbers, bonusNumber)) {
                winResult.addWin(Win.second);
                return;
            }
            winResult.addWin(Win.third);
        }
        if (winNumberCount == Win.fourth.getWinCondition()) {
            winResult.addWin(Win.fourth);
        }
        if (winNumberCount == Win.fifth.getWinCondition()) {
            winResult.addWin(Win.fifth);
        }
    }

    private boolean isSecondPrize(List<Integer> lottoNumbers, int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }
}
