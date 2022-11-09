package domain;

import camp.nextstep.edu.missionutils.Console;

public class UserMoney {


    public static int inputMoney(){
        String input_money = Console.readLine();
        return checkMoney(input_money);
    }

    public static int checkMoney(String input_money) {
        int money=0;
        try {
            money = Integer.parseInt(input_money);
        }
        catch(Exception e){
            throw new IllegalArgumentException("[ERROR] 사용자의 금액 입력 오류입니다.");
        }

        if(money % 1000>0){
            throw new IllegalArgumentException("[ERROR] 올바르지 못한 입력 금액입니다.");
        }
        return money;
    }


}
