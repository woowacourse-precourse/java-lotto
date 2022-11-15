package lotto.Domain;

import java.util.List;

public class User {
    private final List<Lotto> Lottos;
    private final int money;

    public User(List<Lotto> Lottos,int money)
    {
        not1000(money);
        this.money = money;
        this.Lottos = Lottos;
    }

    public void not1000(int money)
    {
        if(money%1000!=0)
        {
            throw new IllegalArgumentException();
        }
    }
}
