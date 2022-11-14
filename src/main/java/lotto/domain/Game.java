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
        int lottoCount = money.boughtLottoCount();
        List<Lotto> lottos = new ArrayList<>();

        for(int i=0; i<lottoCount; i++){
            List<Integer> boughtLotto = pickUniqueNumbersInRange(Setting.LOTTO_MIN_NUMBER, Setting.LOTTO_MAX_NUMBER, Setting.LOTTO_PICK_NUMBER);
            lottos.add(new Lotto(boughtLotto));
            Output.printBoughtLottoNumbers(boughtLotto);
        }

        List<Integer> pickLottoNumber = pickLotto.lottoNumbers();
        int pickBonusNumber = pickLotto.bonusNumber();

        Long total = 0L;
        Map<WinningEnum, Integer> statistics = new HashMap<>();
        for(Lotto lotto : lottos){
            WinningEnum winning = lotto.getRank(pickLottoNumber, pickBonusNumber);
            if(winning == null) {
                continue;
            }
            total += Long.valueOf(winning.getWinningAmount());

            if(statistics.containsKey(winning)){
                int counting = statistics.get(winning).intValue();
                statistics.put(winning, counting++);
            }
            else{
                statistics.put(winning, 1);
            }
        }

        Output.printWinningStatistics(statistics);
        Output.printYield(total / (double)money.getLongMoney() * 100);
    }
}
