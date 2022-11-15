package lotto.Domain;

import java.util.ArrayList;
import java.util.Collections;
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
        User sortedUser = lottosSort();
        for(Lotto lotto:sortedUser.lottos) {
            System.out.println(lotto);
        }
        return new User(sortedUser.lottos,money);
    }
    public User lottosSort()
    {

        List<Lotto> sortedList = new ArrayList<>();
        for(int i=0;i<lottos.size();i++)
        {
            List<Integer> newNumList  = new ArrayList<>();
            newNumList.addAll(lottos.get(i).getNumbers());
            Collections.sort(newNumList);
            sortedList.add(new Lotto(newNumList));
        }
        return new User(sortedList,money);
    }
;
    public List<WonLotto> countLotto(Lotto answer,int bonusNumber)
    {
        List<WonLotto> answerSize = new ArrayList<>();
        for(int i=0;i<lottos.size();i++) {
            WonLotto wonLotto = new WonLotto();
            List<Integer> newList = new ArrayList<>();
            List<Integer> newList2 = new ArrayList<>();
            newList.addAll(answer.getNumbers());
            newList2.add(bonusNumber);
            newList2.retainAll(lottos.get(i).getNumbers());
            newList.retainAll(lottos.get(i).getNumbers());
            wonLotto.addCount(newList.size(), newList2.size());
            answerSize.add(wonLotto);
        }
        return answerSize;
    }
    @Override
    public String toString() {
        return this.lottos.toString();
    }
}
