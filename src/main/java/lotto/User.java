package lotto;

import java.util.HashMap;
import java.util.List;

public class User {
    private final int purchaseMoney;
    private final int incomeMoney;
    private final List<Lotto> lottoList;
    private final HashMap<LottoRank, Integer> winResult;

    public User(int purchaseMoney, List<Lotto> lottoList, WinLotto winLotto) {
        validatePurchaseMoney(purchaseMoney);
        this.purchaseMoney = purchaseMoney;
        this.incomeMoney = getIncomeMoney(lottoList, winLotto);
        this.lottoList = lottoList;
        this.winResult = getWinResult(lottoList, winLotto);
    }

    private void validatePurchaseMoney(int purchaseMoney) {
        if (purchaseMoney < 0) {
            System.out.println("[ERROR] 로또 구입 금액은 0보다 크거나 같아야 합니다.");
            throw new IllegalArgumentException();
        }
        if (purchaseMoney % 1000 != 0) {
            System.out.println("[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private int getIncomeMoney(List<Lotto> lottoList, WinLotto winLotto) {
        int incomeMoney = 0;
        for (Lotto lotto : lottoList) {
            LottoRank rank = LottoDraw.getLottoRank(lotto, winLotto);
            incomeMoney += rank.getWinPrice();
        }
        return incomeMoney;
    }

    private HashMap<LottoRank, Integer> getWinResult(List<Lotto> lottoList, WinLotto winLotto) {
        HashMap<LottoRank, Integer> winResult = new HashMap<>();
        for (Lotto lotto : lottoList) {
            LottoRank rank = LottoDraw.getLottoRank(lotto, winLotto);
            winResult.merge(rank, 1, Integer::sum);
        }
        return winResult;
    }
}
