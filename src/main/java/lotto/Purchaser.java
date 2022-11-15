package lotto;

import camp.nextstep.edu.missionutils.Console;


public class Purchaser {

    private static final Long LOTTO_PRICE = 1_000L;

    private static Long purchaseAmount;

    public static Long setPurchaseAmount(){
//        금액을 정확히 입력했는지 확인
        String inputMoney = Console.readLine();
        System.out.println("inputMoney: " + inputMoney);
        if (validPurchaseAmount(inputMoney)){
            purchaseAmount = Long.parseLong(inputMoney);
        }
        return purchaseAmount;
    }

    public static boolean validPurchaseAmount(String inputMoney) throws IllegalArgumentException{
//        숫자로 입력했는지, 아니면 Exception
        try{
            Long temp = Long.parseLong(inputMoney);
        }
        catch(Exception e){
            Error.NOT_NUMERIC.wrongInput();
        }
//        1000단위가 아닌 경우
        if (Long.parseLong(inputMoney) % LOTTO_PRICE != 0){
            Error.PURCHASE_AMOUNT_ERROR.wrongInput();
        }
        return true;
    }
}
