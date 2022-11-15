package lotto.exception.money;

public class MoneyUnitWrongException extends IllegalArgumentException{
    public MoneyUnitWrongException() {
        super("[ERROR] 구입 금액은 1000원 단위만 입력해야 합니다.");
    }
}
