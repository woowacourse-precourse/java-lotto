package lotto.exception.userLottos;

public class LottoZeroException extends IllegalArgumentException{
    public LottoZeroException() {
        super("[ERROR] 발행할 로또 개수는 적어도 하나 이상이여야 합니다.");
    }
}
