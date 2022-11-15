package lotto.exception.money;

public class MoneyDividePriceException extends IllegalArgumentException{
    private static final String NO_DIVIDE_PRICE_EXCEPTION_MESSAGE = "[ERROR] %d원 단위의 금액을 입력 해야합니다.";

    public MoneyDividePriceException(int price){
        super(String.format(NO_DIVIDE_PRICE_EXCEPTION_MESSAGE, price));
    }
}
