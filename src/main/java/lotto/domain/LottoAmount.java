package lotto.domain;

import lotto.app.Validation;

public class LottoAmount {
    private final int amount;

    public LottoAmount(Money money){
        amount = money.getMoney() / 1000;
        System.out.printf("%d개를 구매했습니다.\n", amount);
    }

    public int getAmount(){
        return amount;
    }
}
