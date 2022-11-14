package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Input {

    public static final int CHEON_WON = 1000;

    public int inputMoney(){
        String amountOfMoney = Console.readLine();
        return Integer.parseInt(amountOfMoney);
    }

    public String  inputWinningLottosNumber(){
        return Console.readLine();
    }



//    public void checkMoneyUnit(int money){
//        if(!(money / CHEON_WON == 0)){
//            throw new IllegalArgumentException("[ERROR] 금액은 천원 단위로 입력해주세요");
//        }
//    }


}
