package lotto.domain;

import java.util.ArrayList;

public class User {
    private ArrayList<Lotto> lotties;
    private ArrayList<Integer> totalNumberOflotties;
    private int purchaseMoney;
    private int prizeMoney;
    private ArrayList<Integer> winningNumbers;
    private int bonusNumber;

    public User() {
    }

    public ArrayList<Lotto> getLotties() {
        return lotties;
    }

    public void setLotties(ArrayList<Lotto> lotties) {
        this.lotties = lotties;
    }

    public ArrayList<Integer> getTotalNumberOflotties() {
        return totalNumberOflotties;
    }

    public void setTotalNumberOflotties(ArrayList<Integer> totalNumberOflotties) {
        this.totalNumberOflotties = totalNumberOflotties;
    }

    public int getPurchaseMoney() {
        return purchaseMoney;
    }

    public void setPurchaseMoney(int purchaseMoney) {
        this.purchaseMoney = purchaseMoney;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public void setPrizeMoney(int prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public ArrayList<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public void setWinningNumbers(ArrayList<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
