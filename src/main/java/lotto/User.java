package lotto;

import java.util.HashMap;
import java.util.List;

public class User {
    private final int purchaseMoney;
    private final int incomeMoney;
    private final List<Lotto> lottoList;
    private HashMap<LottoRank, Integer> winResult;

    public User(int purchaseMoney, List<Lotto> lottoList, WinLotto winLotto) {
        validatePurchaseMoney(purchaseMoney);
        this.purchaseMoney = purchaseMoney;
        this.lottoList = lottoList;
        // TODO: initializing incomeMoney
        this.incomeMoney = 0;
    }

    private void validatePurchaseMoney(int purchaseMoney) {
        if (purchaseMoney < 0) {
            System.out.println("[ERROR] 로또 구입 금액은 0보다 크거나 같아야 합니다.");
            throw new IllegalArgumentException();
        }
        if (purchaseMoney / 1000 != 0) {
            System.out.println("[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다.");
            throw new IllegalArgumentException();
        }
    }
}
