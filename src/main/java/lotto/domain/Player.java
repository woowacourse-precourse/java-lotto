package lotto.domain;

import java.util.List;

import lotto.constant.GameMessage;
import lotto.constant.LottoStatistic;
import lotto.exception.ExceptionHandler;
import lotto.userinterface.Output;

public class Player {
    private final long initialMoney;
    private List<Lotto> lottoTickets;
    private final PrizeCalculator prizeCalculator;

    public Player(long initialMoney) {
        validate(initialMoney);
        this.initialMoney = initialMoney;
        prizeCalculator = new PrizeCalculator();
    }

    private void validate(long money) {
        ExceptionHandler.isMultipleOf(money, LottoStatistic.LOTTO_PRICE.getValue());
    }

    public void buyLottoTickets(Machine lottoMachine) {
        this.lottoTickets = lottoMachine.issueLottoTickets(initialMoney);
        displayLottoTickets();
    }

    private void displayLottoTickets() {
        int numberOfTickets = lottoTickets.size();
        Output.printMessage(GameMessage.LOTTO_PURCHASE.getMessage(numberOfTickets));
        for (Lotto lotto : lottoTickets) {
            Output.printMessage(lotto.getNumbersAsSortedString());
        }
    }

    public void checkResult(Organizer organizer) {
        List<Integer> winningNumbers = organizer.getWinningNumbers();
        int bonusNumber = organizer.getBonusNumber();
        for (Lotto lotto : lottoTickets) {
            prizeCalculator.getResultForLotto(lotto, winningNumbers, bonusNumber);
        }
        prizeCalculator.printPrizeResult();
        displayProfitRate();
    }

    private void displayProfitRate() {
        double profitRate = prizeCalculator.calculateProfitRate(initialMoney);
        Output.printMessage(GameMessage.PROFIT_RATE.getMessage(profitRate));
    }
}
