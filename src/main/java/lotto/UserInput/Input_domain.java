package lotto.UserInput;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input_domain {
    public static int purchaseAmountInput() {
        String user_input = Console.readLine();
        int purchase_amount;

        purchaseAmount_exceptionHandling(user_input);
        purchase_amount = Integer.parseInt(user_input);

        return purchase_amount;
    }

    public static int bonusNumberInput(List<Integer> winning_lottery_number) {
        int bonus_number;
        String user_input = Console.readLine();

        bonusNumberIsNumberExceptionHandling(user_input, winning_lottery_number);
        bonus_number = Integer.parseInt(user_input);
        bonusNumberOverlapExceptionHandling(bonus_number, winning_lottery_number);
        return bonus_number;
    }

    public static List<Integer> winningLotteryInput() {
        String user_input = Console.readLine();
        List<Integer> lottery_num;

        lottery_num = winningLotteryNumber(user_input);
        return lottery_num;
    }

    private static void bonusNumberIsNumberExceptionHandling(String user_input, List<Integer> winning_lottery_number) {
        if (!isNumber(user_input))
            throw new IllegalArgumentException();
    }

    private static void purchaseAmount_exceptionHandling(String user_input) {
        if (!isNumber(user_input) || !isDevidedThousand(user_input)) {
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> winningLotteryNumber(String user_input) {
        List<String> winning_lottery_number_String;
        List<Integer> winning_lottery_number_int;

        winning_lottery_number_String = restTokenizer(user_input);
        tokenIsNumberExceptionHandling(winning_lottery_number_String);
        winning_lottery_number_int = tokenParseInt(winning_lottery_number_String);
        return winning_lottery_number_int;
    }

    private static void bonusNumberOverlapExceptionHandling(int bonus_number, List<Integer> winning_lottery_number) {
        for (int i = 0; i < winning_lottery_number.size(); i++) {
            if (winning_lottery_number.get(i) == bonus_number) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void tokenIsNumberExceptionHandling(List<String> token_String) {
        if (tokenIsNumberException(token_String)) {
            throw new IllegalArgumentException();
        }
    }

    private static List<String> restTokenizer(String user_input) {
        List<String> token_Stirng = new ArrayList<>();
        String[] tokens = user_input.split(",");

        for (int i = 0; i < tokens.length; i++) {
            token_Stirng.add(tokens[i]);
        }
        return token_Stirng;
    }

    private static List<Integer> tokenParseInt(List<String> token_String) {
        List<Integer> token_int = new ArrayList<>();
        for (int i = 0; i < token_String.size(); i++) {
            token_int.add(Integer.parseInt(token_String.get(i)));
        }
        return token_int;
    }

    private static boolean tokenIsNumberException(List<String> token) {
        for (int i = 0; i < token.size(); i++) {
            if (!isNumber(token.get(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumber(String user_input) {
        try {
            Integer.parseInt(user_input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static boolean isDevidedThousand(String user_input_String) {
        int user_input_int = Integer.parseInt(user_input_String);
        if (user_input_int % 1000 != 0) {
            return false;
        }
        return true;
    }
}
