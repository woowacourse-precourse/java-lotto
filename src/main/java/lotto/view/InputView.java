package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

import static lotto.utils.ExceptionMessage.*;
import static lotto.utils.Message.*;

public class InputView {
    public static int requestUserAmount(){
        System.out.println(REQUEST_USER_AMOUNT);
        return StringToInt(Console.readLine());
    }

    public static String requestWinNumbers(){
        System.out.println(REQUEST_WIN_NUMBERS);
        return(Console.readLine());
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
}
