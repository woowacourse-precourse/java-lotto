package lotto.ui;

import static lotto.ui.Message.BUY_LOTTO;
import static lotto.ui.Message.INPUT_BONUS_NUMBER;
import static lotto.ui.Message.INPUT_LOTTO_NUMBERS;
import static lotto.ui.Message.INPUT_PRICE;
import static lotto.ui.Message.LOTTERY_RESULT_COUNT;
import static lotto.ui.Message.LOTTERY_RESULT_FIFTH;
import static lotto.ui.Message.LOTTERY_RESULT_FIRST;
import static lotto.ui.Message.LOTTERY_RESULT_FOURTH;
import static lotto.ui.Message.LOTTERY_RESULT_SECOND;
import static lotto.ui.Message.LOTTERY_RESULT_SUBDIVISION;
import static lotto.ui.Message.LOTTERY_RESULT_THIRD;
import static lotto.ui.Message.LOTTERY_RESULT_TITLE;
import static lotto.ui.Message.LOTTO_NUMBER_DELIMITER;
import static lotto.ui.Message.LOTTO_NUMBER_END;
import static lotto.ui.Message.LOTTO_NUMBER_START;
import static lotto.ui.Message.PROFIT_RATE_END;
import static lotto.ui.Message.PROFIT_RATE_START;

import java.util.List;
import java.util.stream.Collectors;

public class Print {


    public static void inputPrice() {
        System.out.println(INPUT_PRICE.getValue());
    }

    public static void inputLottoNumbers() {
        System.out.println(INPUT_LOTTO_NUMBERS.getValue());
    }

    public static void inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER.getValue());
    }

    public static void newLine() {
        System.out.println();
    }

    public static void buyLotto(int count) {
        System.out.print(count);
        System.out.println(BUY_LOTTO.getValue());
    }

    public static void lottoNumbers(List<Integer> numbers) {
        String lottoNumbers = numbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(LOTTO_NUMBER_DELIMITER.getValue()));
        System.out.println(LOTTO_NUMBER_START.getValue() + lottoNumbers + LOTTO_NUMBER_END.getValue());
    }

    public static void winningLotteryResult(int fifth, int fourth, int third, int second, int first) {
        System.out.println(LOTTERY_RESULT_TITLE.getValue());
        System.out.println(LOTTERY_RESULT_SUBDIVISION.getValue());
        System.out.println(LOTTERY_RESULT_FIFTH.getValue() + fifth + LOTTERY_RESULT_COUNT.getValue());
        System.out.println(LOTTERY_RESULT_FOURTH.getValue() + fourth + LOTTERY_RESULT_COUNT.getValue());
        System.out.println(LOTTERY_RESULT_THIRD.getValue() + third + LOTTERY_RESULT_COUNT.getValue());
        System.out.println(LOTTERY_RESULT_SECOND.getValue() + second + LOTTERY_RESULT_COUNT.getValue());
        System.out.println(LOTTERY_RESULT_FIRST.getValue() + first + LOTTERY_RESULT_COUNT.getValue());
    }

    public static void profitRate(double rate) {
        System.out.printf("%s%.1f%s\n", PROFIT_RATE_START.getValue(), rate, PROFIT_RATE_END.getValue());
    }

    public static void message(String message) {
        System.out.println(message);
    }
}
