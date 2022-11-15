package lotto.controller;

import lotto.controller.converter.BasicResultMessage;
import lotto.controller.converter.ResultMessage;
import lotto.controller.io.ConsoleLottoReader;
import lotto.domain.Player;

public class LottoGame {
    private final LottoManager manager;
    private final ResultMessage resultMessage;
    private final Player player;

    public LottoGame() {
        this.manager = new LottoManager(new ConsoleLottoReader());
        this.player = new Player();
        this.resultMessage = new BasicResultMessage();
    }

    public void startGame() {
        manager.guideLottoGame(player);
        manager.setPlayerResult(player);

        resultMessage.printResult(player);
    }
}

