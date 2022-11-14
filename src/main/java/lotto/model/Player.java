package lotto.model;

import lotto.service.LottoService;
import lotto.view.OutputView;

import static lotto.service.LottoService.LOTTO_ONE_PRICE;

public class Player {
    private int purchaseAmount;
    private int ticketNumber;
    private final String PURCHASE_AMOUNT_ERROR = "[ERROR] 구매 금액은 1000 단위의 숫자여야 합니다.";

    public Player(String amountString) {
        validate(amountString);
        ticketNumber = purchaseAmount / LOTTO_ONE_PRICE;
    }

    public void validate(String purchaseAmountString) {
        try {
            int purchaseAmount = Integer.parseInt(purchaseAmountString);
            if (purchaseAmount < 0 || purchaseAmount % LOTTO_ONE_PRICE != 0) {
                throw new IllegalArgumentException();
            }
            this.purchaseAmount = purchaseAmount;
        } catch (IllegalArgumentException e) {
            LottoService.status = LottoService.ERROR_STATUS;
            OutputView.printError(PURCHASE_AMOUNT_ERROR);
        }
    }

    public int getPurchaseAmount() {

        return purchaseAmount;
    }

    public int getTicketNumber() {

        return ticketNumber;
    }
}
