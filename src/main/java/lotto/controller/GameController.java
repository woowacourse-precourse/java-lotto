package lotto.controller;

import lotto.domain.Computer;
import lotto.domain.GameResult;
import lotto.domain.Player;

public class GameController {
    private final Player player;
    private final Computer computer;
    private final GameResult gameResult;

    public GameController() {
        player = new Player();
        computer = new Computer();
        gameResult = new GameResult();
    }
}
