package lotto.domain;

import java.util.List;

public class Bag {
    private int amount;
    private List<Lotto> lottos;
    private Receipt receipt;

    public int getAmount() {
        return getAmount();
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }
}