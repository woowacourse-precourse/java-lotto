package lotto;

import camp.nextstep.edu.missionutils.Console;

public class DrawLotto {

    private static final int LOTTO_PRICE = 1000;

    public void init(){

    }

    private static int getUserMoney(){
        int money = Integer.parseInt(Console.readLine());
        return money;
    }

    private static int getUserLottoCount(int money){
        return (money/LOTTO_PRICE);
    }

}