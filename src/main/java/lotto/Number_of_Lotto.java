package lotto;

public class Number_of_Lotto {
    private static final int LOTTO_PRICE = 1000;
    private final int Money;
    private static final String ERROR_NOT_DIVIDE = "[ERROR] 1000원 단위에 금액을 입력하세요.";

    public Number_of_Lotto(int Money) {
        validate(Money);
        this.Money = Money;
    }
    private void validate(int Money){
        if (Money % LOTTO_PRICE != 0){
            throw new IllegalArgumentException(ERROR_NOT_DIVIDE);
        }
    }
    public int getMoney(){
        return this.Money;
    }
    public int Count_Number_of_Lotto(){
        return Money/LOTTO_PRICE;
    }

}
