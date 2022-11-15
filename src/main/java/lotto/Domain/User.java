package lotto.Domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
    private final List<Lotto> lottos;
    private final int money;
    private final int bonusNumber;
    public User(List<Lotto> lottos,int money,int bonusNumber)
    {
        not1000(money);
        this.money = money;
        this.lottos = lottos;
        this.bonusNumber=bonusNumber;
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
        User sortedUser = lottosSort();
        for(Lotto lotto:sortedUser.lottos) {
            System.out.println(lotto);
        }
        return new User(sortedUser.lottos,money,bonusNumber);
    }
    public User lottosSort()
    {

        List<Lotto> sortedList = new ArrayList<>();
        for(int i=0;i<lottos.size();i++)
        {
            List<Integer> newNumList  = new ArrayList<>();
            newNumList.addAll(lottos.get(i).getNumbers());
            System.out.println(newNumList);
            Collections.sort(newNumList);
            sortedList.add(new Lotto(newNumList));
        }
        return new User(sortedList,money,bonusNumber);
    }
    @Override
    public String toString() {
        return this.lottos.toString();
    }}
