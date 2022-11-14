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

    public void inputPlayerBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public int getReceivedMoney() {
        return receivedMoney;
    }

    public List<Integer> getAnswerNumber() {
        return answerNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}

