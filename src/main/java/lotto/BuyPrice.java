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

    static String ERROR_MESSAGE = "[ERROR]";


    public BuyPrice(String cost){
        this.cost = cost;
        checkPrice();
    }
    // 구입 가격 입력
    public int checkPrice(){
        try {
            Integer.parseInt(cost);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        int int_price = Integer.parseInt(cost);
        return checkUnit(int_price);
    }

    private int checkUnit(int costs) {
        if(costs%thousand != zero ){
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        numberOfTickets = costs/1000;
        buyCost = costs;
        checkOver1000(costs);
        return costs/1000;
    }

    private void checkOver1000(int costs) {
        if(costs<1000){
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

}
