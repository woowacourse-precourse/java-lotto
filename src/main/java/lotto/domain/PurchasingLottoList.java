package lotto.domain;

import java.util.List;

public class PurchasingLottoList {
    private NumberGenerator numberGenerator = new NumberGenerator();
    private List<List<Integer>> lottoList;
    private int numberOfTicket;

    public PurchasingLottoList(int money){
        moneyToTicket(money);
        this.lottoList = numberGenerator.createRandomNumbers(numberOfTicket);
    }
    public List<List<Integer>> getLottoList() {
        return lottoList;
    }

    public void moneyToTicket(int money){
        if(money % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력하세요.");
        }

        this.numberOfTicket = money / 1000;
    }

    public int getNumberOfTicket() {
        return numberOfTicket;
    }
}
