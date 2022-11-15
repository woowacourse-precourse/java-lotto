package lotto.UserInput;

import camp.nextstep.edu.missionutils.Console;
import lotto.LottoRange;

import java.util.ArrayList;
import java.util.List;

public class InputDomain {
    public static int purchaseAmountInput() {
        String user_input;
        int purchase_amount;

        System.out.println("구입금액을 입력해 주세요.");
        user_input = Console.readLine();
        purchaseAmount_exceptionHandling(user_input);
        purchase_amount = Integer.parseInt(user_input);

        return purchase_amount;
    }

    public static List<Integer> winningLotteryInput() {
        String user_input;
        List<Integer> lottery_num;

        System.out.println("\n당첨 번호를 입력해 주세요.");
        user_input = Console.readLine();
        lottery_num = winningLotteryNumber(user_input);
        return lottery_num;
    }

    public static int bonusNumberInput(List<Integer> winning_lottery_number) {
        int bonus_number;
        String user_input;

        System.out.println("\n보너스 번호를 입력해 주세요.");
        user_input = Console.readLine();
        bonusNumberIsNumberExceptionHandling(user_input, winning_lottery_number);
        bonus_number = Integer.parseInt(user_input);
        bonusNumberOverlapExceptionHandling(bonus_number, winning_lottery_number);
        bonusNumberIsRangeExceptionHandling(bonus_number);
        return bonus_number;
    }

    private static void bonusNumberIsNumberExceptionHandling(String user_input, List<Integer> winning_lottery_number) {
        if (!isNumber(user_input))
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    private static void bonusNumberIsRangeExceptionHandling(int bonus_number){
        if(bonus_number< LottoRange.NUMBER_MIN.getValue()||bonus_number>LottoRange.NUMBER_MAX.getValue())
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    private static void purchaseAmount_exceptionHandling(String user_input) {
        if (!isNumber(user_input) || !isDevidedThousand(user_input)) {
//            System.out.println("[ERROR]");
//            throw new IllegalArgumentException();
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000의 배수여야 합니다.");
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
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 중복되면 안됩니다.");
            }
        }
    }

    private static void tokenIsNumberExceptionHandling(List<String> token_String) {
        if (tokenIsNumberException(token_String)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
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
