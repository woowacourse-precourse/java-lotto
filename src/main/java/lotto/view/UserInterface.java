package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class UserInterface {

    private String userInputMoney;
    private int userMoney;

    public void getMoney() throws IllegalArgumentException {
        System.out.println("구입금액을 입력해 주세요.");
        userInputMoney = Console.readLine();

        validateNotNull(userInputMoney);
        validateNumber(userInputMoney);
        validateNoChange(userMoney);
    }

    private void validateNotNull(String userInputMoney) {
        if(userInputMoney==null){
            throw new IllegalArgumentException("구입금액은 비어있는 값을 입력할 수 없습니다.");
        }
    }

    private void validateNumber(String userInputMoney) {
        try{
            userMoney = Integer.parseInt(userInputMoney);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("구입금액은 숫자만 입력 가능합니다.");
        }
    }

    private void validateNoChange(int userMoney) {
        if(userMoney%1000!=0){
            throw new IllegalArgumentException("구입금액은 숫자만 입력 가능합니다.");
        }
    }



}
