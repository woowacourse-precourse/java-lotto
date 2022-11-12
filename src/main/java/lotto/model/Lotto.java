package lotto.model;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> lottoNumber;

    public Lotto(List<Integer> lottoNumber) {
        validate(lottoNumber);
        Collections.sort(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validate(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return this.lottoNumber.toString();
    }

}
