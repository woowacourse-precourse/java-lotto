package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Publisher {
    private int price;
    private List<Lotto> lottos;

    public Publisher(int price){
        this.price = price;
        lottos = new ArrayList<>(price / 1000);
        for(int i = 0; i < price / 1000; ++i)
            lottos.add(new Lotto(createLottoNumber()));
    }

    private List<Integer> createLottoNumber(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public int getPrice(){
        return price;
    }

    public List<Lotto> getLottos(){
        return lottos;
    }
}
