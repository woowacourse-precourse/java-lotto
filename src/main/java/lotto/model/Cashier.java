package lotto.model;

import java.util.List;

public class Cashier {
    private int receivedMoney;
    private List<Integer> answerNumber;
    private int bonusNumber;

    public void inputPlayerMoney(int receivedMoney) {
        this.receivedMoney = receivedMoney;
    }

    public void inputPlayerAnswerNumber(List<Integer> answerNumber) {
        this.answerNumber = answerNumber;
    }
    
}

