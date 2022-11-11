package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Print {

    private final static String INPUT_PRICE = "구입금액을 입력해 주세요.";
    private final static String INPUT_LOTTO_NUMBERS = "당첨 번호를 입력해 주세요.";
    private final static String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private final static String BUY_LOTTO = "개를 구매했습니다.";
    private final static String LOTTO_NUMBER_DELIMITER = ", ";
    private final static String LOTTO_NUMBER_START = "[";
    private final static String LOTTO_NUMBER_END = "]";
    private final static String LOTTERY_RESULT_TITLE = "당첨 통계";
    private final static String LOTTERY_RESULT_SUBDIVISION = "---";
    private final static String LOTTERY_RESULT_FIFTH = "3개 일치 (5,000원) - ";
    private final static String LOTTERY_RESULT_FOURTH = "4개 일치 (50,000원) - ";
    private final static String LOTTERY_RESULT_THIRD = "5개 일치 (1,500,000원) - ";
    private final static String LOTTERY_RESULT_SECOND = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private final static String LOTTERY_RESULT_FIRST = "6개 일치 (2,000,000,000원) - ";
    private final static String LOTTERY_RESULT_COUNT = "개";

    public static void inputPrice() {
        System.out.println(INPUT_PRICE);
    }

    public static void inputLottoNumbers() {
        System.out.println(INPUT_LOTTO_NUMBERS);
    }

    public static void inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
    }

    public static void newLine() {
        System.out.println();
    }

    public static void buyLotto(int count) {
        System.out.print(count);
        System.out.println(BUY_LOTTO);
    }

    public static void lottoNumbers(List<Integer> numbers) {
        String lottoNumbers = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(LOTTO_NUMBER_DELIMITER));
        System.out.println(LOTTO_NUMBER_START + lottoNumbers + LOTTO_NUMBER_END);
    }

    public static void winningLotteryResult(int fifth, int fourth, int third, int second, int first) {
        System.out.println(LOTTERY_RESULT_TITLE);
        System.out.println(LOTTERY_RESULT_SUBDIVISION);
        System.out.println(LOTTERY_RESULT_FIFTH + fifth + LOTTERY_RESULT_COUNT);
        System.out.println(LOTTERY_RESULT_FOURTH + fourth + LOTTERY_RESULT_COUNT);
        System.out.println(LOTTERY_RESULT_THIRD + third + LOTTERY_RESULT_COUNT);
        System.out.println(LOTTERY_RESULT_SECOND + second + LOTTERY_RESULT_COUNT);
        System.out.println(LOTTERY_RESULT_FIRST + first + LOTTERY_RESULT_COUNT);
    }
}
