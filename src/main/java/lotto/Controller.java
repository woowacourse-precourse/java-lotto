package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String NOT_NUMBER_ERROR = "숫자가 아닙니다.";
    private static final String NOT_INSEPARABLE_ERROR = "구입 금액이 1000원 단위가 아닙니다.";

    public void start() {
        String amount, winningNumber;
        int ticketAmount, bonusNumber;
        List<Integer> winningNumbers;
        Lotto lotto;
        LottoNumbers lottoNumbers = new LottoNumbers();
        List<Lotto> lottoTickets = new ArrayList<>();

        amount = InputView.purchaseInputMessage();

        isValidateNumber(amount);
        isValidatePurchase(amount);

        ticketAmount = stringToIntegerConvert(amount);
        OutputView.lottoTicketAmountMessage(ticketAmount);

        for (int i = 0; i < ticketAmount; i++) {
            lotto = new Lotto(lottoNumbers.start());
            lottoTickets.add(lotto);
        }

        OutputView.printLottoTickets(lottoTickets);

        winningNumber = InputView.winningNumberInputMessage();
        winningNumbers = Winning.makeWinningNumberList(winningNumber);
        bonusNumber = Integer.parseInt(InputView.bonusNumberInputMessage());
        Winning.prize(lottoTickets, winningNumbers, bonusNumber);
    }

    private void isValidatePurchase(String userInput) {
        int amount = Integer.parseInt(userInput);

        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + NOT_INSEPARABLE_ERROR);
        }
    }

    private void isValidateNumber(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + NOT_NUMBER_ERROR);
        }
    }

    private int stringToIntegerConvert(String userInput) {
        int ticket = Integer.parseInt(userInput);

        return ticket / 1000;
    }
}
