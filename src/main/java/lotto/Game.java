package lotto;

import lotto.domain.Lotto;
import lotto.domain.Player;

public class Game {
    private final Player player;

    public Game() {
        player = new Player();
    }

    public void start() {
        player.getPurchaseCost();
        player.purchaseLotto();
    }
}
