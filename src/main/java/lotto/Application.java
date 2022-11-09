package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static int purchaseAmountInput(){
        String user_input = Console.readLine();
        int result;

        purchaseAmount_exceptionHandling(user_input);
        result=Integer.parseInt(user_input);

        return result;
    }

    private static void purchaseAmount_exceptionHandling(String user_input){
        if(!isNumber(user_input)&&!isDevidedThousand(user_input)){
            throw new IllegalArgumentException();
        }
    }

    private static boolean isNumber(String user_input){
        try{
            Integer.parseInt(user_input);
        } catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    private static boolean isDevidedThousand(String user_input_String) {
        int user_input_int=Integer.parseInt(user_input_String);
        if(user_input_int%1000!=0){
            return false;
        }
        return true;
    }
}
