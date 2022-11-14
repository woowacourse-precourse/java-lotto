package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InvalidNumbersFormatException;
import lotto.exception.NotNumberInputException;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {

    private static final String PAYMENT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LUCKY_BALLS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final Pattern PATTERN = Pattern.compile("^[\\d]+,[\\d]+,[\\d]+,[\\d]+,[\\d]+,[\\d]+$");
    private static final String SEPARATOR = ",";

    public static int inputPayment() {
        System.out.println(PAYMENT_MESSAGE);

        String input = Console.readLine();

        try {
            validate(input);
        } catch (Exception exception) {
            OutputView.showError(exception);
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(input);
    }

    public static List<Integer> inputLuckyBalls() {
        System.out.println(LUCKY_BALLS_MESSAGE);

        String input = Console.readLine();

        try {
            validateLuckyBalls(input);
        } catch (Exception exception) {
            OutputView.showError(exception);
            throw new IllegalArgumentException();
        }

        return separate(input);
    }

    public static int inputBonus() {
        System.out.println(BONUS_MESSAGE);

        String input = Console.readLine();

        try {
            validate(input);
        } catch (Exception exception) {
            OutputView.showError(exception);
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(input);
    }


    private static void validate(String input) {
        if (!input.matches("^[0-9]+$")) {
            throw new NotNumberInputException();
        }
    }

    private static void validateLuckyBalls(String input) {
        if (!PATTERN.matcher(input).matches()) {
            throw new InvalidNumbersFormatException();
        }
    }

    private static List<Integer> separate(String numbers) {
        return Arrays.stream(numbers.split(SEPARATOR))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
