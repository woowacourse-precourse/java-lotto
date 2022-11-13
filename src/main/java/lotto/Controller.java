package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Controller {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String PURCHASE_LOTTO = "구입금액을 입력해 주세요.";
    private static final String NOT_NUMBER = "숫자가 아닙니다.";
    private static final String NOT_INSEPARABLE = "구입 금액이 1000원 단위가 아닙니다.";
    private static final String PURCHASE_LOTTO_AMOUNT = "개를 구매했습니다.";

    public void start() {
        String amount;
        int lottoTicketNumber;

        purchaseMessage();
        amount = readLine();

        isValidateNumber(amount);
        isValidatePurchase(amount);

        lottoTicketNumber = lottoTicketNumber(amount);
        ticketPurchaseMessage(lottoTicketNumber);
    }

    public void isValidatePurchase(String userInput) {
        int amount = Integer.parseInt(userInput);

        if(amount % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + NOT_INSEPARABLE);
        }
    }

    public void isValidateNumber(String userInput) {
        try {
            Integer.parseInt(userInput);
        }catch(NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + NOT_NUMBER);
        }
    }

    public int lottoTicketNumber(String userInput) {
        int ticket = Integer.parseInt(userInput);

        return ticket / 1000;
    }

    public void purchaseMessage() {
        System.out.println(PURCHASE_LOTTO);
    }

    public void ticketPurchaseMessage(int ticket) {
        System.out.println(ticket+PURCHASE_LOTTO_AMOUNT);
    }
}
