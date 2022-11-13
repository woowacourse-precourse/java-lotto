package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    private static final String INPUT_PAYMENT_SENTENCE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_SENTENCE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_SENTENCE = "보너스 번호를 입력해 주세요.";
    public static void main(String[] args) {
        inputPrice();
        inputWinningNumbers();
        inputBonusNumber();
    }

    public static void inputPrice() {
        // 구입 금액 입력
        System.out.println(INPUT_PAYMENT_SENTENCE);
        int payment = Integer.parseInt(Console.readLine());
        if (payment % 1000 != 0) {
            throw new IllegalArgumentException();
        }
        System.out.println();
    }

    public static void inputWinningNumbers() {
        // 당첨 번호 입력
        System.out.println(INPUT_WINNING_NUMBERS_SENTENCE);
        List<Integer> winningNumbers = Arrays.stream(Console.readLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println();
    }
    public static void inputBonusNumber() {
        // 보너스 번호 입력
        System.out.println(INPUT_BONUS_NUMBER_SENTENCE);
        int bonus = Integer.parseInt(Console.readLine());
        System.out.println();
    }
}
