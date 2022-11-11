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
    private final static String PROFIT_RATE_START = "총 수익률은 ";
    private final static String PROFIT_RATE_END = "%입니다.";
    private final static String NUMBER_EXCEPTION = "[ERROR] 숫자로 된 입력이 아닙니다.";
    private final static String LOTTO_NUMBER_EXCEPTION = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private final static String PRICE_EXCEPTION = "[ERROR] 구입 금액은 1,000으로 나누어 떨어져야 합니다.";
    private final static String SPLIT_BY_COMMA_INPUT_SIZE_EXCEPTION = "[ERROR] ',' 로 구분되는 6개의 문자열이어야 합니다.";
    private final static String NON_DUPLICATED_LOTTO_NUMBERS_EXCEPTION = "[ERROR] 당첨 번호는 중복되지 않는 6개의 숫자여야 합니다.";

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

    public static void profitRate(double rate) {
        System.out.printf("%s%.1f%s\n", PROFIT_RATE_START, rate, PROFIT_RATE_END);
    }

    public static void numberException() {
        System.out.println(NUMBER_EXCEPTION);
    }

    public static void lottoNumberException() {
        System.out.println(LOTTO_NUMBER_EXCEPTION);
    }

    public static void priceException() {
        System.out.println(PRICE_EXCEPTION);
    }

    public static void splitByCommaInputSizeException() {
        System.out.println(SPLIT_BY_COMMA_INPUT_SIZE_EXCEPTION);
    }

    public static void nonDuplicatedLottoNumbersException() {
        System.out.println(NON_DUPLICATED_LOTTO_NUMBERS_EXCEPTION);
    }
}
