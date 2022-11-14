package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {
    private static final String INPUT_ASK_FOR_PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_PURCHASE_COMPLETED_MESSAGE = "%d개를 구매했습니다.";
    private static final String INPUT_DRAW_LOTTERY_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_ASK_FOR_A_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";


    public static int getAmountInput() {
        System.out.println(INPUT_ASK_FOR_PURCHASE_MESSAGE);
        int input = getNumberInput();
        System.out.printf(INPUT_PURCHASE_COMPLETED_MESSAGE, input % 1000);
        return input;
    }

    public static void printTickets(List<List<Integer>> tickets) {
        System.out.println(INPUT_DRAW_LOTTERY_NUMBERS);
        tickets.forEach(System.out::println);
    }

    public static String drawLotteryNumbers() {
        System.out.println(INPUT_DRAW_LOTTERY_NUMBERS);
        return Console.readLine();
    }

    public static int drawBonusNumber() {
        System.out.println(INPUT_ASK_FOR_A_BONUS_NUMBER);
        return getNumberInput();
    }


    private static int getNumberInput() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }
}
