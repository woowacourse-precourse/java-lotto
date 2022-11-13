package lotto;

import camp.nextstep.edu.missionutils.Console;

public class User {
    static final int LOTTO_PRICE = 1000;

    public User(){

    }

    int lotteryPurchaseAmount(){
        String input = Console.readLine();
        int lotteryPurchaseAmount = Integer.parseInt(input);
        if (lotteryPurchaseAmount % 1000 != 0){
            throw new IllegalArgumentException();
        }
        return (lotteryPurchaseAmount / LOTTO_PRICE);
    }

}
