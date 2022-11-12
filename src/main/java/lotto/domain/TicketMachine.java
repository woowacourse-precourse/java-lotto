package lotto.domain;

public class TicketMachine {
    private static final String ERROR_MESSAGE = "[ERROR] 유효하지 않은 금액입니다. ";
    private static final int TICKET_PRICE = 1000;

    public Integer getTicket(int payment) {
        validatePayment(payment);
        return payment / TICKET_PRICE;
    }

    public static Integer getTicketPrice() {
        return TICKET_PRICE;
    }

    private void validatePayment(int payment) {
        if (validatePositive(payment) && validatePrice(payment)) {
            return;
        }
        throw new IllegalArgumentException(ERROR_MESSAGE);
    }

    private boolean validatePositive(int payment) {
        if (payment > 0) {
            return true;
        }
        return false;
    }

    private boolean validatePrice(int payment) {
        if (payment % TICKET_PRICE == 0) {
            return true;
        }
        return false;
    }
}
