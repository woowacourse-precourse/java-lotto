package lotto;

import camp.nextstep.edu.missionutils.Console;

import static config.Error.*;

public class Application {

    static String InputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return input;
    }

    static Integer InputMoneyException(String input) throws IllegalArgumentException{
        int money;
        try{
            money = Integer.parseInt(input);
            if(money % 1000 == 0 ){
                return money % 1000;
            }
        }catch(Exception e){
            System.out.println(ERROR_MESSAGE+ERROR_INTEGER);
            throw new IllegalArgumentException(ERROR_MESSAGE+ERROR_INTEGER);
        }
        System.out.println(ERROR_MESSAGE+ERROR_INPUT_MONEY);
        throw new IllegalArgumentException(ERROR_MESSAGE+ERROR_INPUT_MONEY);
    }

    public static void main(String[] args) {
        String input = InputMoney();
        int chance = InputMoneyException(input);

    }
}
