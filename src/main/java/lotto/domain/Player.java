package lotto.domain;

import java.util.List;

import lotto.constant.LottoStatistic;
import lotto.exception.ExceptionHandler;

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
        this.lottoTickets = lottoMachine.issueLottoTickets(this.money);
    }
}
