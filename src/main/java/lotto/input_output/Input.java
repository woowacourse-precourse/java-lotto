package lotto.input_output;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {


    protected static List<Integer> returnList(){ //Lotto 당첨 번호 입력받기 List<Integer>로 반환
        String[] input  = Console.readLine().split(",");
        return Arrays.stream(input).mapToInt(Integer::valueOf).boxed().collect(Collectors.toList());
    }

    protected static int returnInt(){// 정수형 반환
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
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
