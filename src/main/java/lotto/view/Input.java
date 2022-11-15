package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Input {
    public static final String INPUT_MONEY_THOUSAND_ERROR = "[ERROR] 금액이 천원 단위가 아닙니다.";

    public static int inputMoney() {
        String money = Console.readLine();
        validateInputMoneyThousand(money);
        return Integer.parseInt(money);
    }

    public static List<Integer> inputPrizeNumbers() {
        String numbers = Console.readLine();

        return Stream.of(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int inputBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }

    private static void validateInputMoneyThousand(String money){
        Pattern pattern = Pattern.compile("^[0-9]*[0]{3}$");
        Matcher matcher = pattern.matcher(money);
        if(!matcher.find()){
            throw new IllegalArgumentException(INPUT_MONEY_THOUSAND_ERROR);
        }
    }
}
