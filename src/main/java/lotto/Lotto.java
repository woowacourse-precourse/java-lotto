package lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Lotto {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String INVALID_PURCHASE_AMOUNT_MESSAGE = ERROR_MESSAGE + " 구매 금액은 1,000원 단위여야 합니다.";
    private static final char INVALID_MOST_SIGNIFICANT_DIGIT = '0';
    private static final int SMALLEST_UNIT = 1000;
    private static final int SMALLEST_LOTTERY_NUMBER = 1;
    private static final int BIGGEST_LOTTERY_NUMBER = 45;
    private static final int LOTTERY_NUMBER_COUNT = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTERY_NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
    }

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

    private void validatePurchaseAmount(String purchaseAmount) {
        if (!isDigits(purchaseAmount) || !isValidFormat(purchaseAmount) || !isMultipleOfThousand(purchaseAmount))
            throw (new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_MESSAGE));
    }

    public String readPurchaseAmount() {
        String purchaseAmount;

        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        purchaseAmount = readLine();
        validatePurchaseAmount(purchaseAmount);
        return (purchaseAmount);
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
}
