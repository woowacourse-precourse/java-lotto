package lotto.view;

import lotto.model.numbers.PlayerNumber;
import lotto.model.numbers.PlayerNumbers;

public class OutputView {

    private enum ConsoleMessage {
        TICKET_NUMBER("%d개를 구매했습니다.\n");
        private final String message;

        ConsoleMessage(String message) {
            this.message = message;
        }

    }

    public void printExceptionMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public void printTicketNumber(int ticketNumber) {
        System.out.printf(ConsoleMessage.TICKET_NUMBER.message, ticketNumber);
    }

    public void printPlayerNumbers(PlayerNumbers playerNumbers) {
        for (PlayerNumber playerNumber : playerNumbers.getPlayerNumbers()) {
            System.out.println(playerNumber.toString());
        }
    }
}
