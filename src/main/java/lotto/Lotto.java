package lotto;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Lotto {
    private static final String AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static String readPurchaseAmount() {
        String purchaseAmount;

        System.out.println(AMOUNT_MESSAGE);
        purchaseAmount = readLine();
        return (purchaseAmount);
    }
}
