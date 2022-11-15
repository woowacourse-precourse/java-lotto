package lotto.domain.lotto.lotto;

import static lotto.domain.lotto.lotto.LottoInfo.*;

import java.util.List;

public class Lotto {

    private final List<Integer> lottoNumbers;

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public Lotto(List<Integer> lottoNumbers) {
        validateLottoSize(lottoNumbers);
        validateDuplicatedLottoNumber(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }


    private void validateLottoSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void validateDuplicatedLottoNumber(List<Integer> lottoNumbers) {
        long count = lottoNumbers.stream().distinct().count();
        if (count < LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
