package lotto.domain.winningLotto;

import lotto.domain.myLotto.Lotto;
import lotto.setting.WinningEnum;
import lotto.ui.Output;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningLotto {

    private List<Integer> winningLottoNumber;
    private int winningBonusNumber;

    public WinningLotto(List<Integer> winningLottoNumber, int winningBonusNumber){
        this.winningLottoNumber = winningLottoNumber;
        this.winningBonusNumber = winningBonusNumber;
    }

    public void statistics(List<Lotto> myLotto){
        Map<WinningEnum, Integer> statistics = new HashMap<>();

        for(WinningEnum winning : checkWinning(myLotto)){
            if (statistics.containsKey(winning)) {
                int counting = statistics.get(winning).intValue();
                statistics.put(winning, counting++);
            } else {
                statistics.put(winning, 1);
            }
        }

        Output.printWinningStatistics(statistics);
    }

    public void total(List<Lotto> myLotto, Long money){
        Long total = 0L;

        for(WinningEnum winning : checkWinning(myLotto)){
            total += Long.valueOf(winning.getWinningAmount());
        }

        Output.printYield(total / (double)money * 100);
    }

    public List<WinningEnum> checkWinning(List<Lotto> myLotto){
        List<WinningEnum> winnings = new ArrayList<>();

        for(Lotto lotto : myLotto){
            WinningEnum winning = lotto.getRank(this.winningLottoNumber, this.winningBonusNumber);
            if(winning != null) {
                winnings.add(winning);
            }
        }

        return winnings;
    }
}
