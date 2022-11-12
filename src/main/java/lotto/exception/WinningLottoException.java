package lotto.exception;

import java.util.ArrayList;
import java.util.List;

public class WinningLottoException {
    private final static int MIN_LOTTO_NUMBER = 1;
    private final static int MAX_LOTTO_NUMBER = 45;
    public void validate(List<Integer> winningLotto) {
        List<Integer> uniqueLottoNumbers = new ArrayList<>();
        for (Integer lottoNumber : winningLotto) {
            validateLottoNumberRange(lottoNumber);
            if (uniqueLottoNumbers.contains(lottoNumber)) {
                System.out.println("[ERROR] 서로 중복되지 않는 숫자를 입력해야 합니다.");
                throw new IllegalArgumentException();
            }
            uniqueLottoNumbers.add(lottoNumber);
        }
    }

    public void validateLottoNumberRange(int lottoNumber) {
        if (lottoNumber < MIN_LOTTO_NUMBER || lottoNumber > MAX_LOTTO_NUMBER) {
            System.out.println("[ERROR] 1부터 45 사이 숫자만 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
    }
}
