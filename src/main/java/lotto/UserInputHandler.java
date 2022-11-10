package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UserInputHandler {

    static final int moneyOfOneTicket = 1000;
    static final int numbersOfLotto = 6;

    public int getHowMuchTickets(){
        int money = Integer.parseInt(Console.readLine());
        validateMoney(money);
        return money / moneyOfOneTicket;
    }

    private void validateMoney(int money){
        if(money % moneyOfOneTicket != 0){
            throw new IllegalArgumentException("[ERROR] 로또는 1,000원 단위로 구입할 수 있습니다.\n");
        }
    }
}
