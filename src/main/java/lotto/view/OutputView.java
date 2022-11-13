package lotto.view;

public class OutputView {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String LOTTO_TICKET_AMOUNT = "개를 구매했습니다.";

    public static void lottoTicketAmountMessage(int ticket) {
        System.out.println(ticket+LOTTO_TICKET_AMOUNT);
    }
}
