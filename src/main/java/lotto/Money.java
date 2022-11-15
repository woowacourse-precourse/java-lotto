package lotto;

public class Money {

    private final String Money_Input;

    public Money(String Money_Input) {
        Money_Validate(Money_Input);
        this.Money_Input = Money_Input;
    }

    private void Money_Validate(String Input) {
        try {
            Integer money = Integer.parseInt(Input);
            Integer remainder = money % 1000;
            if (remainder != 0) {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위의 숫자여야 합니다.");
        }
    }
}
