package lotto;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    private static final char INVALID_MOST_SIGNIFICANT_DIGIT = '0';
    private static final int SMALLEST_MONETARY_UNIT = 1000;
    private static final int SMALLEST_LOTTERY_NUMBER = 1;
    private static final int BIGGEST_LOTTERY_NUMBER = 45;
    private static final int LOTTERY_NUMBER_COUNT = 6;

    private List<Lotto> boughtTickets;
    private int[] winningCounts = {0, 0, 0, 0, 0};

    public Buyer(String purchaseAmount) {
        validateBeingDigits(purchaseAmount);
        validateFormat(purchaseAmount);
        validateBeingMultipleOfThousand(purchaseAmount);
        pickLotteryNumbers(Integer.parseInt(purchaseAmount) / SMALLEST_MONETARY_UNIT);
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
        if (Integer.parseInt(userInput) % SMALLEST_MONETARY_UNIT != 0) {
            throw (new IllegalArgumentException(ExceptionMessage.PURCHASE_AMOUNT_EXCEPTION
                    .toString()));
        }
    }

    private void sortLotteryNumbers(List<Lotto> tickets) {
        for (Lotto ticket : tickets) {
            ticket.sortNumbers();
        }
    }

    public void pickLotteryNumbers(int ticketCount) {
        boughtTickets = new ArrayList<>();

        for (int i = 0; i < ticketCount; i++) {
            boughtTickets.add(new Lotto(
                    pickUniqueNumbersInRange(SMALLEST_LOTTERY_NUMBER, BIGGEST_LOTTERY_NUMBER, LOTTERY_NUMBER_COUNT)
            ));
        }
        sortLotteryNumbers(boughtTickets);
    }

    private void checkIfWon(int correctCount, int bonusCount) {
        if (correctCount == 3 || correctCount == 4) {
            winningCounts[correctCount - 3] += 1;
            return ;
        }
        if (correctCount == 5) {
            winningCounts[correctCount - 3 + bonusCount] += 1;
            return ;
        }
        if (correctCount == 6) {
            winningCounts[correctCount - 4] += 1;
        }
    }

    public void checkBoughtTickets(Lotto winningNumbers, int bonus) {
        int correctCount = 0;
        int bonusCount = 0;

        for (Lotto ticket : boughtTickets) {
            correctCount = winningNumbers.countCorrectNumbers(ticket);
            bonusCount = ticket.checkIfCorrectNumber(bonus);
        }
        checkIfWon(correctCount, bonusCount);
    }
}