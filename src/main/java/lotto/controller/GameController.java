package lotto.controller;

import lotto.domain.Computer;
import lotto.domain.GameResult;
import lotto.domain.Lotto;
import lotto.domain.Player;

import java.util.List;

public class GameController {
    private final Player player;
    private final Computer computer;
    private final GameResult gameResult;

    public GameController() {
        player = new Player();
        computer = new Computer();
        gameResult = new GameResult();
    }

    public void run() {
        List<Lotto> lottos = player.getLottos();
        List<Integer> winningNumbers = computer.getWinningNumbers();
        int bonusNumber = computer.getBonusNumber();

        gameResult.calculateTotalResult(lottos, winningNumbers, bonusNumber);
        gameResult.calculateProfitRate(player.getLottos().size());
        gameResult.printTotalResult();
    }
}
