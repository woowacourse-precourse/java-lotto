package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningStatistics {
    List<Lotto> randomLottos;
    Lotto winningLotto;

    public WinningStatistics(List<Lotto> randomLottos, Lotto winningLotto) {
        this.randomLottos = randomLottos;
        this.winningLotto = winningLotto;
    }

    public List<LottoWinning> getWinningStatistics(int bonusNumber) { // WinningStatistics-compare-001
        List<LottoWinning> winningStatistics = new ArrayList<>();
        for (Lotto lotto : this.randomLottos) {
            int lottoCorrectNumber = lotto.getCorrectNumber(winningLotto);
            boolean bonus = lottoCorrectNumber == LottoWinningEnum.SECOND.getCorrectNumber()
                    && lotto.hitBonus(bonusNumber);

            LottoWinning lottoWinning = new LottoWinning(lottoCorrectNumber, bonus);
            winningStatistics.add(lottoWinning);
        }
        return winningStatistics;
    }


    public String printLottos() { // Lotto-print-001
        StringBuilder printString = new StringBuilder(this.randomLottos.size() + Message.HOW_MANY_BUY_STRING.getMessage());
        for (Lotto lotto : this.randomLottos) {
            printString.append(lotto.getNumbers());
            printString.append(System.lineSeparator());
        }
        return printString.toString();
    }

}
