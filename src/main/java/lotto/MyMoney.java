package lotto;

import camp.nextstep.edu.missionutils.Console;

public class MyMoney {
    private final int amount;

    public MyMoney() {
        this.amount = inputMoney();
    }

    private int checkIsNumber(String myMoney){
        try{
            return Integer.parseInt(myMoney);
        }
        catch (NumberFormatException exception){
            throw new IllegalArgumentException();
        }
    }

    private void checkIsDivide(int moneyNum){
        if(moneyNum % 1000 != 0){
            throw new IllegalArgumentException();
        }
    }

    private void checkInputMoney(String myMoney){
        int moneyNum = checkIsNumber(myMoney);
        checkIsDivide(moneyNum);
    }

    private int inputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String myMoney = Console.readLine();
        checkInputMoney(myMoney);
        System.out.println();
        return Integer.parseInt(myMoney);
    }

    public int getAmount(){
        return this.amount;
    }
}
