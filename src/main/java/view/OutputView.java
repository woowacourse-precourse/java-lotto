package view;

public class OutputView {
    public static final String TICKET_PURCHASED_MESSAGE = "개를 구매했습니다.";

    public static void printTicketPurchasedMessage(int count) {
        System.out.println(count + TICKET_PURCHASED_MESSAGE);
    }
}
