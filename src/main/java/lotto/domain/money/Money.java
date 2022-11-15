package lotto.domain.money;

import lotto.setting.Setting;
import lotto.ui.Output;


public class Money {

    private Long money;

    public Money(Long money){
        this.money = money;
    }

    public Long getMoney(){
        return this.money;
    }

    public int countBoughtLotto(){
        int bought = Math.toIntExact(money / Setting.LOTTO_PRICE_PER_ONE);
        Output.printBoughtLotto(bought);
        return bought;
    }
}
