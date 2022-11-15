package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Seller {
    private int countLotto(int money){
        int lottoNum = money / 1000;
        return lottoNum;
    }
    public List<Lotto> sellLotto(int money){
        List<Lotto> lottos = new ArrayList<Lotto>();
        for(int i = 0; i < countLotto(money); i++)
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6)));
        return lottos;
    }
}
