package lotto.domain.entity;

import lotto.domain.Generator;

public class User {

    private Lottos lottos;
    private Money money;

    private User(int money, Lottos lottos) {
        int time = this.money.currentTime();
        this.money = Money.from(money);
        this.lottos = lottos;
    }

    public static User of(int money, Lottos lottos) {
        return new User(money, lottos);
    }

    public String printCurrentTime() {
        return String.valueOf(money.currentTime());
    }

    public void printUserLottosNumbers() {
        lottos.printWholeLottoNumbers();
    }

    public Lottos currentUserLottos() {
        return lottos;
    }
}
