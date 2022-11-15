package lotto.model;

import lotto.view.OutputView;

public class Money {

    OutputView outputView = new OutputView();

    private int money;
    private int lottoAmount;

    public Money(int money){

        // 1000원 이상이 아니거나, 1000원으로 나누어지지 않는 경우
        if(!(money >= 1000) || (money % 1000 != 0)){
            throw new IllegalArgumentException("[ERROR] 알맞은 금액을 입력해주세요.");
        }

        this.money = money;
        this.lottoAmount = money / 1000;

    }

    public int getMoney() {
        return money;
    }

    public int getLottoAmount() {
        return lottoAmount;
    }

}
