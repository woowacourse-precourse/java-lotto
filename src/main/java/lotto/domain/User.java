package lotto.domain;

import java.util.ArrayList;

public class User {
    private ArrayList<Lotto> lotties;
    private int totalNumberOflotties;
    private int purchaseMoney;
    private int prizeMoney;
    private Lotto winningNumbers;
    private int bonusNumber;
    private ArrayList<Integer> numberOfWinningTypes;

    public User() {
    }

    public ArrayList<Integer> getNumberOfWinningTypes() {
        return numberOfWinningTypes;
    }

    public void setNumberOfWinningTypes(ArrayList<Integer> numberOfWinningTypes) {
        this.numberOfWinningTypes = numberOfWinningTypes;
    }

    public ArrayList<Lotto> getLotties() {
        return lotties;
    }

    public void setLotties(ArrayList<Lotto> lotties) {
        this.lotties = lotties;
    }

    public int getTotalNumberOflotties() {
        return totalNumberOflotties;
    }

    public void setTotalNumberOflotties(int totalNumberOflotties) {
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

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public void setWinningNumbers(Lotto winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
