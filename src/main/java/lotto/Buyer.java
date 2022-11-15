package lotto;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Buyer {
    private static final char INVALID_MOST_SIGNIFICANT_DIGIT = '0';
    private static final int SMALLEST_UNIT = 1000;
    private static final int SMALLEST_LOTTERY_NUMBER = 1;
    private static final int BIGGEST_LOTTERY_NUMBER = 45;
    private static final int LOTTERY_NUMBER_COUNT = 6;

    private int purchaseAmount;
    private List<List<Integer>> boughtTickets;

    public Buyer(String purchaseAmount) {
        validateBeingDigits(purchaseAmount);
        validateFormat(purchaseAmount);
        validateBeingMultipleOfThousand(purchaseAmount);
        this.purchaseAmount = Integer.parseInt(purchaseAmount);
    }

    private void validateBeingDigits(String userInput) {
        int len = userInput.length();
        int i = 0;

        while (i < len && Character.isDigit(userInput.charAt(i))) {
            i++;
        }
        if (i != len) {
            throw (new IllegalArgumentException(ExceptionMessage.PURCHASE_AMOUNT_EXCEPTION
                    .toString()));
        }
    }

    private void validateFormat(String userInput) {
        if (userInput.charAt(0) == INVALID_MOST_SIGNIFICANT_DIGIT) {
            throw (new IllegalArgumentException(ExceptionMessage.PURCHASE_AMOUNT_EXCEPTION
                    .toString()));
        }
    }

    private void validateBeingMultipleOfThousand(String userInput) {
        if (Integer.parseInt(userInput) % SMALLEST_UNIT != 0) {
            throw (new IllegalArgumentException(ExceptionMessage.PURCHASE_AMOUNT_EXCEPTION
                    .toString()));
        }
    }

    private void sortLotteryNumbers(List<List<Integer>> tickets) {
        for (List<Integer> ticket : tickets) {
            Collections.sort(ticket);
        }
    }

    public void pickLotteryNumbers() {
        boughtTickets = new ArrayList<>();
        int ticketCount = purchaseAmount / 1000;

        for (int i = 0; i < ticketCount; i++) {
            boughtTickets.add(
                    pickUniqueNumbersInRange(SMALLEST_LOTTERY_NUMBER, BIGGEST_LOTTERY_NUMBER, LOTTERY_NUMBER_COUNT)
            );
        }
        sortLotteryNumbers(boughtTickets);
    }
}
