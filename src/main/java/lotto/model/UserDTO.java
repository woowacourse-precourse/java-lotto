package lotto.model;

import lotto.controller.MakeGames;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {
    private int purchaseAmount;
    private int gameCount;
    private List<Lotto> games = new ArrayList<Lotto>();
    public UserDTO(int purchaseAmount) {
        checkMoney(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        this.gameCount = calculateGameCount(this.purchaseAmount);
        setGames(this.gameCount);
    }
    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    private int calculateGameCount(int purchaseAmount) {
        return purchaseAmount / 1000;
    }
    public int getGameCount() {
        return this.gameCount;
    }

    private void checkMoney(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로만 구입 가능합니다.");
        }
    }
    private void setGames(int gameCount) {
        MakeGames makeGames = new MakeGames(gameCount);
        makeGames.makeGames(games);
    }

    public List<Lotto> getGames() {
        return this.games;
    }
}
