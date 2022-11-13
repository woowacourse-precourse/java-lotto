package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;


public class BuyPrice {
    final static int thousand = 1000;
    final static int zero = 0;
    private final String cost;

    public BuyPrice(String cost){
        this.cost = cost;
    }
    // 구입 가격 입력
    public int checkPrice(){
        int int_price = Integer.parseInt(cost);
        return checkUnit(int_price);
    }

    private int checkUnit(int costs) {
        if(costs%thousand != zero ){
            new Exceptions();
        }
        return costs/1000;
    }

}
