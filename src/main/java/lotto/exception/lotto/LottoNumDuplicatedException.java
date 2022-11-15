package lotto.exception.lotto;

public class LottoNumDuplicatedException extends IllegalArgumentException{
    public LottoNumDuplicatedException() {
        super("[ERROR] 자동으로 생성된 로또 번호 중 중복되는 숫자가 있습니다.");
    }
}
