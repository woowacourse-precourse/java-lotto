package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.LottoStore;
import lotto.model.PlayerNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        try {
            LottoStore lottoStore = LottoStore.buyTicketsByBudget(inputView.readBudget());
            outputView.printTicketNumber(lottoStore.getTicketNumber());

            List<PlayerNumber> playerNumbers = new ArrayList<>();
            for (int i = 0; i < lottoStore.getTicketNumber(); i++) {
                PlayerNumber playerNumber = PlayerNumber.createAutoLotto();
                playerNumbers.add(playerNumber);
                System.out.println(playerNumber.getPlayerNumber());
            }

        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
        }
    }

}
