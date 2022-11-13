package lotto.view;

import java.util.List;

public class OutputView {

    private static final String TICKET_NUMBER_MESSAGE = "개를 구매했습니다.";

    public static void printTicketNumber(int number) {
        System.out.println(number + TICKET_NUMBER_MESSAGE);
    }

    public static void printTickets(List<Integer> numbers) {
        System.out.println(numbers);
    }
}
