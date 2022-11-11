package view;

import camp.nextstep.edu.missionutils.Console;

public class Client {

    private static final int LOTTO_PRICE = 1000;

    public int getLottoMoney(){
        String money = Console.readLine();
        if(!isNumber(money) || isDivideBy1000(money)){
            throw new IllegalArgumentException("[ERROR]");
        }
        return Integer.parseInt(money);
    }

    private Boolean isNumber(String money){
        return money.matches("[+-]?\\d*(\\.\\d+)?");
    }

    private Boolean isDivideBy1000(String money){
        return Integer.parseInt(money) % LOTTO_PRICE != 0;
    }
}
