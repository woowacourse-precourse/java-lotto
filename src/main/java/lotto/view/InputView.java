package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {
    public static String requestUserAmount(){

        return Console.readLine();
    }

    public static String requestWinNumbers(){
        return(Console.readLine());
    }

    private static int StringToInt(String input){
        try{
            return Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException()
        }
    }
}
