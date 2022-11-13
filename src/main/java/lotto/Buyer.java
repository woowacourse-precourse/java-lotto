package lotto;

import java.util.List;

public class Buyer {
    private int seedMoney;
    private int totalMoney;
    private float rate;
    private List<Lotto> myLottos;
    private List<Integer> myPrize;

    public void buyLotto() {
        inputSeedMoney();
        validateSeedMoney();
    }

    private void inputSeedMoney() {
        this.seedMoney = seedMoney;
    }

    private void printInputSeedMoney() {
        System.out.println("");
    }

    private void validateSeedMoney() {
    }

    public void checkPrize() {
        requestPrizeToStore();
    }

    private void requestPrizeToStore() {
    }

    private void printPrize() {
        System.out.println("");
    }

    public void checkRate() {
    }

    private void calcRate() {
    }

    private void roundRate() {
    }

    private void printRate() {
        System.out.println("");
    }
}