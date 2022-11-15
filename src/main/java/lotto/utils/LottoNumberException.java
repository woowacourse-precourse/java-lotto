package lotto.utils;

public class LottoNumberException extends RuntimeException {
    public LottoNumberException() {
        super("[ERROR] 1 ~ 45 사이의 숫자를 입력해주세요.");
    }
}
