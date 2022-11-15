package lotto;

public class Number_of_Lotto {
    private static final int LOTTO_PRICE = 1000;
    private final int Money;
    private static final String ERROR_INVALID = "[ERROR] 유효하지 않은 입력입니다.";

    public Number_of_Lotto(int Money) {
        try{
            validate(Money);
        }
        catch (IllegalArgumentException e){
            Money = 0;
            System.out.println(e.getMessage());
        }
        this.Money = Money;
    }
    private void validate(int Money) throws IllegalArgumentException{
        if (Money % LOTTO_PRICE != 0){
            throw new IllegalArgumentException(ERROR_INVALID);
        }
        if (Money == 0){
            throw new IllegalArgumentException(ERROR_INVALID);
        }
    }
    public int getMoney(){
        return this.Money;
    }
    public int Count_Number_of_Lotto(){
        return Money/LOTTO_PRICE;
    }

}
