package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Application {
    private static final int STOP_VALUE = -1;
    private static final int AMOUNT_UNIT = 1000;
    private static final int LOTTERY_NUMBER_LIMIT = 6;
    public static void main(String[] args) {
        startLottoGame();
    }

    private static void startLottoGame(){
        System.out.println("구입금액을 입력해 주세요.");
        int buyingAmount = inputBuyingAmount();
        if(buyingAmount != STOP_VALUE){
            final int countOfLottery = buyingAmount / AMOUNT_UNIT;
        }
    }
    private static int inputBuyingAmount(){
        int buyingAmount = checkIfInteger(Console.readLine());
        if(buyingAmount == STOP_VALUE) return STOP_VALUE;
        return checkIf1000Unit(buyingAmount);
    }

    private static int checkIfInteger(String inputAmountString){
        int buyingAmount = 0;
        try{
            buyingAmount = Integer.parseInt(inputAmountString);
        }
        catch(Exception e) {
            System.out.println("[ERROR] 구입 금액은 항상 정수로만 입력해야 합니다.");
            return STOP_VALUE;
        }
        return buyingAmount;
    }

    private static int checkIf1000Unit(int buyingAmount){
        try{
            if (buyingAmount % AMOUNT_UNIT != 0) throw new IllegalArgumentException();
        }
        catch(Exception e){
            System.out.println("[ERROR] 구입 금액은 항상 1000워 단위로 입력하셔야 합니다.");
            return STOP_VALUE;
        }
        return buyingAmount;
    }

}