package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    private static final String INPUT_PAYMENT_SENTENCE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_SENTENCE = "개를 구매했습니다.";
    private static final String INPUT_WINNING_NUMBERS_SENTENCE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_SENTENCE = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS_SENTENCE = "당첨 통계\n---";
    private static final String FIFTH_PLACE_SENTENCE = "3개 일치 (5,000원)";
    private static final String FOURTH_PLACE_SENTENCE = "4개 일치 (50,000원)";
    private static final String THIRD_PLACE_SENTENCE = "5개 일치 (1,500,000원)";
    private static final String SECOND_PLACE_SENTENCE = "5개 일치, 보너스 볼 일치 (30,000,000원)";
    private static final String FIRST_PLACE_SENTENCE = "6개 일치 (2,000,000,000원)";

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

    public static List<Integer> generateSortedRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return numbers;
    }
}
