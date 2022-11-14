package lotto.domain.entity;

import lotto.domain.Generator;

public class User {

    private Lottos lottos;
    private Money money;

    private User(Money money, Lottos lottos) {
        this.money = money;
        this.lottos = lottos;
    }

    public static User of(Money money, Lottos lottos) {
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
