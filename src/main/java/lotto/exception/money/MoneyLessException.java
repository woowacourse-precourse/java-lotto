package lotto.exception.money;

public class MoneyLessException extends IllegalArgumentException{
    public MoneyLessException() {
        super("[ERROR] 구입 금액은 1000원보다 커야합니다.");
    }
}
