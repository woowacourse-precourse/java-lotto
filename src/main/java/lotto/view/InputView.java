package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

import static lotto.utils.ExceptionMessage.*;

public class InputView {
    public static int requestUserAmount(){

        return StringToInt(Console.readLine());
    }

    public static String requestWinNumbers(){
        return(Console.readLine());
    }

    private static int StringToInt(String input){
        try{
            return Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(USER_INPUT_NOT_NUMBER_EXCEPTION);
        }
    }
}
