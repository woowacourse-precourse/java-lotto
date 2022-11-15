package lotto;

import static lotto.Application.printErrorMessage;

public class UserMoney {
    private int userMoney;
    private final int lottoPrice = 1000;

    public UserMoney(String input) {
        validate(input);
        this.userMoney = changeToInteger(input);
    }

    private int changeToInteger(String input) {
        return Integer.parseInt(input);
    }


    private void validate(String input) {
        try{
            int userMoneyInput =Integer.parseInt(input);
            isInRightRange(userMoneyInput);
            canBeDivided(userMoneyInput);
        }
        catch(NumberFormatException e){
            printErrorMessage("천원 단위의 숫자로 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }


    private void canBeDivided(int userMoneyInput){
        if(userMoneyInput %lottoPrice!=0){
            printErrorMessage(String.format("%d원 단위로 입력해주세요.",lottoPrice));
            throw new IllegalArgumentException();
        }
    }

    private void isInRightRange(int userMoneyInput){
        if(userMoneyInput <lottoPrice){
            printErrorMessage(String.format("%d원 이상을 구매해주세요.",lottoPrice));
            throw new IllegalArgumentException();
        }
    }







}
