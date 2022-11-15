package lotto.domain;

import java.util.List;

public class WinningLotto {
    private Lotto lotto;
    private int bonus;

    public WinningLotto(Lotto lotto, int bonus){
        this.lotto=lotto;
        this.bonus=bonus;
    }
    public List<Integer> getLottoNumbers(){
        return lotto.getLotto();
    }
    public int getBonus(){
        return bonus;
    }
}
