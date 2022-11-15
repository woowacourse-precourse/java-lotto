package lotto.exception.lotto;

public class LottoNumRangeException extends IllegalArgumentException {
    public LottoNumRangeException() {
        super("[ERROR] 자동으로 생성된 로또 번호의 범위가 올바르지 않습니다.");
    }
}

