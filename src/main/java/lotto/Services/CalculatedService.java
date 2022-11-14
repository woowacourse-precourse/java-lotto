package lotto.Services;

import lotto.Dto.Money;

public class CalculatedService {

    private int money;

    public int lottoSize(Money money){
        this.money = money.getMoney();
        if(this.money % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 돈을 입력하시오");
        }
        return this.money / 1000;
    }
}
