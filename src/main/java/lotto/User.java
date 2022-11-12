package lotto;

import java.util.HashMap;
import java.util.List;

public class User {
    private final int purchaseMoney;
    private final int incomeMoney;
    private final List<Lotto> lottoList;
    private HashMap<LottoRank, Integer> winResult;

    public User(int purchaseMoney, List<Lotto> lottoList, WinLotto winLotto) {
        // TODO: validate purchaseMoney
        this.purchaseMoney = purchaseMoney;
        this.lottoList = lottoList;
        // TODO: initializing incomeMoney
        this.incomeMoney = 0;
    }
}
