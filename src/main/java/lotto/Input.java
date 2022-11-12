package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Input {
    public static int buyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int money = Converter.stringToInt(input);
        if (!Validation.thousandUnit(money)) {
            throw new IllegalArgumentException(Error.MONEY_THOUSAND_UNIT.getDesc());
        }
        return money;
    }

    public static List<Integer> winningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<Integer> winningNums = Converter.stringToList(input);
        if (!Validation.lottoLength(winningNums)) {
            throw new IllegalArgumentException(Error.WINNING_NUMS_LENGTH.getDesc());
        }
        return winningNums;
    }
}
