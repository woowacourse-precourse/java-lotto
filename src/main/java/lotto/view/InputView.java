package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

import static lotto.utils.ExceptionMessage.*;
import static lotto.utils.Message.*;

public class InputView {
    public static long requestUserAmount(){
        System.out.println(REQUEST_USER_AMOUNT);
        try{
            return StringToInt(Console.readLine());
        } catch (IllegalArgumentException e){
            OutputView.printException(e);
        }
        return 0;

    }

    public static String requestWinNumbers(){
        System.out.println(REQUEST_WIN_NUMBERS);
        return(Console.readLine());
    }

    public static long requestBonusNumber(){
        System.out.println(REQUEST_BONUS_NUMBER);
        return StringToInt(Console.readLine());
    }

    private static long StringToInt(String input){
        try{
            return Long.parseLong(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(USER_INPUT_NOT_NUMBER_EXCEPTION);
        }
    }
}
