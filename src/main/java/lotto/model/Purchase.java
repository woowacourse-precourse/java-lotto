package lotto.model;

import static lotto.util.Constants.LOTTO_PRICE;
import static lotto.util.ErrorMessage.ERROR_PURCHASE_MINIMUM_BUDGET;
import static lotto.util.ErrorMessage.ERROR_PURCHASE_TYPE;
import static lotto.util.ErrorMessage.ERROR_PURCHASE_UNIT_OF_BUDGET;

import java.util.regex.Pattern;
import lotto.util.Formatter;

public class Purchase {
    private static final Pattern MONEY_REGEX = Pattern.compile("^[0-9]*$");

    private int ticketNumber;

    public Purchase(String input) {
        setTicketNumber(Formatter.removeSpace(input));
        this.ticketNumber = getTicketNumber();
    }

    private void setTicketNumber(String input) {
        validateInputType(input);
        int totalBudget = Integer.parseInt(input);
        validateTotalBudget(totalBudget);
        this.ticketNumber = calculateTicketNumber(totalBudget);
    }

    private static void validateInputType(String input) {
        if (!MONEY_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(ERROR_PURCHASE_TYPE);
        }
    }

    private static void validateTotalBudget(int totalBudget) {
        verifyMinimumBudget(totalBudget);
        verifyUnitOfBudget(totalBudget);
    }

    private static void verifyMinimumBudget(int totalBudget) {
        if (totalBudget < LOTTO_PRICE) {
            throw new IllegalArgumentException(ERROR_PURCHASE_MINIMUM_BUDGET);
        }
    }

    private static void verifyUnitOfBudget(int totalBudget) {
        if (totalBudget % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_PURCHASE_UNIT_OF_BUDGET);
        }
    }

    private static int calculateTicketNumber(int totalBudget) {
        return totalBudget / LOTTO_PRICE;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

}
