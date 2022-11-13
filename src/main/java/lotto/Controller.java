package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String PURCHASE_LOTTO = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_LOTTO_AMOUNT = "개를 구매했습니다.";
    private static final String NOT_NUMBER_ERROR = "숫자가 아닙니다.";
    private static final String NOT_INSEPARABLE_ERROR = "구입 금액이 1000원 단위가 아닙니다.";

    public void start() {
        String amount;
        int lottoTicketNumber;
        Lotto lotto;
        LottoNumbers lottoNumbers = new LottoNumbers();
        List<Lotto> lottoTickets = new ArrayList<>();

        amount = InputView.purchaseMessage();

        isValidateNumber(amount);
        isValidatePurchase(amount);

        lottoTicketNumber = stringToIntegerConvert(amount);
        OutputView.lottoTicketAmountMessage(lottoTicketNumber);

        for(int i = 0; i < lottoTicketNumber; i++) {
            lotto = new Lotto(lottoNumbers.start());
            lottoTickets.add(lotto);
        }

        OutputView.printLottoTickets(lottoTickets);
    }

    public void isValidatePurchase(String userInput) {
        int amount = Integer.parseInt(userInput);

        if(amount % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + NOT_INSEPARABLE_ERROR);
        }
    }

    public void isValidateNumber(String userInput) {
        try {
            Integer.parseInt(userInput);
        }catch(NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + NOT_NUMBER_ERROR);
        }
    }

    public int stringToIntegerConvert(String userInput) {
        int ticket = Integer.parseInt(userInput);

        return ticket / 1000;
    }
}
