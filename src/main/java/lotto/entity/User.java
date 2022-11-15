package lotto.entity;

import java.util.HashMap;
import java.util.List;

public class User {
    private int purchaseMoney;
    private List<Integer> userNumber;
    private int bonusNumber;
    private int lottoAmount;
    private double yield;
    private HashMap<Integer, Integer> winning = new HashMap<>(){
        {
            put(1, 0);
            put(2, 0);
            put(3, 0);
            put(4, 0);
            put(5, 0);
        }
    };


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

    public double getYield() {
        return yield;
    }

    public void setYield(double yield) {
        this.yield = yield;
    }

    public HashMap<Integer, Integer> getWinning() {
        return winning;
    }

    public void setWinning(HashMap<Integer, Integer> winning) {
        this.winning = winning;
    }
}
