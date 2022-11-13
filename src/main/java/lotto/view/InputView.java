package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.utils.ExceptionMessage.*;
import static lotto.utils.Message.*;

public class InputView {
    public static int requestUserAmount(){
        System.out.println(REQUEST_USER_AMOUNT);
        try{
            return StringToInt(Console.readLine());
        } catch (IllegalArgumentException e){
            OutputView.printException(e);
        }
        return 0;

    }

    public static List<Integer> requestWinNumbers(){
        System.out.println(REQUEST_WIN_NUMBERS);
        return StringToIntegerList(Console.readLine());
    }

    public static int requestBonusNumber(){
        System.out.println(REQUEST_BONUS_NUMBER);
        return StringToInt(Console.readLine());
    }

    private static int StringToInt(String input){
        try{
            return Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(USER_INPUT_NOT_NUMBER_EXCEPTION);
        }
    }

    private static List<Integer> StringToIntegerList(String input){
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
