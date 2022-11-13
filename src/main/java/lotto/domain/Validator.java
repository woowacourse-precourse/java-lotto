package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public void validateLottoNumbers(List<Integer> lottoNumbers) {
        Set<Integer> distinctNumbers = new HashSet<>(lottoNumbers);

        if (distinctNumbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
}
