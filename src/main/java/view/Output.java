package view;

public class Output {
    private static final String OUTPUT_TICKET_COUNT = "개를 구매했습니다.";
    public static void outputTicketCount(int count) {
        System.out.println(count + OUTPUT_TICKET_COUNT);
    }
}
