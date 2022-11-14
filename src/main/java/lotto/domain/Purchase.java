package lotto.domain;

import java.util.regex.Pattern;

public class Purchase {
    public static final int LOTTO_PRICE = 1000;

    private static final Pattern MONEY_REGEX = Pattern.compile("^[0-9]*$");

    private int ticketNumber;

    public Purchase(String input) {
        this.ticketNumber = calculateTicketNumber(input);
    }

    private int calculateTicketNumber(String input) {
        validateInputType(input);
        final int totalBudget = Integer.parseInt(input);
        validateTotalBudget(totalBudget);
        this.ticketNumber = totalBudget / LOTTO_PRICE;
        return ticketNumber;
    }

    private static void validateTotalBudget(int totalBudget) {
        verifyMinimumBudget(totalBudget);
        verifyUnitOfBudget(totalBudget);
    }

    private static void validateInputType(String input) {
        if (!MONEY_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    private static void verifyUnitOfBudget(int totalBudget) {
        if (totalBudget % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위로 가능합니다.");
        }
    }

    private static void verifyMinimumBudget(int totalBudget) {
        if (totalBudget < LOTTO_PRICE) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위로 가능합니다.");
        }
    }

    public int calculateTicketNumber() {
        return ticketNumber;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }
}
