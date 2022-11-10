package lotto.domain.entity;

import lotto.domain.Generator;

public class User {

    private Lottos lottos;
    private Money money;

    private User(int money, Generator generator) {
        this.money = Money.from(money);
        int time = this.money.currentTime();
        this.lottos = Lottos.of(time, generator);
    }

    public static User of(int money, Generator generator) {
        return new User(money, generator);
    }

    public String printCurrentTime() {
        return String.valueOf(money.currentTime());
    }

    public void printUserLottosNumbers() {
        lottos.printWholeLottoNumbers();
    }
}
