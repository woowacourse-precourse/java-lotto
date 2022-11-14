package lotto;

import lotto.validator.Validator;
import lotto.util.RandomNumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

class RandomNumberGeneratorTest {

    @Test
    void 랜덤_넘버_생성시_로또_검증기를_통과() {
        List<Integer> lottoNumbers = RandomNumberGenerator.makeRandomNumbers();
        Validator.validateLottoNumberDuplicates(lottoNumbers);
        Validator.validateLottoNumberRange(lottoNumbers);
    }

}