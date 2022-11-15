package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String NOT_NUMBER_ERROR = " 숫자가 아닙니다.";
    private static final String NOT_INSEPARABLE_ERROR = " 구입 금액이 1000원 단위가 아닙니다.";

    public void start() {
        String amount;
        int ticketAmount;
        LottoNumbers lottoNumbers = new LottoNumbers();
        List<Lotto> lottoTickets = new ArrayList<>();

        amount = getAmount();
        ticketAmount = getTicketAmount(amount);

        saveLotto(ticketAmount, lottoNumbers, lottoTickets);
        sortLottoNumbers(ticketAmount, lottoTickets);
        OutputView.printLottoTickets(lottoTickets);
        makeRankOfLotto(amount, lottoTickets);
    }

    private void makeRankOfLotto(String amount, List<Lotto> lottoTickets) {
        String bonusNumber;
        List<Integer> winningNumbers;
        String winningNumber;

        winningNumber = InputView.winningNumberInputMessage();
        winningNumbers = Winning.makeWinningNumberList(winningNumber);
        bonusNumber = InputView.bonusNumberInputMessage();

        Winning.prize(lottoTickets, winningNumbers, bonusNumber, amount);
    }

    private void sortLottoNumbers(int ticketAmount, List<Lotto> lottoTickets) {
        for (int i = 0; i < ticketAmount; i++) {
            Collections.sort(lottoTickets.get(i).getNumbers());
        }
    }

    private void saveLotto(int ticketAmount, LottoNumbers lottoNumbers, List<Lotto> lottoTickets) {
        Lotto lotto;
        for (int i = 0; i < ticketAmount; i++) {
            lotto = new Lotto(lottoNumbers.start());
            lottoTickets.add(lotto);
        }
    }

    private int getTicketAmount(String amount) {
        int ticketAmount;

        ticketAmount = stringToIntegerConvert(amount);

        isValidatePurchase(ticketAmount);
        OutputView.lottoTicketAmountMessage(ticketAmount);

        return ticketAmount;
    }

    private String getAmount() {
        String amount;

        amount = InputView.purchaseInputMessage();
        isValidateNumber(amount);

        return amount;
    }

    public void isValidatePurchase(int userInput) {
        if (userInput % 1000 == 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + NOT_INSEPARABLE_ERROR);
        }
    }

    public void isValidateNumber(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            System.out.println(ERROR_MESSAGE + NOT_NUMBER_ERROR);
            throw new IllegalArgumentException();
        }
    }

    public int stringToIntegerConvert(String userInput) {
        int ticket = Integer.parseInt(userInput);
        ticket /= 1000;

        return ticket;
    }
}
