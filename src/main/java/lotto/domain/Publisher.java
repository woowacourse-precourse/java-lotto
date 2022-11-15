package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Publisher {

    public static List<Lotto> publishLotto(int buyCount){
        List<Lotto> newLotto = new ArrayList<>();
        for(int myLottoIndex = 0;myLottoIndex<buyCount;myLottoIndex++){
            newLotto.add(new Lotto(LottoNumCreator.getLottoNumbers()));
        }
        return newLotto;
    }

    public static List<Lotto> publishLotto(List<Lotto> publishedLotto, int buyCount){
        for(int myLottoIndex = 0;myLottoIndex<buyCount;myLottoIndex++){
            publishedLotto.add(new Lotto(LottoNumCreator.getLottoNumbers()));
        }
        return publishedLotto;
    }
}
