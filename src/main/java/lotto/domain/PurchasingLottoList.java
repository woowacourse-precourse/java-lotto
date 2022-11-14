package lotto.domain;

import java.util.List;

public class PurchasingLottoList {
    private NumberGenerator numberGenerator = new NumberGenerator();
    private List<List<Integer>> lottoList;

    public PurchasingLottoList(int ticketCount){
        this.lottoList = numberGenerator.createRandomNumbers(ticketCount);
    }


}
