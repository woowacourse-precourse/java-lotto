package lotto.domain;

import java.util.List;

public class PurchasingLottoList {
    Message message = null;
    private NumberGenerator numberGenerator = new NumberGenerator();
    private List<List<Integer>> lottoList;
    private int numberOfTicket;

    public PurchasingLottoList(int money) {
        moneyToTicket(money);
        this.lottoList = numberGenerator.createRandomNumbers(numberOfTicket);
    }

    public List<List<Integer>> getLottoList() {
        return lottoList;
    }

    public void moneyToTicket(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(message.ERROR_MESSAGE_INVALID_INPUT_MONEY_1000_UNIT.getMessage());
        }

        this.numberOfTicket = money / 1000;
    }

    public int getNumberOfTicket() {
        return numberOfTicket;
    }
}
