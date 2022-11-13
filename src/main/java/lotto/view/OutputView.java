package lotto.view;

public class OutputView {
    public static final String TICKET_COUNT = "개를 구매했습니다.";
    public static void printTicketCount(int count){
        System.out.println(count + TICKET_COUNT);
    }
}
