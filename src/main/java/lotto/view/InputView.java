package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InputException;

public class InputView {
    private final static String NUMBER_OF_PRICE = "구입금액을 입력해 주세요.";

    public static int getInputPrice(){
        while(true){
            try{
                System.out.println(NUMBER_OF_PRICE);
                return InputException.isValidInputPrice(Console.readLine());
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

    }
}
