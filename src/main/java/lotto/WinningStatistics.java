package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinningStatistics {
    private final List<Lotto> randomLottos;
    private final List<LottoWinning> winningLottos;

    public WinningStatistics(List<Lotto> randomLottos, Lotto winningLotto, int bonusNumber) {
        this.randomLottos = randomLottos;
        this.winningLottos = getWinningLottos(winningLotto, bonusNumber);
    }

    public String printLottos() { // Lotto-print-001
        StringBuilder printString = new StringBuilder(this.randomLottos.size() + Message.HOW_MANY_BUY_STRING.getMessage());
        for (Lotto lotto : this.randomLottos) {
            printString.append(lotto.getNumbers());
            printString.append(System.lineSeparator());
        }
        return printString.toString();
    }

    public List<Integer> getCountWinning(){ // WinningStatistics-print-001, -yield-001
        List<Integer> countWinning = new ArrayList<>();
        for (LottoWinningEnum lottoWinningEnum : LottoWinningEnum.values()){
            int correctNumber = lottoWinningEnum.getCorrectNumber();
            boolean hitBonus = lottoWinningEnum.isHitBonus();

            int count = Collections.frequency(this.winningLottos, new LottoWinning(correctNumber, hitBonus));
            countWinning.add(count);
        }
        return countWinning;
    }

    private List<LottoWinning> getWinningLottos(Lotto winningLotto, int bonusNumber) { // WinningStatistics-compare-001
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
}
