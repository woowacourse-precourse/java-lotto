package model;

import java.util.List;

public class User {
    private List<Lotto> boughtLottos;
    private Purchase purchase;

    public User(List<Lotto> boughtLottos, Purchase purchase) {
        this.boughtLottos = boughtLottos;
        this.purchase = purchase;
    }

    public List<Lotto> getBoughtLottos() {
        return boughtLottos;
    }

    public Purchase getPurchase() {
        return purchase;
    }
}
