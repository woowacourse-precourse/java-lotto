package lotto.Model;

public class Purchase {
    private String input;
    private int money;
    private int lottoCount;

    public Purchase(int money) {
        this.money = money;
        checkLottoCount();
    }

    void checkLottoCount() {
        this.lottoCount = money / 1000;
    }

    public int getLottoCount() {
        return this.lottoCount;
    }

    public int getCost() {
        return this.money;
    }
}
