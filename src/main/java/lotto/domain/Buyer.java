package lotto.domain;


import camp.nextstep.edu.missionutils.Console;

public class Buyer {

    Long money;

    public void buyLotto() {
        LottoPublisher.publishLotto(this);
    }

    public void readyForBuyLotto() {
        this.money = Long.valueOf(Console.readLine());
    }

    public Long getMoney() {
        return money;
    }

}
