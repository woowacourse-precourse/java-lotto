package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Domain {

    public static int inputMoneyException(String input) {
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("숫자로만 입력하십시오.");
        }
        int purchaseMoney = Integer.parseInt(input);
        if (purchaseMoney%1000!=0){
            throw new IllegalArgumentException("1000원 단위의 금액을 입력하십시오.");
        }
        return purchaseMoney;
    }

    public static List<Integer> inputDigitException() {
        List<Integer> luckyNums = Arrays.stream(Console.readLine().split(",")).map(Integer::parseInt).collect(Collectors.toList());
        if (luckyNums.size()!=6){
            throw new IllegalArgumentException("6개의 숫자를 콤마로 구분하여 입력하십시오.");
        }
        for (int i :luckyNums){
            rangeValidator(i);
        }
        return luckyNums;
    }
    public static int inputBonusException(List<Integer> luckyNums) {
        String input = Console.readLine();
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("숫자로만 입력하십시오.");
        }
        int bonus = Integer.parseInt(input);
        if (luckyNums.contains(bonus)){
            throw new IllegalArgumentException("중복된 숫자를 입력하지 마십시오.");
        }
        rangeValidator(bonus);
        return bonus;
    }

    private static void rangeValidator(int num) {
        if (num < 1 || num > 45){
            throw new IllegalArgumentException("1~45 사이의 숫자로만 적어주십시오.");
        }
    }


}
