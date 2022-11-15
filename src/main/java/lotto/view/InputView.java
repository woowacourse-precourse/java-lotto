package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {
    private static final String INPUT_ASK_FOR_PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_PURCHASE_COMPLETED_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String INPUT_DRAW_LOTTERY_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_ASK_FOR_A_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";


    public static int getAmountInput() {
        System.out.println(INPUT_ASK_FOR_PURCHASE_MESSAGE);
        return getNumberInput();
    }

    public static void printTicketCounts(int input) {
        System.out.printf(INPUT_PURCHASE_COMPLETED_MESSAGE, input / 1000);
    }

    public static void printTickets(List<List<Integer>> tickets) {
        tickets.forEach(System.out::println);
    }

    public static String drawLotteryNumbers() {
        System.out.println(INPUT_DRAW_LOTTERY_NUMBERS);
        return getInput();
    }

    public static int drawBonusNumber() {
        System.out.println(INPUT_ASK_FOR_A_BONUS_NUMBER);
        return getNumberInput();
    }


    private static String getInput() {
        return Console.readLine();
    }

    private static int getNumberInput() {
        try {
            String input = Console.readLine();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 1 이상 정수를 입력해 주세요.");
        }
    }
}
