package lotto;

import java.util.HashMap;
import java.util.List;

public class User {
    private final int purchaseMoney;
    private final int incomeMoney;
    private final HashMap<LottoRank, Integer> winResult;

    public User(int purchaseMoney, List<Lotto> lottoList, WinLotto winLotto) {
        validatePurchaseMoney(purchaseMoney);
        this.purchaseMoney = purchaseMoney;
        this.incomeMoney = getIncomeMoney(lottoList, winLotto);
        this.winResult = getWinResult(lottoList, winLotto);
    }

    public float getIncomePercent() {
        float incomePercent = (incomeMoney * 100) / (float) purchaseMoney;
        return Math.round(incomePercent * 100) / 100f;
    }

    public HashMap<LottoRank, Integer> getWinResult() {
        return this.winResult;
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
