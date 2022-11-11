package lotto.model;

import java.util.List;

public class UserData {
    private int purchaseAmount;
    private int gameCount;
    private List<Lotto> games;

    UserData(int purchaseAmount) {
        checkMoney(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        this.gameCount = calculateGameCount(this.purchaseAmount);
        this.games = makeLottoGame(this.gameCount);
    }

    private int calculateGameCount(int purchaseAmount) {
        return purchaseAmount / 1000;
    }

    private void checkMoney(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로만 구입 가능합니다.");
        }
    }
    private List<Lotto> makeLottoGame(int gameCount) {
        return null;
    }
}
