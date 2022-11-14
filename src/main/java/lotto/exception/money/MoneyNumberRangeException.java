package lotto.exception.money;

public class MoneyNumberRangeException extends IllegalArgumentException{
    private static final String EXCEPTION_MESSAGE_OVER_NUMBER_RANGE = "[ERROR] 최소 %d원, 최대%d원 만큼 구매 가능합니다.";

    public MoneyNumberRangeException(int maxPurchase, int minPurchase){
        super(String.format(EXCEPTION_MESSAGE_OVER_NUMBER_RANGE, maxPurchase, minPurchase));
    }

}
