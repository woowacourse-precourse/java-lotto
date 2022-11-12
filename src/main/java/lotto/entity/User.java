package lotto.entity;

import java.util.List;

public class User {
    private int purchaseMoney;
    private List<Integer> userNumber;
    private int bonusNumber;
    private int lottoAmount;
    public User(){}

    public List<Integer> getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(List<Integer> userNumber) {
        this.userNumber = userNumber;
    }

    public int getPurchaseMoney() {
        return purchaseMoney;
    }

    public void setPurchaseMoney(int purchaseMoney) {
        this.purchaseMoney = purchaseMoney;
    }

    public int getLottoAmount() {
        return lottoAmount;
    }

    public void setLottoAmount(int lottoAmount) {
        this.lottoAmount = lottoAmount;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
