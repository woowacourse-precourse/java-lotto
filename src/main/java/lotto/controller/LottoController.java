package lotto.controller;

import lotto.domain.player.Player;
import lotto.domain.game.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    public void start(){
        Player player = buyLotto();
        Lotto winningLotto = inputWinningLotto();
    }

    public Player buyLotto(){
        int playerInputMoney = InputView.inputMoney();
        Player player = new Player(playerInputMoney);
        OutputView.printLottoTickets(player);
        return player;
    }

    public Lotto inputWinningLotto(){
        List<Integer> inputWinningNumber = InputView.inputWinningNumber();
        Lotto lotto = new Lotto(inputWinningNumber);
        int inputBonusNumber = InputView.inputBonusNumber();
        lotto.setBonusNumber(inputBonusNumber);
        return lotto;
    }
}
