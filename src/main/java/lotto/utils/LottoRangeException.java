package lotto.utils;

public class LottoRangeException extends RuntimeException {
    public LottoRangeException() {
        super("[ERROR] 1 ~ 45 사이의 숫자를 입력해주세요.");
    }
}
