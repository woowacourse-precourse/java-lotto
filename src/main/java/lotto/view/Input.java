package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Input {
    public static final String INPUT_MONEY_THOUSAND_ERROR = "[ERROR] 금액이 천원 단위가 아닙니다.";
    public static final String INPUT_PRICE_LOTTO_ERROR = "[ERROR] 당첨 번호를 정확히 입력하세요.";

    public static int inputMoney() {
        String money = Console.readLine();
        validateInputMoneyThousand(money);
        return Integer.parseInt(money);
    }

    private static void validateInputMoneyThousand(String money){
        Pattern pattern = Pattern.compile("^[0-9]*[0]{3}$");
        Matcher matcher = pattern.matcher(money);
        if(!matcher.find()){
            throw new IllegalArgumentException(INPUT_MONEY_THOUSAND_ERROR);
        }
    }

    public static List<Integer> inputPrizeNumbers() {
        List<Integer> priceNum;
        String numbers = Console.readLine();

        try {
            priceNum = Stream.of(numbers.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        }catch (Exception e){
            throw new IllegalArgumentException(INPUT_PRICE_LOTTO_ERROR);
        }

        return priceNum;
    }

    public static int inputBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }

}
