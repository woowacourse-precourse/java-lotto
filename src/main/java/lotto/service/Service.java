package lotto.service;

import lotto.domain.Lotto;
import lotto.utils.Utils;
import lotto.validation.Validation;

import java.util.Collections;
import java.util.List;

public class Service {
    private static final int LOTTO_START_NUMBER=1;
    private static final int LOTTO_LAST_NUMBER=45;
    private static final int LOTTO_LENGTH=6;

    public Lotto generateLottoNumber(){
        List<Integer> numbers = Utils.randomUniqueNumberGenerate(LOTTO_START_NUMBER, LOTTO_LAST_NUMBER, LOTTO_LENGTH);

        Validation.validateLengthOfList(numbers, LOTTO_LENGTH);
        Validation.validateDuplicationList(numbers);
        Validation.validateListNumberInRange(numbers, LOTTO_START_NUMBER, LOTTO_LAST_NUMBER);

        Utils.sortListNaturalOrder(numbers);
        return new Lotto(numbers);
    }
}
