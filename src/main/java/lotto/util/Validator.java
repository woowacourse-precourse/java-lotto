package lotto.util;

import java.util.List;

public class Validator {
    private final String INVALID_MONEY = "[ERROR] 1000원 단위로 입력이 가능합니다.";

    public int moneyInputValidator(String money) {
        int moneyNumber = changeNumber(money);
        return 1;
    }

    public int changeNumber(String money) {
        try{
            return Integer.parseInt(money);
        } catch (Exception e){
            throw new IllegalArgumentException(INVALID_MONEY);
        }
    }

    public void checkChanges(String money) {

    }

    public static void winningNumberInputValidator(String money) {

    }

    public static void checkValidNumber(int number){

    }

    public static void checkDuplication(List<Integer> numbers, int number){

    }

}
