package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.utils.ExceptionMessage.*;
import static lotto.utils.Message.*;

public class InputView {
    public static int requestUserAmount(){
        System.out.println(REQUEST_USER_AMOUNT);
        return stringToInt(Console.readLine());

    }

    public static List<Integer> requestWinNumbers(){
        System.out.println(REQUEST_WIN_NUMBERS);
        return stringToIntegerList(Console.readLine());
    }

    public static int requestBonusNumber(){
        System.out.println(REQUEST_BONUS_NUMBER);
        return stringToInt(Console.readLine());
    }

    private static int stringToInt(String input){
        if(input.isEmpty()){
            throw new IllegalArgumentException(USER_INPUT_NULL_EXCEPTION);
        }
        try{
            return Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(USER_INPUT_NOT_NUMBER_EXCEPTION);
        }
    }

    private static List<Integer> stringToIntegerList(String input){
        return Stream.of(input.split(",")).
                map(x-> {
                    try {
                        return Integer.parseInt(x);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException(USER_INPUT_NOT_NUMBER_EXCEPTION);
                    }
                })
                .collect(Collectors.toList());
    }
}
