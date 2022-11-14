package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;


public class BuyPrice {
    final static int thousand = 1000;
    final static int zero = 0;
    private final String cost;

    static Integer numberOfTickets;

    static Integer buyCost;


    public BuyPrice(String cost){
        this.cost = cost;
        checkPrice();
    }
    // 구입 가격 입력
    public int checkPrice(){
        int int_price = Integer.parseInt(cost);
        return checkUnit(int_price);
    }

    private int checkUnit(int costs) {
        if(costs%thousand != zero ){
            new Exceptions("[ERROR] 1000원으로 나눠져야 한다");
        }
        numberOfTickets = costs/1000;
        buyCost = costs;
        return costs/1000;
    }

}
