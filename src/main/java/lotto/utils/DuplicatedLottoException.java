package lotto.utils;

public class DuplicatedLottoException extends RuntimeException{
    public DuplicatedLottoException() {
        super("[ERROR] 중복된 번호 입력입니다.");
    }
}
