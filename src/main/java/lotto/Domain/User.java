package lotto.Domain;

import java.util.List;

public class User {
    private final List<Lotto> lottos;
    private final int money;

    public User(List<Lotto> lottos,int money)
    {
        not1000(money);
        this.money = money;
        this.lottos = lottos;
    }

    public void not1000(int money)
    {
        if(money%1000!=0)
        {
            throw new IllegalArgumentException();
        }
    }
    public User printLottosList()
    {
        for(Lotto asd:this.lottos) {
            System.out.println(asd);
        }
        return new User(this.lottos,money);
    }
    @Override
    public String toString() {
        return this.lottos.toString();
    }}
