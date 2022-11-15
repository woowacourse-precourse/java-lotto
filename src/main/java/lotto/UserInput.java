package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요";
    private static final String MONEY_ERROR_MESSAGE = "[ERROR] 잘못된 금액 값을 입력했습니다.";

    public int moneyInput(){
        System.out.println(MONEY_INPUT_MESSAGE);

        String userInputMoney = Console.readLine();

        try{
            return Integer.parseInt(userInputMoney);
        } catch (Exception e){
            throw new IllegalArgumentException(MONEY_ERROR_MESSAGE);
        }
    }
}
