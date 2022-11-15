package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;


public class Purchaser {

    private static final Long LOTTO_PRICE = 1_000L;

    private static long purchaseAmount;
    private static long lottoNum;
    protected static List[] numbers;

    protected static long setPurchaseAmount(){
        String inputMoney = Console.readLine();
        // 금액을 정확히 입력했는지 확인
        if (validPurchaseAmount(inputMoney)){
            purchaseAmount = Long.parseLong(inputMoney);
        }
        return purchaseAmount;
    }

    protected static boolean validPurchaseAmount(String inputMoney) throws IllegalArgumentException{
//        숫자로 입력했는지, 아니면 Exception
        try{
            long temp = Long.parseLong(inputMoney);
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

    protected static void calculateLottoNum(){
        lottoNum = purchaseAmount / LOTTO_PRICE;
    }

    protected static void pickRandomNumbers(){
        numbers = new List [(int)lottoNum];

        for(int i = 0; i < (int)lottoNum ; ++i){
            numbers[i] = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        }
    }

    public Long getLottoNum(){
        return this.lottoNum;
    }
}
