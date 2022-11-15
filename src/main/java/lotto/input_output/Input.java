package lotto.input_output;

import camp.nextstep.edu.missionutils.Console;
import lotto.valid.Valid;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input extends Valid {

    protected static List<Integer> returnLotteryNumber(){
        String input = input();
        checkLottonums(input);
        return ChangeType.string_to_listinteger(input);
    }
    protected static int returnBonus(List<Integer> numbers){
        String input = input();
        checkBouns(numbers, input);
        return ChangeType.string_to_int(input);
    }
    protected static int returnPayMoney()  {
        String input = input();
        checkPayMoney(input);
        return ChangeType.string_to_int(input);
    }
    protected static String input() {
        return Console.readLine();
    }

    private static void checkLottonums(String str) {
        check_empty(str);
        check_size(str);
        check_number(str);
        check_Range(str);
        check_Overlap(str);
    }
    private static void checkBouns(List<Integer> numbers, String str) {
        check_empty(str);
        check_number(str);
        check_Range(str);
        check_Overlap(numbers);
    }

    private static void checkPayMoney(String str)  {
            check_empty(str);
            check_number(str);
            check_under_thousand(str);
    }

}
