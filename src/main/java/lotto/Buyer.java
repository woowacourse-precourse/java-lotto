package lotto;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Buyer {
    private enum ErrorMessage {
        INVALID_PURCHASE_AMOUNT("구매 금액은 1000원 이상, 1000원의 배수여야 합니다.");

        private final String MESSAGE;
        private final String ERROR_INDICATOR = "[ERROR] ";


        ErrorMessage(final String message) {
            this.MESSAGE = message;
        }
        @Override
        public String toString() {
            return (ERROR_INDICATOR + this.MESSAGE);
        }
    }
    private static final char INVALID_MOST_SIGNIFICANT_DIGIT = '0';
    private static final int SMALLEST_UNIT = 1000;
    private static final int SMALLEST_LOTTERY_NUMBER = 1;
    private static final int BIGGEST_LOTTERY_NUMBER = 45;
    private static final int LOTTERY_NUMBER_COUNT = 6;


    private boolean isDigits(String userInput) {
        int len = userInput.length();
        int i = 0;

        while (i < len && Character.isDigit(userInput.charAt(i))) {
            i++;
        }
        return (i == len);
    }

    private boolean isValidFormat(String userInput) {
        return (userInput.charAt(0) != INVALID_MOST_SIGNIFICANT_DIGIT);
    }

    private boolean isMultipleOfThousand(String userInput) {
        return (Integer.parseInt(userInput) % SMALLEST_UNIT == 0);
    }

    public void validatePurchaseAmount(String purchaseAmount) {
        if (!isDigits(purchaseAmount) || !isValidFormat(purchaseAmount) || !isMultipleOfThousand(purchaseAmount))
            throw (new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT
                    .toString()));
    }

    public List<List<Integer>> pickLotteryNumbers(int ticketCount) {
        List<List<Integer>> lotteryTickets = new ArrayList<>();

        for (int i = 0; i < ticketCount; i++) {
            lotteryTickets.add(
                    pickUniqueNumbersInRange(SMALLEST_LOTTERY_NUMBER, BIGGEST_LOTTERY_NUMBER, LOTTERY_NUMBER_COUNT)
            );
        }
        return (lotteryTickets);
    }

    public void sortLotteryNumbers(List<List<Integer>> tickets) {
        for (List<Integer> ticket : tickets) {
            Collections.sort(ticket);
        }
    }
}
