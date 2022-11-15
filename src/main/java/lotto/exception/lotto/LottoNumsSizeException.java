package lotto.exception.lotto;

public class LottoNumsSizeException extends IllegalArgumentException{
    public LottoNumsSizeException() {
        super("[ERROR] 로또 번호는 6개여야 합니다.");
    }
}
