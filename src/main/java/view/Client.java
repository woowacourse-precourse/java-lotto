package view;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Client {
    public int getLottoMoney(){
        String money = Console.readLine();
        if(!isNumber(money)){
            throw new IllegalArgumentException("[ERROR]");
        }
        return Integer.parseInt(money);
    }

    private Boolean isNumber(String money){
        return money.matches("[+-]?\\d*(\\.\\d+)?");
    }
}
