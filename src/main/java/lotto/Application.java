package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static final String INVALID_AMOUNT_ERROR_MESSAGE = "[ERROR] 올바른 금액을 입력해주세요.";
    public static final String NOT_NUMBER_ERROR_MESSAGE = "[ERROR] 숫자만 입력해주세요.";
    public static final String AMOUNT_ENTER_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String ANSWER_NUMBER_ENTER_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_ENTER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static void main(String[] args) {
        int buyPrice = enterAmount();
        if (buyPrice == 0) return;
        List<Lotto> lottoList = buyLotto(buyPrice);
        checkLotto(lottoList);
        calculateProfit(buyPrice);
    }

    private static void calculateProfit(int price) {
        Calculator.calculate(price);
    }

    private static void checkLotto(List<Lotto> lottoList) {
        Grader grader = new Grader(lottoList, getAnswerNumber(), getBonusNumber());
        grader.grade();
    }

    private static List<Lotto> buyLotto(int price) {
        Machine machine = new Machine();
        return machine.buy(price);
    }

    private static int getBonusNumber() {
        System.out.println(BONUS_NUMBER_ENTER_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }

    private static List<Integer> getAnswerNumber() {
        System.out.println(ANSWER_NUMBER_ENTER_MESSAGE);
        return Arrays.stream(Console.readLine().split(","))
                .map(el -> Integer.parseInt(el))
                .collect(Collectors.toList());
    }

    private static int enterAmount() {
        System.out.println(AMOUNT_ENTER_MESSAGE);
        String money = Console.readLine();
        if (!isValidAmount(money)) return 0;
        return Integer.parseInt(money);
    }

    public static boolean isValidAmount(String enterValue) {
        for (int i = 0; i < enterValue.length(); i++) {
            if (!('0' <= enterValue.charAt(i) && enterValue.charAt(i) <= '9')) {
                System.out.println(NOT_NUMBER_ERROR_MESSAGE);
                return false;
            }
        }
        if (Integer.parseInt(enterValue) % 1000 != 0) {
            System.out.println(INVALID_AMOUNT_ERROR_MESSAGE);
            return false;
        }
        return true;
    }

}
