package lotto.exception;

public class DuplicatedBonusNumberException extends IllegalArgumentException {
    public DuplicatedBonusNumberException() {
        super("보너스 번호는 로또 번호들과 달라야합니다.");
    }
}
