package lotto.domain;

import java.util.List;

import lotto.constant.GameMessage;
import lotto.constant.LottoStatistic;
import lotto.exception.ExceptionHandler;
import lotto.userinterface.Output;

public class Player {
    private final long initialMoney;
    private List<Lotto> lottoTickets;
    private long prizeMoney;

    public Player(long initialMoney) {
        validate(initialMoney);
        this.initialMoney = initialMoney;
        this.prizeMoney = 0;
    }

    private void validate(long money) {
        ExceptionHandler.isMultipleOf(money, LottoStatistic.LOTTO_PRICE.getValue());
    }

    public void buyLottoTickets(Machine lottoMachine) {
        this.lottoTickets = lottoMachine.issueLottoTickets(initialMoney);
    }

    public void displayLottoTickets() {
        int numberOfTickets = lottoTickets.size();
        Output.printMessage(GameMessage.LOTTO_PURCHASE.getMessage(numberOfTickets));
        for (Lotto lotto : lottoTickets) {
            Output.printMessage(lotto.getNumbersAsString());
        }
    }

    /*public void checkResult(Organizer organizer) {
        List<Integer> winningNumbers = organizer.getWinningNumbers();
        int bonusNumber = organizer.getBonusNumber();
        for (Lotto lotto : lottoTickets) {
            int matchingCount = compareWinningNumbers(lotto, winningNumbers);

        }
    }*/

    public int compareWinningNumbers(Lotto lotto, List<Integer> winningNumbers) {
        int count = 0;
        for (int number : winningNumbers) {
            if (lotto.doesContainNumber(number)){
                count++;
            }
        }
        return count;
    }
}
