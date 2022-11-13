package lotto;

import java.util.List;

public class LottoBank {

    public void compareLottoNumber() {
        WinningLotto winningLotto = new WinningLotto();
        LottoMachine lottoMachine = new LottoMachine();
        List<Integer> winningNumbers = winningLotto.creteWinningNumbers();
        List<List<Integer>> totalLotteries = lottoMachine.sortLottoNumbers();
        String rank = "";
        for (List<Integer> lotto : totalLotteries) {
            int sameNumberCount = isContainsNumber(lotto, winningNumbers);
        }
    }

    public int isContainsNumber(List<Integer> lotto, List<Integer> winningNumbers) {
        int sameNumberCount = 0;
        for (int number : lotto) {
            if (winningNumbers.contains(number)) {
                sameNumberCount++;
            }
        }
        return sameNumberCount;
    }
}
