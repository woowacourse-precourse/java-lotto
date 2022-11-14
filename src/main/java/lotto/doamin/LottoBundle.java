package lotto.doamin;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoBundle {
    private int count;
    private final List<Lotto> lottoList;

    public LottoBundle(int count) {
        this.count = count;
        this.lottoList = createLottoList();
    }


    private List<Lotto> createLottoList(){
        List<Lotto> lottoList1 = new ArrayList<>();
        while(this.count-->0){}
        return lottoList1;
    }
}
