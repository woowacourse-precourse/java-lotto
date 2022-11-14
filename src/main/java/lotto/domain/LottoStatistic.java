package lotto.domain;

import lotto.Lotto;

import java.util.List;

public class LottoStatistic {
    private final LottoBundle lottoBundle;
    private final int bonus_num;
    private final Lotto win_lotto;

    public LottoStatistic(LottoBundle lottoBundle, int bonus_num, Lotto win_lotto) {
        this.lottoBundle = lottoBundle;
        this.bonus_num = bonus_num;
        this.win_lotto = win_lotto;
    }
    private void compareBunddle (){
        for(Lotto lotto: lottoBundle.getLottoList()){
            int count = compareWin_lotto(lotto);
            boolean bonus = compareBonusNum(lotto);
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
