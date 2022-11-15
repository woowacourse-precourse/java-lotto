package lotto.domain;

import lotto.business.PickLotto;
import lotto.setting.Setting;
import lotto.setting.WinningEnum;
import lotto.ui.Output;

import java.util.*;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Game {

    private static PickLotto pickLotto = new PickLotto();

    public void start(){

        Money money = new Money();
        List<Lotto> myLotto = myLotto(money.boughtLottoCount());

        List<Integer> pickLottoNumber = pickLotto.lottoNumbers();
        int pickBonusNumber = pickLotto.bonusNumber();

        List<WinningEnum> myWinnings = myLottoToWinning(myLotto, pickLottoNumber, pickBonusNumber);
        statistics(myWinnings);
        total(myWinnings, money.getLongMoney());
    }

    public List<Lotto> myLotto(int lottoCount){
        List<Lotto> myLotto = new ArrayList<>();

        for(int i=0; i<lottoCount; i++){
            List<Integer> boughtLotto = pickUniqueNumbersInRange(Setting.LOTTO_MIN_NUMBER, Setting.LOTTO_MAX_NUMBER, Setting.LOTTO_PICK_NUMBER);
            myLotto.add(new Lotto(boughtLotto));
            Output.printBoughtLottoNumbers(boughtLotto);
        }

        return myLotto;
    }

    public List<WinningEnum> myLottoToWinning(List<Lotto> myLotto, List<Integer> pickLottoNumber, int pickBonusNumber){
        List<WinningEnum> winnings = new ArrayList<>();

        for(Lotto lotto : myLotto){
            WinningEnum winning = lotto.getRank(pickLottoNumber, pickBonusNumber);
            if(winning != null) {
                winnings.add(winning);
            }
        }

        return winnings;
    }

    public void statistics(List<WinningEnum> winnings){
        Map<WinningEnum, Integer> statistics = new HashMap<>();

        for(WinningEnum winning : winnings){
            if (statistics.containsKey(winning)) {
                int counting = statistics.get(winning).intValue();
                statistics.put(winning, counting++);
            } else {
                statistics.put(winning, 1);
            }
        }

        Output.printWinningStatistics(statistics);
    }

    public void total(List<WinningEnum> winnings, Long money){
        Long total = 0L;

        for(WinningEnum winning : winnings){
            total += Long.valueOf(winning.getWinningAmount());
        }

        Output.printYield(total / (double)money * 100);
    }
}
