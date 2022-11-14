package lotto.Domain;

import java.util.List;

public class User {
    private final List<Lotto> Lottos;
    private final int money;

    public User(List<Lotto> Lottos,int money)
    {
        this.money = money;
        this.Lottos = Lottos;
    }
}
