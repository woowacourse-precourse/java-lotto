package lotto.controller;

import lotto.controller.converter.OrdinalResult;
import lotto.controller.converter.ResultMessage;
import lotto.controller.io.ConsoleLottoReader;
import lotto.domain.Player;

public class LootoStartGame {
    private final LottoManagement manager;
    private final ResultMessage resultMessage;
    private final Player player;

    public LootoStartGame() {
        this.manager = new LottoManagement(new ConsoleLottoReader());
        this.player = new Player();
        this.resultMessage = new OrdinalResult();
    }

    public void startGame() {
        manager.guideLottoGame(player);
        manager.setPlayerResult(player);

        resultMessage.printResult(player);
    }
}

