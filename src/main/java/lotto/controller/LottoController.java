package lotto.controller;

import lotto.domain.player.Player;
import lotto.domain.game.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void start(){
        Player player = buyLotto();
    }

    public Player buyLotto(){
        int playerInputMoney = InputView.inputMoney();
        Player player = new Player(playerInputMoney);
        OutputView.printLottoTickets(player);
        return player;
    }
}
