package lotto.doamin;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoBundle {
    private int cost;
    private final List<Lotto> lottoList;

    public LottoBundle(int cost) {
        validate(cost);
        this.cost = cost;
        this.lottoList = createLottoList();
    }

    private void validate(int cost) {
        //TODO: 범위확인
    }
    private List<Lotto> createLottoList(){
        List<Lotto> lottoList1 = new ArrayList<>();
        int count = this.cost/1000;
        while(count-->0){}
        return lottoList1;
    }
}
