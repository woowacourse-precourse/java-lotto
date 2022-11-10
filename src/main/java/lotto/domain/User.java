package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private int money;

    public void inputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();
        try{
            this.money=convertToInt(money);
            validateMoney(this.money);
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e);
        }
    }

    public int convertToInt(String money){
        int convertMoney = 0;
        try{
            convertMoney = Integer.parseInt(money);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요!");
        }

        return convertMoney;
    }

    public void validateMoney(int money){
        if(money < 1000){
            throw new IllegalArgumentException("[ERROR] 로또 1장의 구매가격은 1000원 입니다! 1000이상의 수를 입력해주세요");
        }
    }
}
