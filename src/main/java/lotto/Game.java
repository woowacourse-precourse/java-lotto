package lotto;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final View view = new View();
    private final RandomGenerator randomGenerator = new RandomGenerator();
    private final List<Lotto> lottoTickets = new ArrayList<>();
    private Lotto winningNumbers;
    private int validAmount;
    private int bonusNumber;

    public Game() {
        view.printAmountInput();
    }

    public void startLotto() {

        if (!setAmount()) {
            return;
        }

        getLottoNumbers(validAmount / 1000);
        printLottoNumbers();
        getWinningNumbers();
        getBonusNumber();

    }

    public boolean setAmount() {
        int amount;

        amount = view.getAmount();

        if (amount == -1) {
            return false;
        }

        this.validAmount = amount;
        return true;
    }

    public void getLottoNumbers(int amount) {
        int count;
        Lotto ticket;

        for (count = 0; count < amount; count++) {
            ticket = new Lotto(randomGenerator.getRandomNumber());
            this.lottoTickets.add(ticket);
        }
    }

    public void printLottoNumbers() {
        int count;

        view.printNumberOfLotto(lottoTickets.size());

        for (count = 0; count < lottoTickets.size(); count++) {
            view.printEachLotto(lottoTickets.get(count).getNumbers());
        }
    }

    public void getWinningNumbers() {
        view.printGetWinningNumber();
        this.winningNumbers = new Lotto(view.getWinningNumber());

    }

    public void getBonusNumber() {
        view.printGetBonusNumber();
        this.bonusNumber = view.getBonusNumber();
    }

}
