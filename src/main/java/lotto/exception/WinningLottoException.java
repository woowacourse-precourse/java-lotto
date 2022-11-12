package lotto.exception;

import java.util.ArrayList;
import java.util.List;

public class WinningLottoException {
    private final static int MIN_LOTTO_NUMBER = 1;
    private final static int MAX_LOTTO_NUMBER = 45;
    public void validate(List<Integer> winningLotto) {
        List<Integer> uniqueLottoNumbers = new ArrayList<>();
        for (Integer lottoNumber : winningLotto) {
            if (uniqueLottoNumbers.contains(lottoNumber) || isOutOfLottoNumberRange(lottoNumber)) {
                System.out.println("[ERROR] 1부터 45 사이 중복되지 않는 숫자를 입력해야 합니다.");
                throw new IllegalArgumentException();
            }
            uniqueLottoNumbers.add(lottoNumber);
        }
    }

    private boolean isOutOfLottoNumberRange(int lottoNumber) {
        return lottoNumber < MIN_LOTTO_NUMBER || lottoNumber > MAX_LOTTO_NUMBER;
    }
}
