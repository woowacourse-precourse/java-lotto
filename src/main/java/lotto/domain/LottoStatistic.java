package lotto.domain;

import lotto.Lotto;

import java.util.List;
import java.util.Map;

public class LottoStatistic {
    private final LottoBundle lottoBundle;
    private final int bonus_num;
    private final Lotto win_lotto;

    private Map<Rank,Integer> rankMap;

    public LottoStatistic(LottoBundle lottoBundle, int bonus_num, Lotto win_lotto) {
        this.lottoBundle = lottoBundle;
        this.bonus_num = bonus_num;
        this.win_lotto = win_lotto;
    }
    private void compareBundle(){
        for(Lotto lotto: lottoBundle.getLottoList()){
            int count = compareWin_lotto(lotto);
            boolean bonus = compareBonusNum(lotto);
            if (count == 6)
                rankMap.put(Rank.First_Place,rankMap.getOrDefault(Rank.First_Place,0)+1);
            if (count == 5 && bonus)
                rankMap.put(Rank.Second_Place,rankMap.getOrDefault(Rank.Second_Place,0)+1);
            if (count == 5)
                rankMap.put(Rank.Third_Place,rankMap.getOrDefault(Rank.Third_Place,0)+1);
            if (count == 4)
                rankMap.put(Rank.Fourth_Place,rankMap.getOrDefault(Rank.Fourth_Place,0)+1);
            if (count == 3)
                rankMap.put(Rank.Fifth_Place,rankMap.getOrDefault(Rank.Fifth_Place,0)+1);

        }
    }
    private int compareWin_lotto(Lotto lotto){
        int count =0;
        for(int user_num : lotto.getNumbers()){
            if(win_lotto.getNumbers().contains(user_num))
                count++;
        }
        return count;
    }
    private boolean compareBonusNum(Lotto lotto){
        return lotto.getNumbers().contains(bonus_num);
    }


}
