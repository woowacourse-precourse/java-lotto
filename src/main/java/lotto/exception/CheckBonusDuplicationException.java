package lotto.exception;

public class CheckBonusDuplicationException extends IllegalArgumentException{
    public CheckBonusDuplicationException(){
        super("[ERROR] : 보너스숫자는 로또번호와 중복되지 않아야 합니다.");
    }
}
