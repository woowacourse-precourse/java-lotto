package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Input {
    public static int buyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int money = Converter.stringToInt(input);
        if (!Validation.thousandUnit(money)) {
            Output.showError(Error.MONEY_THOUSAND_UNIT);
        }
        return money;
    }

    public static List<Integer> winningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<Integer> winningNums = Converter.stringToList(input);
        if (!Validation.lottoLength(winningNums)) {
            Output.showError(Error.WINNING_NUMS_LENGTH);
        }
//        if (!Validation.lottoNumDuplicated(winningNums)) {
//            Output.showError(Error.DUPLICATED_NUM);
//        }
        return winningNums;
    }

    public static int bonusNumber(List<Integer> winningNums) {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        int num = Converter.stringToInt(input);
        if (winningNums.contains(num)) {
            Output.showError(Error.DUPLICATED_NUM);
        }
        return num;
    }
}
