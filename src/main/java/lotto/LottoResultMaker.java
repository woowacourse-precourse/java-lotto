package lotto;

import java.util.List;

public class LottoResultMaker {

    public LottoResult getLottoResult(WinningLotto winningLotto, Lotto userLotto) {
        return new LottoResult(
                countLottoNumberMatch(winningLotto, userLotto),
                countBonusNumberMatch(winningLotto, userLotto)
        );
    }

    public int countLottoNumberMatch(WinningLotto winningLotto, Lotto userLotto) {
        return countDuplicates(winningLotto.getLotto().getNumbers(), userLotto.getNumbers());
    }

    private int countDuplicates(List<Integer> winningLottoNumbers, List<Integer> userLottoNumbers) {
        int count = 0;
        for (int winningLottoNumber : winningLottoNumbers) {
            if (userLottoNumbers.contains(winningLottoNumber)) {
                count++;
            }
        }

        return count;
    }

    public boolean countBonusNumberMatch(WinningLotto winningLotto, Lotto userLotto) {
        if (userLotto.getNumbers().contains(winningLotto.getBonusNumber())) {
            return true;
        }
        return false;
    }


}
