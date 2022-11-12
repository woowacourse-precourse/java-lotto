package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String ENTER_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    public static int enterAmount(){
        System.out.println(ENTER_PURCHASE_AMOUNT_MESSAGE);
        try {
            return getNumber();
        }catch(Exception e){
            throw new IllegalArgumentException("[ERROR] Only enter numbers.");
        }
    }

    private static int getNumber(){
        String number = Console.readLine();
        return Integer.parseInt(number);
    }

}
