package lotto.domain;

import java.util.List;

import lotto.constant.GameMessage;
import lotto.constant.LottoStatistic;
import lotto.exception.ExceptionHandler;
import lotto.userinterface.Output;

public class Player {
    private final long money;
    private List<Lotto> lottoTickets;

    public Player(long initialMoney) {
        validate(initialMoney);
        this.money = initialMoney;
    }

    private void validate(long money) {
        ExceptionHandler.isMultipleOf(money, LottoStatistic.LOTTO_PRICE.getValue());
    }

    public void buyLottoTickets(Machine lottoMachine) {
        this.lottoTickets = lottoMachine.issueLottoTickets(money);
    }

    public void displayLottoTickets() {
        int numberOfTickets = lottoTickets.size();
        Output.printMessage(GameMessage.LOTTO_PURCHASE.getMessage(numberOfTickets));
        for (Lotto lotto : lottoTickets) {
            Output.printMessage(lotto.getNumbersAsString());
        }
    }
}
