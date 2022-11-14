package lotto.domain;

import java.util.List;

public class User {

    private int purchaseMoney;
    private int purchaseLottoPiece;
    private List<Lotto> purchaseLotto;

    public User(int purchaseMoney, int purchaseLottoPiece, List<Lotto> purchaseLotto) {
        this.purchaseMoney = purchaseMoney;
        this.purchaseLottoPiece = purchaseLottoPiece;
        this.purchaseLotto = purchaseLotto;
    }

    public int getPurchaseMoney() {
        return purchaseMoney;
    }

    public int getPurchaseLottoPiece() {
        return purchaseLottoPiece;
    }

    public List<Lotto> getPurchaseLotto() {
        return purchaseLotto;
    }
}
